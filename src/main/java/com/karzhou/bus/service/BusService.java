package com.karzhou.bus.service;

import com.karzhou.bus.entity.Bus;
import java.util.List;

public interface BusService {

    List<Bus> findBusesByTrail(List<Bus> buses, String trail);

    List<Bus> findBusesByOperationPeriod(List<Bus> buses, int years);

    List<Bus> findBusesByMileage(List<Bus> buses, float mileage);
}
