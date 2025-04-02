package com.karzhou.bus.creator.impl;

import com.karzhou.bus.creator.BusFactory;
import com.karzhou.bus.entity.Bus;
import com.karzhou.bus.validator.impl.BusValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class BusFactoryImpl implements BusFactory {
    private static final Logger logger = LogManager.getLogger(BusFactoryImpl.class);
    private final BusValidatorImpl busValidatorImpl;

    public BusFactoryImpl(BusValidatorImpl busValidatorImpl) {
        this.busValidatorImpl = busValidatorImpl;
    }

    @Override
    public Optional<Bus> createBus(String driverName,
                                   String driverSurname,
                                   String busNumber,
                                   String trail,
                                   String busBrand,
                                   LocalDate startOfOperation,
                                   float mileage) {

        logger.debug("Creating a new Bus instance with driverName: {}, driverSurname: {}, busNumber: {}, trail: {}, busBrand: {}, startOfOperation: {}, mileage: {}",
                driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        Bus bus = new Bus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        Map<String, Boolean> validationResults = busValidatorImpl.validateAttributes(bus);
        if (!validationResults.isEmpty()) {
            logger.warn("Bus validation failed: {}", validationResults);
            return Optional.empty();
        }

        logger.info("Bus created successfully: {}", bus);
        return Optional.of(bus);
    }
}
