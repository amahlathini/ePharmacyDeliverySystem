package com.digital.epharmacy.FactoryTest.DriverFactory;
/*
    Author: Chad Boswell
<<<<<<< HEAD
    Desc: DriverProfile test case
=======
    Desc: Driver test case
>>>>>>> origin/groupCollaboration
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverLocation;
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverProfileFactoryTest {

    DriverLocation driverLocation = new DriverLocation(20, 50);
    @Test
    public void createUserProfile() {
        DriverProfile driverProfile = DriverProfileFactory.createDriverProfile("Chaddy","Hawthorne",driverLocation);
        assertEquals("Chad", driverProfile.getDriver_name());
        assertEquals("Boswell", driverProfile.getDriver_surname());
        assertEquals(driverLocation.toString(), driverProfile.getDriver_location().toString());

    }
}