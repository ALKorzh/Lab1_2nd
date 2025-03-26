package com.karzhou.bus.service;

import com.karzhou.bus.entity.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class BusServiceImpl implements BusService {

    private static final Logger logger = LogManager.getLogger(BusServiceImpl.class);

    @Override
    public List<Bus> findBusesByTrail(List<Bus> buses, String trail) { // find
        logger.debug("Searching buses by trail: {}", trail);

        List<Bus> result = buses.stream()
                .filter(bus -> bus.getTrail().equals(trail))
                .collect(Collectors.toList());


        logger.info("Found {} buses for trail: {}", result.size(), trail);
        return result;
    }

    @Override
    public List<Bus> findBusesByOperationPeriod(List<Bus> buses, int years) {
        logger.debug("Searching buses by operation period (more than {} years)", years);

        List<Bus> result = buses.stream()
                .filter(bus -> {
                    long diffInMillies = ChronoUnit.MILLIS.between(bus.getStartOfOperation().atStartOfDay(), LocalDate.now().atStartOfDay());
                    long diffInYears = diffInMillies / (1000L * 60 * 60 * 24 * 365);
                    return diffInYears > years;
                })
                .collect(Collectors.toList());


        logger.info("Found {} buses with operation period more than {} years", result.size(), years);
        return result;
    }

    @Override
    public List<Bus> findBusesByMileage(List<Bus> buses, float mileage) {
        logger.debug("Searching buses by mileage (more than {} km)", mileage);

        List<Bus> result = buses.stream()
                .filter(bus -> bus.getMileage() > mileage)
                .collect(Collectors.toList());


        logger.info("Found {} buses with mileage more than {} km", result.size(), mileage);
        return result;
    }
}