package com.karzhou.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.Date;
import java.util.Objects;

public class Bus {
    @NotBlank(message = "Driver name must not be empty")
    public String driverName;
    @NotBlank(message = "Driver surname must not be empty")
    public String driverSurname;
    @NotBlank(message = "The bus must have number")
    @Pattern(regexp = "^[АВЕІКМНОРСТХA-Z]{2}\\d{4}-[0-7]$", message = "The bus number must match Belarusian " +
            "laws \"AX7506-7\"")
    public String busNumber;
    @NotBlank(message="The trail must not be empty")
    @Pattern(regexp = "^\\d{1,2}$|^\\d{3}[A-Z]?$|^\\d{3,4}$", message="Thee trail must match for " +
            "city: \"12\"" +
            "suburb: \"112A\"" +
            "intercity: \"1112\"")
    public String trail;
    @NotBlank(message = "The brand must not be empty")
    public String busBrand;
    public Date startOfOperation;
    @Positive(message = "Mileage can not be less than zero")
    public float mileage;

    // Constructor
    public Bus(String driverName,
               String driverSurname,
               String busNumber,
               String trail,
               String busBrand,
               Date startOfOperation,
               float mileage) {
        this.driverName = driverName;
        this.driverSurname = driverSurname;
        this.busNumber = busNumber;
        this.trail = trail;
        this.busBrand = busBrand;
        this.startOfOperation = startOfOperation;
        this.mileage = mileage;
    }

    // Setters
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }
    public void setTrail(String trail) {
        this.trail = trail;
    }
    public void setBusBrand(String busBrand) {
        this.busBrand = busBrand;
    }
    public void setStartOfOperation(Date startOfOperation) {
        this.startOfOperation = startOfOperation;
    }
    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    // Getters
    public String getDriverName() {
        return driverName;
    }
    public String getDriverSurname() {
        return driverSurname;
    }
    public String getBusNumber() {
        return busNumber;
    }
    public String getTrail() {
        return trail;
    }
    public String getBusBrand() {
        return busBrand;
    }
    public Date getStartOfOperation() {
        return startOfOperation;
    }
    public float getMileage() {
        return mileage;
    }

    // toString
    @Override
    public String toString() {
        return "Bus{" +
                "driverName='" + driverName + '\'' +
                ", driverSurname='" + driverSurname + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", trail='" + trail + '\'' +
                ", busBrand='" + busBrand + '\'' +
                ", startOfOperation=" + startOfOperation +
                ", mileage=" + mileage +
                '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(driverName, driverSurname, busNumber, trail, busBrand, startOfOperation, mileage);
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bus bus = (Bus) obj;
        return Float.compare(bus.mileage, mileage) == 0 &&
                Objects.equals(driverName, bus.driverName) &&
                Objects.equals(driverSurname, bus.driverSurname) &&
                Objects.equals(busNumber, bus.busNumber) &&
                Objects.equals(trail, bus.trail) &&
                Objects.equals(busBrand, bus.busBrand) &&
                Objects.equals(startOfOperation, bus.startOfOperation);
    }
}