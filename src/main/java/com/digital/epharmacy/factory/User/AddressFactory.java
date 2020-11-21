package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - AddresFactory - 05 July

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class AddressFactory {
    public static Address createAddress(UserProfile userProfile, Address address){

        Address setAddress = new Address.Builder()
                //.setUser(userProfile)
                .setStreet_name(address.getStreet_name())
                .setStreet_number(address.getStreet_number())
                .setArea_code(address.getArea_code())
                .setArea_name(address.getArea_name())
                .build();

        return setAddress;
    }
}
