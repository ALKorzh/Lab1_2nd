package com.karzhou.bus.creator;

import com.karzhou.bus.entity.Bus;
import java.time.LocalDate;


public interface BusFactory {


    default Bus createBus(String driverName,
                                 String driverSurname,
                                 String busNumber,
                                 String trail,
                                 String busBrand,
                                 LocalDate startOfOperation,
                                 float mileage) {
        return new Bus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);
    }
}
