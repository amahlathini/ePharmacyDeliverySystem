package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Medical Aid factory - 05 July 2020
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

public class MedicalAidFactory{

    public static MedicalAid createMedicalAid(UserProfile userProfile, MedicalAid medicalAid){

        MedicalAid setMedicalAid = new MedicalAid.Builder()
                //.setUser(userProfile)
               .setUser_medical_aid_number(medicalAid.getUser_medical_aid_number())
               .setMedical_aid_name(medicalAid.getMedical_aid_name())
               .setMedical_aid_scheme(medicalAid.getMedical_aid_scheme())
               .build();
        return  setMedicalAid;
    }
}
