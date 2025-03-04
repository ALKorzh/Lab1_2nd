package com.karzhou.creator;

import com.karzhou.entity.Bus;
import com.karzhou.validator.BusValidator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class BusFactoryTest {

    private BusFactory busFactory;
    private BusValidator busValidator;

    @BeforeMethod
    public void setUp() {
        busValidator = new BusValidator();
        busFactory = new BusFactory(busValidator);
    }

    @Test
    public void testCreateBus_ValidInput_ShouldReturnBus() {
        // Arrange
        String driverName = "John";
        String driverSurname = "Doe";
        String busNumber = "AX7506-7";
        String trail = "123";
        String busBrand = "Mercedes";
        Date startOfOperation = new Date();
        float mileage = 1000.5f;

        // Act
        Bus bus = busFactory.createBus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        // Assert
        Assertions.assertThat(bus).isNotNull();
        Assertions.assertThat(bus.getDriverName()).isEqualTo(driverName);
        Assertions.assertThat(bus.getDriverSurname()).isEqualTo(driverSurname);
        Assertions.assertThat(bus.getBusNumber()).isEqualTo(busNumber);
        Assertions.assertThat(bus.getTrail()).isEqualTo(trail);
        Assertions.assertThat(bus.getBusBrand()).isEqualTo(busBrand);
        Assertions.assertThat(bus.getStartOfOperation()).isEqualTo(startOfOperation);
        Assertions.assertThat(bus.getMileage()).isEqualTo(mileage);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateBus_InvalidInput_ShouldThrowException() {
        // Arrange
        String driverName = "";
        String driverSurname = "Doe";
        String busNumber = "1234";
        String trail = "Trail123";
        String busBrand = "Mercedes";
        Date startOfOperation = new Date();
        float mileage = 1000.5f;

        // Act
        busFactory.createBus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);
    }
}