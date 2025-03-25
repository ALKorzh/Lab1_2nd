package com.karzhou;

import com.karzhou.entity.Bus;
import com.karzhou.creator.BusFactory;
import com.karzhou.service.BusService;
import com.karzhou.validator.BusValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        BusValidator busValidator = new BusValidator();
        BusFactory busFactory = new BusFactory(busValidator);
        BusService busService = new BusService();

        // Создаем массив объектов Bus
        List<Bus> buses = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        buses.add(busFactory.createBus("Ivan", "Ivanov", "AX7506-7", "12", "MAZ", LocalDate.parse("2015-05-10"), 120000));
        buses.add(busFactory.createBus("Petr", "Petrov", "AX1234-5", "112A", "MAZ", LocalDate.parse("2010-03-15"), 200000));
        buses.add(busFactory.createBus("Sidor", "Sidorov", "AX5678-3", "1112", "MAZ", LocalDate.parse("2018-07-20"), 80000));

        // Вывод списка автобусов для заданного номера маршрута
        String trailNumber = "12";
        List<Bus> busesByTrail = busService.findBusesByTrail(buses, trailNumber);
        System.out.println("Buses on route " + trailNumber + ":");
        for (Bus bus : busesByTrail) {
            System.out.println(bus.getBusNumber() + " - " + bus.getDriverName() + " " + bus.getDriverSurname());
        }

        // Вывод списка автобусов, которые эксплуатируются больше заданного срока
        int operationYears = 10;
        List<Bus> busesByOperationPeriod = busService.findBusesByOperationPeriod(buses, operationYears);
        System.out.println("\nBuses operated more than " + operationYears + " years:");
        for (Bus bus : busesByOperationPeriod) {
            System.out.println(bus.getBusNumber() + " - " + bus.getDriverName() + " " + bus.getDriverSurname());
        }

        // Вывод списка автобусов, пробег у которых больше заданного расстояния
        float mileage = 100000;
        List<Bus> busesByMileage = busService.findBusesByMileage(buses, mileage);
        System.out.println("\nBuses with mileage more than " + mileage + " km:");
        for (Bus bus : busesByMileage) {
            System.out.println(bus.getBusNumber() + " - " + bus.getDriverName() + " " + bus.getDriverSurname());
        }
    }
}