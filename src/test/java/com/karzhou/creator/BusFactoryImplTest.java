package com.karzhou.creator;

import com.karzhou.bus.creator.impl.BusFactoryImpl;
import com.karzhou.bus.entity.Bus;
import com.karzhou.bus.validator.impl.BusValidatorImpl;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Optional;

public class BusFactoryImplTest {

    private BusFactoryImpl busFactoryImpl;
    private BusValidatorImpl busValidatorImpl;

    @BeforeMethod
    public void setUp() {
        busValidatorImpl = new BusValidatorImpl();
        busFactoryImpl = new BusFactoryImpl(busValidatorImpl);
    }

    @Test
    public void testCreateBus_ValidInput_ShouldReturnBus() {
        // Arrange
        String driverName = "John";
        String driverSurname = "Doe";
        String busNumber = "AX7506-7";
        String trail = "123";
        String busBrand = "Mercedes";
        LocalDate startOfOperation = LocalDate.now();
        float mileage = 1000.5f;

        // Act
        Optional<Bus> bus1 = busFactoryImpl.createBus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        // Assert
        Assertions.assertThat(bus1).isNotEmpty();
        bus1.ifPresent(bus -> {
            Assertions.assertThat(bus.getDriverName()).isEqualTo(driverName);
            Assertions.assertThat(bus.getDriverSurname()).isEqualTo(driverSurname);
            Assertions.assertThat(bus.getBusNumber()).isEqualTo(busNumber);
            Assertions.assertThat(bus.getTrail()).isEqualTo(trail);
            Assertions.assertThat(bus.getBusBrand()).isEqualTo(busBrand);
            Assertions.assertThat(bus.getStartOfOperation()).isEqualTo(startOfOperation);
            Assertions.assertThat(bus.getMileage()).isEqualTo(mileage);
        });
    }

    @Test
    public void testCreateBus_InvalidInput_ShouldReturnEmpty() {
        // Arrange
        String driverName = "";  // Некорректное имя водителя
        String driverSurname = "Doe";
        String busNumber = "1234";
        String trail = "Trail123";
        String busBrand = "Mercedes";
        LocalDate startOfOperation = LocalDate.now();
        float mileage = 1000.5f;

        // Act
        Optional<Bus> bus1 = busFactoryImpl.createBus(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);

        // Assert
        Assertions.assertThat(bus1).isEmpty();
    }
}
