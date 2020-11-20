package com.digital.epharmacy.FactoryTest.DriverFactory;
/*
    Author: Chad Boswell
    Desc: DriverCar test case
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.entity.Driver.DriverLocation;
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverCarFactory;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import org.junit.Test;

import static org.junit.Assert.*;
// still need to test for random id generated
public class DriverCarFactoryTest {

    DriverLocation driverLocation = new DriverLocation(20, 50);
    DriverProfile driverProfile = DriverProfileFactory.createDriverProfile("Chaddy","Hawthorne",driverLocation);

    @Test
    public void createDriverCar() {
        DriverCar car = DriverCarFactory.createDriverCar("CY 240", "blue", "Ford", "Figo", driverProfile);
        assertEquals("Cy 300", car.getCar_registration());
        assertEquals("green", car.getCar_colour());
        assertEquals("Ford", car.getCar_name());
        assertEquals("Fiesta", car.getCar_model());

    }
}