//package com.digital.epharmacy.FactoryTest.User;
//
//import com.digital.epharmacy.entity.User.MedicalAid;
//import com.digital.epharmacy.factory.User.MedicalAidFactory;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
////Author: Nicole Hawthorne - Test for creating user medical aid details - 05 July 2020
//public class MedicalAidFactoryTest {
//// must still retrieve userId from the actual class for random Id.
//    @Test
//    public void createMedicalAid() {
//
//            MedicalAid medicalAid = MedicalAidFactory.createMedicalAid(8900353,"Momentum","Ingwe");
//            assertNotEquals("Random", medicalAid.getMedical_aid_id());
//            assertEquals(8900353, medicalAid.getUser_medical_aid_number());
//            assertEquals("Momentum", medicalAid.getMedical_aid_name());
//            assertEquals("Ingwe", medicalAid.getMedical_aid_scheme());
//
//
//    }
//}