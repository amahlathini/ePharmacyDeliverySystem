package com.digital.epharmacy.factory.Driver;
/*
    Author: Chad Boswell
<<<<<<< HEAD
    Desc: DriverProfile factory that creates a driver
=======
    Desc: Driver factory that creates a driver
>>>>>>> origin/groupCollaboration
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.entity.Driver.DriverLocation;
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.util.GenericHelper;

public class DriverProfileFactory {

    public static DriverProfile createDriverProfile(String driver_name, String driver_surname, DriverLocation driver_location, DriverCar car){

        DriverProfile driverProfile = new DriverProfile.Builder()
                .setDriver_name(driver_name)
                .setDriver_surname(driver_surname)
                .setDriver_location(driver_location)
                .setCar(car)
                .builder();
        return driverProfile;
    }
}