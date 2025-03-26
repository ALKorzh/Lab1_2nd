package com.karzhou.service;

import com.karzhou.entity.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface BusService {
    static final Logger logger = LogManager.getLogger(BusService.logger);

    public List<Bus> findBusesByTrail(List<Bus> buses, String trail);

    public List<Bus> findBusesByOperationPeriod(List<Bus> buses, int years);

    public List<Bus> findBusesByMileage(List<Bus> buses, float mileage);
}
