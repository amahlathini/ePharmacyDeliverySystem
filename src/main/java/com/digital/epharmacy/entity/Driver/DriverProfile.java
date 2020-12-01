package com.digital.epharmacy.entity.Driver;

import com.digital.epharmacy.entity.Order.Order;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


/*
    Author: Chad Boswell
<<<<<<< HEAD
    Desc: DriverProfile entity composed DriverProfile and DriverCar that stores details of the Driver and car
=======
    Desc: Driver entity composed Driver and DriverCar that stores details of the Driver and car
>>>>>>> origin/groupCollaboration
    Date: 4 July 2020

    Update: 27/10/20
    Modified: added noBlank validation and created a composite relation between driver profile and car and hash set
              one to one relationship
 */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key
 and changed default constructor to protected
 * Date: 25/10/2020
 * */

@Entity
@Table(name = "drivers")
public class DriverProfile {

    @Id
    @GeneratedValue(generator = "DRIVER-generator")
    @GenericGenerator(name = "DRIVER-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "DRIVER"),
            strategy = "com.digital.epharmacy.util.CustomIDGenerator")
    @Column(name= "id")
    private String id;
    @NotNull(message = "Driver Name is required")
    private String driver_name;
    @NotNull(message = "Driver Surname is required")
    private String driver_surname;
    @Embedded
    private DriverLocation driver_location;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();
    @Embedded
    private DriverCar car;





    protected DriverProfile() {}

    // builder pattern method constructor
    private DriverProfile(Builder builder){
        this.id = builder.id;
        this.driver_name = builder.driver_name;
        this.driver_surname = builder.driver_surname;
        this.driver_location = builder.driver_location;
        this.orders = builder.orders;
    }
// HEAD
    // getters for all attributes of entity DriverProfile

    // getters for all attributes of entity Driver
// origin/groupCollaboration


    public String getId() {
        return id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public String getDriver_surname() {
        return driver_surname;
    }

    public DriverLocation getDriver_location() {
        return driver_location;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public DriverCar getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "DriverProfile{" +
                "id=" + id +
                ", driver_name='" + driver_name + '\'' +
                ", driver_surname='" + driver_surname + '\'' +
                ", driver_location=" + driver_location +
                ", orders=" + orders +
                ", car=" + car +
                '}';
    }

    // add setters using building pattern
    public static class Builder{

        private String id;
        private String driver_name, driver_surname;
        private DriverCar car;

        private Set<Order> orders = new HashSet<>();

        private DriverLocation driver_location;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDriver_name(String driver_name) {
            this.driver_name = driver_name;
            return this;
        }

        public Builder setDriver_surname(String driver_surname) {
            this.driver_surname = driver_surname;
            return this;
        }

        public Builder setCar(DriverCar car) {
            this.car = car;
            return this;
        }

        public Builder setOrders(Set<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Builder setDriver_location(DriverLocation driver_location) {
            this.driver_location = driver_location;
            return this;
        }

        //to below method is to make another copy of driverProfile
        public Builder copy (DriverProfile driverProfile){
            this.id = driverProfile.id;
            this.driver_name = driverProfile.driver_name;
            this.driver_surname = driverProfile.driver_surname;
            this.driver_location = driverProfile.driver_location;
            this.orders = driverProfile.orders;
            this.car = driverProfile.car;
            return this;
        }
        // creating an instance for the builder pattern
        public DriverProfile builder(){
            return new DriverProfile(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverProfile that = (DriverProfile) o;
        return id.equals(that.id) &&
                driver_name.equals(that.driver_name) &&
                driver_surname.equals(that.driver_surname) &&
                Objects.equals(driver_location, that.driver_location) &&
                Objects.equals(orders, that.orders) &&
                car.equals(that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driver_name, driver_surname, driver_location, orders, car);
    }
}
