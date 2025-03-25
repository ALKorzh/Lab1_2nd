package com.karzhou.creator;

import com.karzhou.entity.Bus;
import com.karzhou.validator.BusValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;


public class BusFactory {

    private static final Logger logger = LogManager.getLogger(BusFactory.class);

    private final BusValidator busValidator;

    public BusFactory(BusValidator busValidator) {
        this.busValidator = busValidator;
    }

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
            busValidator.validate(bus);
            logger.info("Bus validation successful for busNumber: {}", busNumber);
        } catch (Exception e) {
            logger.error("Bus validation failed : {}", bus.toString(), e);
        }

        logger.info("Bus created successfully: {}", bus);
        return bus;
    }
}