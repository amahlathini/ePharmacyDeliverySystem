package com.digital.epharmacy.factory.Pharmacy;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.util.GenericHelper;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformationFactory Factory to create PharmacyBankAccountInformation
 * Date: 05 July 2020
 */
public class PharmacyBankAccountInformationFactory {
    public static PharmacyBankAccountInformation createPharmacyBankAccountInformation(String bank_name, int account_number, int branch_code, String beneficiary_reference){

        PharmacyBankAccountInformation pharmacyBankAccountInformation = new PharmacyBankAccountInformation.Builder()
                .setBank_name(bank_name)
                .setAccount_number(account_number)
                .setBranch_code(branch_code)
                .setBeneficiary_reference(beneficiary_reference)
                .build();
        return pharmacyBankAccountInformation;
    }
}
