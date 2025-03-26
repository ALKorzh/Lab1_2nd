package com.karzhou.creator;

import com.karzhou.entity.Bus;
import com.karzhou.validator.BusValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public interface BusFactory {
    static final Logger logger = LogManager.getLogger(BusFactory.logger);

    public default Bus createBus(String driverName,
                                 String driverSurname,
                                 String busNumber,
                                 String trail,
                                 String busBrand,
                                 LocalDate startOfOperation,
                                 float mileage) {
        return new Bus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);
    }
}
