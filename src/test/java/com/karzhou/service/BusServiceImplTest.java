package com.karzhou.service;

import com.karzhou.entity.Bus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusServiceImplTest {

    private BusServiceImpl busServiceImpl;
    private List<Bus> buses;

    @BeforeMethod
    public void setUp() {
        busServiceImpl = new BusServiceImpl();
        buses = new ArrayList<>();

        buses.add(new Bus("John", "Doe", "AX7506-7", "12", "Mercedes", LocalDate.now().minusYears(5), 15000.5f));
        buses.add(new Bus("Jane", "Smith", "AX1234-5", "112A", "Volvo", LocalDate.now().minusYears(3), 8000.0f));
        buses.add(new Bus("Alice", "Johnson", "AX5678-9", "12", "Scania", LocalDate.now().minusYears(7), 20000.0f));

    }

    @Test
    public void testFindBusesByTrail() {
        // Arrange
        String trail = "12";

        // Act
        List<Bus> result = busServiceImpl.findBusesByTrail(buses, trail);

        // Assert
        Assertions.assertThat(result).hasSize(2); // Ожидаем 2 автобуса с маршрутом "12"
        Assertions.assertThat(result).extracting(Bus::getTrail).containsOnly(trail);
    }

    @Test
    public void testFindBusesByOperationPeriod() {
        // Arrange
        int years = 4;

        // Act
        List<Bus> result = busServiceImpl.findBusesByOperationPeriod(buses, years);

        // Assert
        Assertions.assertThat(result).hasSize(2); // Ожидаем 2 автобуса с периодом эксплуатации больше 4 лет
        Assertions.assertThat(result).extracting(Bus::getDriverName).containsExactlyInAnyOrder("John", "Alice");
    }

    @Test
    public void testFindBusesByMileage() {
        // Arrange
        float mileage = 10000.0f;

        // Act
        List<Bus> result = busServiceImpl.findBusesByMileage(buses, mileage);

        // Assert
        Assertions.assertThat(result).hasSize(2); // Ожидаем 2 автобуса с пробегом больше 10000
        Assertions.assertThat(result).extracting(Bus::getDriverName).containsExactlyInAnyOrder("John", "Alice");
    }
}