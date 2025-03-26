package com.karzhou.bus.service.impl;

import com.karzhou.bus.entity.Bus;
import com.karzhou.bus.service.BusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class BusServiceImpl implements BusService {
    private static final long MILLISECONDS_PER_YEAR = 1000L * 60 * 60 * 24 * 365;
    private static final Logger logger = LogManager.getLogger(BusServiceImpl.class);

    @Override
    public List<Bus> findBusesByTrail(List<Bus> buses, String trail) {
        logger.debug("Searching buses by trail: {}", trail);

        List<Bus> result = buses.stream()
                .filter(bus -> bus.getTrail().equals(trail))
                .toList();


        logger.info("Found {} buses for trail: {}", result.size(), trail);
        return result;
    }

    @Override
    public List<Bus> findBusesByOperationPeriod(List<Bus> buses, int years) {
        logger.debug("Searching buses by operation period (more than {} years)", years);

        List<Bus> result = buses.stream()
                .filter(bus -> {
                    long diffInMillis = ChronoUnit.MILLIS.between(bus.getStartOfOperation().atStartOfDay(), LocalDate.now().atStartOfDay());
                    long diffInYears = diffInMillis / (MILLISECONDS_PER_YEAR);
                    return diffInYears > years;
                })
                .toList();


        logger.info("Found {} buses with operation period more than {} years", result.size(), years);
        return result;
    }

    @Override
    public List<Bus> findBusesByMileage(List<Bus> buses, float mileage) {
        logger.debug("Searching buses by mileage (more than {} km)", mileage);

        List<Bus> result = buses.stream()
                .filter(bus -> bus.getMileage() > mileage)
                .toList();


        logger.info("Found {} buses with mileage more than {} km", result.size(), mileage);
        return result;
    }
}