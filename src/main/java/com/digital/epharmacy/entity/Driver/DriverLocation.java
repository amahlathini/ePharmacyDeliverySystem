package com.digital.epharmacy.entity.Driver;

import java.io.Serializable;
import java.util.Objects;

public class DriverLocation implements Serializable {
    private double Stringitude, latitude;

    public DriverLocation(double Stringitude, double latitude) {
        this.Stringitude = Stringitude;
        this.latitude = latitude;
    }

    public double getStringitude() {
        return Stringitude;
    }

    public void setStringitude(double Stringitude) {
        this.Stringitude = Stringitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Stringitude=" + Stringitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverLocation location = (DriverLocation) o;
        return Double.compare(location.Stringitude, Stringitude) == 0 &&
                Double.compare(location.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Stringitude, latitude);
    }
}
