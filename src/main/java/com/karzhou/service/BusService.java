package com.karzhou.service;

import com.karzhou.entity.Bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusService {

    public List<Bus> getBusesByTrail(List<Bus> buses, String trail) {
        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getTrail().equals(trail)) {
                result.add(bus);
            }
        }
        return result;
    }

    public List<Bus> getBusesByOperationPeriod(List<Bus> buses, int years) {
        List<Bus> result = new ArrayList<>();
        Date currentDate = new Date();
        for (Bus bus : buses) {
            long diffInMillies = Math.abs(currentDate.getTime() - bus.getStartOfOperation().getTime());
            long diffInYears = diffInMillies / (1000L * 60 * 60 * 24 * 365);
            if (diffInYears > years) {
                result.add(bus);
            }
        }
        return result;
    }

    public List<Bus> getBusesByMileage(List<Bus> buses, float mileage) {
        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                result.add(bus);
            }
        }
        return result;
    }
}
