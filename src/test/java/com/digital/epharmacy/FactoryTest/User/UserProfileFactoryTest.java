package com.digital.epharmacy.FactoryTest.User;
//Nicole Hawthorne - Test to create new userprofile - 05 July 2020
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileFactoryTest {

    @Test
    public void createUserProfile() {

        UserProfile userProfile = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F", "aa@gmail.com", "password");
        assertEquals("Nicole", userProfile.getUser_name());
        assertEquals("Hawthorne", userProfile.getUser_surname());
        assertEquals("F", userProfile.getGender());

    }
}