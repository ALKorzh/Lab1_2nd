package com.karzhou.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

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
    public LocalDate startOfOperation;
    @Positive(message = "Mileage can not be less than zero")
    public float mileage;

    // Constructor
    public Bus(String driverName,
               String driverSurname,
               String busNumber,
               String trail,
               String busBrand,
               LocalDate startOfOperation,
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
    public void setStartOfOperation(LocalDate startOfOperation) {
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
    public LocalDate getStartOfOperation() {
        return startOfOperation;
    }
    public float getMileage() {
        return mileage;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bus{")
                .append("driverName='").append(driverName).append('\'')
                .append(", driverSurname='").append(driverSurname).append('\'')
                .append(", busNumber='").append(busNumber).append('\'')
                .append(", trail='").append(trail).append('\'')
                .append(", busBrand='").append(busBrand).append('\'')
                .append(", startOfOperation=").append(startOfOperation)
                .append(", mileage=").append(mileage)
                .append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (driverName == null ? 0 : driverName.hashCode());
        result = 31 * result + (driverSurname == null ? 0 : driverSurname.hashCode());
        result = 31 * result + (busNumber == null ? 0 : busNumber.hashCode());
        result = 31 * result + (trail == null ? 0 : trail.hashCode());
        result = 31 * result + (busBrand == null ? 0 : busBrand.hashCode());
        result = 31 * result + (startOfOperation == null ? 0 : startOfOperation.hashCode());
        result = 31 * result + Float.floatToIntBits(mileage);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bus bus = (Bus) obj;
        return Float.compare(bus.mileage, mileage) == 0 &&
                (driverName == null ? bus.driverName == null : driverName.equals(bus.driverName)) &&
                (driverSurname == null ? bus.driverSurname == null : driverSurname.equals(bus.driverSurname)) &&
                (busNumber == null ? bus.busNumber == null : busNumber.equals(bus.busNumber)) &&
                (trail == null ? bus.trail == null : trail.equals(bus.trail)) &&
                (busBrand == null ? bus.busBrand == null : busBrand.equals(bus.busBrand)) &&
                (startOfOperation == null ? bus.startOfOperation == null : startOfOperation.equals(bus.startOfOperation));
    }

}
