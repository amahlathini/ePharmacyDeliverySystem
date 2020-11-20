package com.digital.epharmacy.controller.pharmacy;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.service.PharmacyBankAccountInformation.impl.PharmacyBankAccountInformationServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
;

/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Bank Account Info Controller
 * Date: 24 September 2020
 *
 * Modified: 26 October 2020
 * Updated Method call for Read by AccountId
 * Added Endpoint to search by account number
 */
@RestController
@RequestMapping("/bank_details")
public class PharmacyBankAccountInformationController {

    @Autowired
    private PharmacyBankAccountInformationServiceImpl bankService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public PharmacyBankAccountInformation create(@Valid @RequestBody PharmacyBankAccountInformation bankinfo){

//        ResponseEntity<PharmacyBankAccountInformation> errorMap = (ResponseEntity<PharmacyBankAccountInformation>) validationService.MapValidationService(result);
//
//        if (errorMap != null)
//            return errorMap;

        PharmacyBankAccountInformation newBankInfo = PharmacyBankAccountInformationFactory
                .createPharmacyBankAccountInformation(
                        bankinfo.getBank_name(),
                        bankinfo.getAccount_number(),
                        bankinfo.getBranch_code(),
                        bankinfo.getBeneficiary_reference()
                );

        return bankService.create(newBankInfo);

    }

    @GetMapping("/read/{bank_account_id}")
    public PharmacyBankAccountInformation read(@PathVariable String bank_account_id){
        return bankService.read(bank_account_id);

    }

    @GetMapping("/account/{account_number}")
    public PharmacyBankAccountInformation read(@PathVariable int account_number){
        return bankService.findByAccountNumber(account_number);

    }

    @PostMapping("/update")
    public PharmacyBankAccountInformation update(@Valid @RequestBody PharmacyBankAccountInformation bankInfo){
        return bankService.update(bankInfo);
    }

    @GetMapping("/")
    public Set<PharmacyBankAccountInformation> getall(){
        return bankService.getAll();
    }

    @DeleteMapping("/delete/{bank_account_id}")
    public boolean delete(@PathVariable String bank_account_id){
        return bankService.delete(bank_account_id);
    }
}
