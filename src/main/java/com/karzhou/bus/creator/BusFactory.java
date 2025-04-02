package com.karzhou.bus.creator;

import com.karzhou.bus.entity.Bus;
import java.time.LocalDate;
import java.util.Optional;


public interface BusFactory {


    Optional<Bus> createBus(String driverName,
                                    String driverSurname,
                                    String busNumber,
                                    String trail,
                                    String busBrand,
                                    LocalDate startOfOperation,
                                    float mileage) ;
}
