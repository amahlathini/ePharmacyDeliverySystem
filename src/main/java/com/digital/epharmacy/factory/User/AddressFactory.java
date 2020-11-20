package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - AddresFactory - 05 July

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class AddressFactory {
    public static Address createAddress(UserProfile userProfile){

        Address address = new Address.Builder()
                .setUser(userProfile)
                .setStreet_name(userProfile.getAddress().getStreet_name())
                .setStreet_number(userProfile.getAddress().getStreet_number())
                .setArea_code(userProfile.getAddress().getArea_code())
                .setArea_name(userProfile.getAddress().getArea_name())
                .build();

        return address;
    }
}
