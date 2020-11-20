package com.digital.epharmacy.factory.User;
//Nicole Hawthorne- UserProfile factory create a user - 05 July 2020
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

public class UserProfileFactory {

    public static UserProfile createUserProfile(String user_name, String user_surname, String gender, String email, String password, ContactInformation contact, Address address, MedicalAid medical_aid){

        UserProfile userProfile = new UserProfile.Builder()
                .setUser_name(user_name)
                .setUser_surname(user_surname)
                .setGender(gender)
                .setEmail(email)
                .setPassword(password)
                .setContact(contact)
                .setAddress(address)
                .setMedical_aid(medical_aid)
                .build();
        return userProfile;
    }


}
