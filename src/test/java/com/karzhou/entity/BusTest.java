package com.karzhou.entity;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Date;

public class BusTest {

    @Test
    public void testBusConstructorAndGetters() {
        // Arrange
        String driverName = "John";
        String driverSurname = "Doe";
        String busNumber = "AX7506-7";
        String trail = "12";
        String busBrand = "Mercedes";
        Date startOfOperation = new Date();
        float mileage = 10000.5f;

        // Act
        Bus bus = new Bus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        // Assert
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(bus.getDriverName()).isEqualTo(driverName);
        softly.assertThat(bus.getDriverSurname()).isEqualTo(driverSurname);
        softly.assertThat(bus.getBusNumber()).isEqualTo(busNumber);
        softly.assertThat(bus.getTrail()).isEqualTo(trail);
        softly.assertThat(bus.getBusBrand()).isEqualTo(busBrand);
        softly.assertThat(bus.getStartOfOperation()).isEqualTo(startOfOperation);
        softly.assertThat(bus.getMileage()).isEqualTo(mileage);
        softly.assertAll();
    }

    @Test
    public void testBusSetters() {
        // Arrange
        Bus bus = new Bus("John", "Doe", "AX7506-7", "12", "Mercedes", new Date(), 10000.5f);
        String newDriverName = "Jane";
        String newDriverSurname = "Smith";
        String newBusNumber = "BX8507-6";
        String newTrail = "112A";
        String newBusBrand = "Volvo";
        Date newStartOfOperation = new Date();
        float newMileage = 15000.0f;

        // Act
        bus.setDriverName(newDriverName);
        bus.setDriverSurname(newDriverSurname);
        bus.setBusNumber(newBusNumber);
        bus.setTrail(newTrail);
        bus.setBusBrand(newBusBrand);
        bus.setStartOfOperation(newStartOfOperation);
        bus.setMileage(newMileage);

        // Assert
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(bus.getDriverName()).isEqualTo(newDriverName);
        softly.assertThat(bus.getDriverSurname()).isEqualTo(newDriverSurname);
        softly.assertThat(bus.getBusNumber()).isEqualTo(newBusNumber);
        softly.assertThat(bus.getTrail()).isEqualTo(newTrail);
        softly.assertThat(bus.getBusBrand()).isEqualTo(newBusBrand);
        softly.assertThat(bus.getStartOfOperation()).isEqualTo(newStartOfOperation);
        softly.assertThat(bus.getMileage()).isEqualTo(newMileage);
        softly.assertAll();
    }
}