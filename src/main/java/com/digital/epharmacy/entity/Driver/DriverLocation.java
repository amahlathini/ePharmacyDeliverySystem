package com.digital.epharmacy.entity.Driver;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DriverLocation implements Serializable {
    private double Longitude, latitude;

    public DriverLocation(double Longitude, double latitude) {
        this.Longitude = Longitude;
        this.latitude = latitude;
    }

    protected DriverLocation() {
        
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
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
                "Longitude=" + Longitude +
                ", latitude=" + latitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverLocation location = (DriverLocation) o;
        return Double.compare(location.Longitude, Longitude) == 0 &&
                Double.compare(location.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Longitude, latitude);
    }
}
