//package com.digital.epharmacy.controller.user;
//
//import com.digital.epharmacy.entity.User.MedicalAid;
//import com.digital.epharmacy.factory.User.MedicalAidFactory;
//import com.digital.epharmacy.service.MedicalAid.impl.MedicalAidServiceImpl;
//import com.digital.epharmacy.service.Validation.ValidationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Set;
//;
//
///*
// * Author: Opatile Kelobang
// * Desc: Medical Controller
// * Date: 25 September 2020
// */
//@RestController
//@RequestMapping("/medical_aids")
//public class MedicalAidController {
//
//    @Autowired
//    private MedicalAidServiceImpl medicalAidService;
//
//    @Autowired
//    private ValidationService validationService;
//
//    @PostMapping("/create")
//    public MedicalAid create(@Valid @RequestBody MedicalAid medicalAid) {
//
////        ResponseEntity<MedicalAid> errorMap = (ResponseEntity<MedicalAid>) validationService.MapValidationService(result);
////
////        if (errorMap != null)
////            return errorMap;
//
//        MedicalAid newMedicalAid = MedicalAidFactory.createMedicalAid(
//                medicalAid.getUser_medical_aid_number(),
//                medicalAid.getMedical_aid_name(),
//                medicalAid.getMedical_aid_scheme()
//        );
//
//        return medicalAidService.create(newMedicalAid);
//    }
//
//    @PostMapping("/update")
//    public MedicalAid update(@Valid @RequestBody MedicalAid userId){
//        return medicalAidService.update(userId);
//    }
//
//    @GetMapping("/read/{user_id}")
//    public MedicalAid read(@PathVariable String user_id){
//        return medicalAidService.read(user_id);
//
//    }
//
//    @GetMapping("/")
//    public Set<MedicalAid> getAll(){
//        return medicalAidService.getAll();
//    }
//
//    @DeleteMapping("/delete/{userI_id}")
//    public boolean delete(@PathVariable String user_id){
//        return medicalAidService.delete(user_id);
//    }
//
//}
//
