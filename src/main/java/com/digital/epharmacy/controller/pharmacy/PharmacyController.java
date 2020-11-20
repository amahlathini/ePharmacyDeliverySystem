package com.digital.epharmacy.controller.pharmacy;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.service.Pharmacy.impl.PharmacyServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
;

/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Controller
 * Date: 24 September 2020
 *
 * Modified: 26 October 2020
 * Updated Method call for Read by Pharmacy name
 *
 */
@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyServiceImpl pharmacyService;

//    @Autowired
//    private ValidationService validationService;

    @PostMapping("/create")
    public Pharmacy create(@Valid @RequestBody Pharmacy pharmacy){

//        ResponseEntity<Pharmacy> errorMap = (ResponseEntity<Pharmacy>) validationService.MapValidationService(result);
//
//        if (errorMap != null)
//            return errorMap;

        Pharmacy newPharmacy = pharmacyService.create(PharmacyFactory.createPharmacy(pharmacy.getPharmacy_name()));

        return newPharmacy;

    }

    @GetMapping("/read/id/{pharmacy_id}")
    public Pharmacy readByPharmacyID(@PathVariable String pharmacy_id){
        Pharmacy pharmacy = pharmacyService.read(pharmacy_id);

        return pharmacy;
    }

    @GetMapping("/read/name/{pharmacy_name}")
    public Pharmacy readByPharmacyName(@PathVariable String pharmacy_name){
        Pharmacy pharmacy = pharmacyService.findPharmacyByPharmacyName(pharmacy_name);

        return pharmacy;
    }

    @PostMapping("/update")
    public Pharmacy update(@Valid @RequestBody Pharmacy pharmacy){
        return pharmacyService.update(pharmacy);
    }

    @GetMapping("/")
    public Set<Pharmacy> getAll(){
        return pharmacyService.getAll();
    }
    
    @DeleteMapping("/delete/{pharmacy_id}")
    public boolean delete(@PathVariable String pharmacy_id){
        return pharmacyService.delete(pharmacy_id);
    }
    

}
