package com.karzhou.bus.service;

import com.karzhou.bus.entity.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface BusService {

    List<Bus> findBusesByTrail(List<Bus> buses, String trail);

    List<Bus> findBusesByOperationPeriod(List<Bus> buses, int years);

    List<Bus> findBusesByMileage(List<Bus> buses, float mileage);
}
