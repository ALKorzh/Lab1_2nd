package com.karzhou.service;

import com.karzhou.entity.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusService {

    private static final Logger logger = LogManager.getLogger(BusService.class);

    public List<Bus> getBusesByTrail(List<Bus> buses, String trail) {
        logger.debug("Searching buses by trail: {}", trail);

        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getTrail().equals(trail)) {
                result.add(bus);
            }
        }

        logger.info("Found {} buses for trail: {}", result.size(), trail);
        return result;
    }

    public List<Bus> getBusesByOperationPeriod(List<Bus> buses, int years) {
        logger.debug("Searching buses by operation period (more than {} years)", years);

        List<Bus> result = new ArrayList<>();
        Date currentDate = new Date();
        for (Bus bus : buses) {
            long diffInMillies = Math.abs(currentDate.getTime() - bus.getStartOfOperation().getTime());
            long diffInYears = diffInMillies / (1000L * 60 * 60 * 24 * 365);
            if (diffInYears > years) {
                result.add(bus);
            }
        }

        logger.info("Found {} buses with operation period more than {} years", result.size(), years);
        return result;
    }

    public List<Bus> getBusesByMileage(List<Bus> buses, float mileage) {
        logger.debug("Searching buses by mileage (more than {} km)", mileage);

        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                result.add(bus);
            }
        }

        logger.info("Found {} buses with mileage more than {} km", result.size(), mileage);
        return result;
    }
}