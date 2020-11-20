package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Medical Aid factory - 05 July 2020
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

public class MedicalAidFactory{

    public static MedicalAid createMedicalAid(UserProfile userProfile){

        MedicalAid medicalAid = new MedicalAid.Builder()
                .setUser(userProfile)
               .setUser_medical_aid_number(userProfile.getMedical_aid().getUser_medical_aid_number())
               .setMedical_aid_name(userProfile.getMedical_aid().getMedical_aid_name())
               .setMedical_aid_scheme(userProfile.getMedical_aid().getMedical_aid_scheme())
               .build();
        return  medicalAid;
    }
}
