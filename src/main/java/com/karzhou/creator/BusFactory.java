package com.karzhou.creator;

import com.karzhou.entity.Bus;
import com.karzhou.validator.BusValidator;

import java.util.Date;

public class BusFactory {

    private final BusValidator busValidator;

    public BusFactory(BusValidator busValidator) {
        this.busValidator = busValidator;
    }

    public Bus createBus(String driverName,
                         String driverSurname,
                         String busNumber,
                         String trail,
                         String busBrand,
                         Date startOfOperation,
                         float mileage) {

        Bus bus = new Bus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        busValidator.validate(bus);

        return bus;
    }
}
