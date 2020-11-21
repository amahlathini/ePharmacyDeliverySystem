package com.digital.epharmacy.factory.Driver;
/*
    Author: Chad Boswell
    Desc: DriverCar creates a factory for the car
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.util.GenericHelper;

//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class DriverCarFactory {
    public static DriverCar createDriverCar(String car_registration, String car_colour, String car_name, String car_model, DriverProfile driver){

        DriverCar driverCar = new DriverCar.Builder()
                .setCar_registration(car_registration)
                .setCar_colour(car_colour)
                .setCar_name(car_name)
                .setCar_model(car_model)
                //.setDriver(driver)
                .build();
        return driverCar;
    }
}

