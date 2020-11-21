package com.digital.epharmacy.entity.Driver;

import com.digital.epharmacy.entity.Order.Order;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
;

/*
    Author: Chad
<<<<<<< HEAD
    Desc: DriverCar stores car_id using composition with DriverProfile
=======
    Desc: DriverCar stores car_id using composition with Driver
>>>>>>> origin/groupCollaboration
    Date: 4 July 2020

    Modified: added noBlank validation and created a composite relation between driver profile and car and hash set
    Date: 27/10/20
 */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key
 and changed default constructor to protected
 * Date: 25/10/2020
 * */

//@Entity
//@Table(name = "cars")
@Embeddable
public class DriverCar {

    // all the attributes of entity
//    @Id
//    @GeneratedValue
//    @Column(name = "car_id")
//    private String car_id;
    @NotNull(message = "Car Registration is required")
    private String car_registration;
    @NotNull(message = "Car Colour is required")
    private String car_colour;
    @NotNull(message = "Car name is required")
    private String car_name;
    @NotNull(message = "Car Model is required")
    private String car_model;
//    @PrimaryKeyJoinColumn(name = "driver_id")
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private DriverProfile driver;

    protected DriverCar (){}

    // builder pattern method constructor
    private DriverCar(Builder builder){
      //  this.car_id = builder.car_id;
        this.car_registration = builder.car_registration;
        this.car_colour = builder.car_colour;
        this.car_name = builder.car_name;
        this.car_model = builder.car_model;
      //  this.driver = builder.driver;
    }

    // getters for all attributes of entity DriverCar

//    public String getCar_id() {
//        return car_id;
//    }

    public String getCar_registration() {
        return car_registration;
    }

    public String getCar_colour() {
        return car_colour;
    }

    public String getCar_name() {
        return car_name;
    }

    public String getCar_model() {
        return car_model;
    }

//    public DriverProfile getDriver() {
//        return driver;
//    }

    @Override
    public String toString() {
        return "DriverCar{" +
               // "car_id=" + car_id +
                ", car_registration='" + car_registration + '\'' +
                ", car_colour='" + car_colour + '\'' +
                ", car_name='" + car_name + '\'' +
                ", car_model='" + car_model + '\'' +
             //   ", driver=" + driver +
                '}';
    }

    // add setters using building pattern
    public static class Builder{

      //  private String car_id;
        private String car_registration;
        private String car_colour, car_name, car_model;
       // private DriverProfile driver;

//        public Builder setCar_id(String car_id) {
//            this.car_id = car_id;
//            return this;
//        }

        public Builder setCar_registration(String car_registration) {
            this.car_registration = car_registration;
            return this;
        }

        public Builder setCar_colour(String car_colour) {
            this.car_colour = car_colour;
            return this;
        }

        public Builder setCar_name(String car_name) {
            this.car_name = car_name;
            return this;
        }

        public Builder setCar_model(String car_model) {
            this.car_model = car_model;
            return this;
        }

//        public Builder setDriver(DriverProfile driver) {
//            this.driver = driver;
//            return this;
//        }

        //to below method is to make another copy of DriverCar
        public Builder copy (DriverCar driverCar){
           // this.car_id = driverCar.car_id;
            this.car_registration = driverCar.car_registration;
            this.car_colour = driverCar.car_colour;
            this.car_name = driverCar.car_name;
            this.car_model = driverCar.car_model;
           // this.driver = driverCar.driver;
            return this;
        }

        // creating an instance for the builder pattern
        public DriverCar build(){
            return new DriverCar(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverCar driverCar = (DriverCar) o;
        return //car_id.equals(driverCar.car_id) &&
                car_registration.equals(driverCar.car_registration) &&
                Objects.equals(car_colour, driverCar.car_colour) &&
                car_name.equals(driverCar.car_name) &&
                car_model.equals(driverCar.car_model);
            //    driver.equals(driverCar.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_registration, car_colour, car_name, car_model);
    }
}
