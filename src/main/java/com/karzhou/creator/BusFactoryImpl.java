package com.karzhou.creator;

import com.karzhou.entity.Bus;
import com.karzhou.validator.BusValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;


public class BusFactoryImpl implements BusFactory {
    private static final Logger logger = LogManager.getLogger(BusFactoryImpl.class);
    private final BusValidatorImpl busValidatorImpl;


    public BusFactoryImpl(BusValidatorImpl busValidatorImpl) {
        this.busValidatorImpl = busValidatorImpl;
    }

    @Override
    public Bus createBus(String driverName,
                         String driverSurname,
                         String busNumber,
                         String trail,
                         String busBrand,
                         LocalDate startOfOperation,
                         float mileage) {

        logger.debug("Creating a new Bus instance with driverName: {}, driverSurname: {}, busNumber: {}, trail: {}, busBrand: {}, startOfOperation: {}, mileage: {}",
                driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        Bus bus = new Bus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        try {
            busValidatorImpl.validate(bus);
            logger.info("Bus validation successful for busNumber: {}", busNumber);
        } catch (Exception e) {
            logger.error("Bus validation failed : {}", bus.toString(), e);
        }

        logger.info("Bus created successfully: {}", bus);
        return bus;
    }
}