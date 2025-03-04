package com.karzhou.service;

import com.karzhou.entity.Bus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusServiceTest {

    private BusService busService;
    private List<Bus> buses;

    @BeforeMethod
    public void setUp() {
        busService = new BusService();
        buses = new ArrayList<>();

        buses.add(new Bus("John", "Doe", "AX7506-7", "12", "Mercedes", new Date(System.currentTimeMillis() - (5L * 365 * 24 * 60 * 60 * 1000)), 15000.5f));
        buses.add(new Bus("Jane", "Smith", "AX1234-5", "112A", "Volvo", new Date(System.currentTimeMillis() - (3L * 365 * 24 * 60 * 60 * 1000)), 8000.0f));
        buses.add(new Bus("Alice", "Johnson", "AX5678-9", "12", "Scania", new Date(System.currentTimeMillis() - (7L * 365 * 24 * 60 * 60 * 1000)), 20000.0f));
    }

    @Test
    public void testGetBusesByTrail() {
        // Arrange
        String trail = "12";

        // Act
        List<Bus> result = busService.getBusesByTrail(buses, trail);

        // Assert
        Assertions.assertThat(result).hasSize(2); // Ожидаем 2 автобуса с маршрутом "12"
        Assertions.assertThat(result).extracting(Bus::getTrail).containsOnly(trail);
    }

    @Test
    public void testGetBusesByOperationPeriod() {
        // Arrange
        int years = 4;

        // Act
        List<Bus> result = busService.getBusesByOperationPeriod(buses, years);

        // Assert
        Assertions.assertThat(result).hasSize(2); // Ожидаем 2 автобуса с периодом эксплуатации больше 4 лет
        Assertions.assertThat(result).extracting(Bus::getDriverName).containsExactlyInAnyOrder("John", "Alice");
    }

    @Test
    public void testGetBusesByMileage() {
        // Arrange
        float mileage = 10000.0f;

        // Act
        List<Bus> result = busService.getBusesByMileage(buses, mileage);

        // Assert
        Assertions.assertThat(result).hasSize(2); // Ожидаем 2 автобуса с пробегом больше 10000
        Assertions.assertThat(result).extracting(Bus::getDriverName).containsExactlyInAnyOrder("John", "Alice");
    }
}