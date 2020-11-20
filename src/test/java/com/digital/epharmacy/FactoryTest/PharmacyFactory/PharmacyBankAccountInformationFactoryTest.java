package com.digital.epharmacy.FactoryTest.PharmacyFactory;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PharmacyBankAccountInformationFactoryTest {

    @Test
    public void createPharmacyBankAccountInformation() {
        PharmacyBankAccountInformation pharmacyBankAccountInformation = PharmacyBankAccountInformationFactory
                .createPharmacyBankAccountInformation(
                "First National Bank", 794629609, 7612, "Viagra");
        assertNotNull("Pharmacy Bank Account Information Cannot Be Found", pharmacyBankAccountInformation.getBank_account_id());
        assertEquals("First National Bank", pharmacyBankAccountInformation.getBank_name());
        assertEquals(794629609, pharmacyBankAccountInformation.getAccount_number());
        assertEquals(7612, pharmacyBankAccountInformation.getBranch_code());
        assertEquals("Paracetamol", pharmacyBankAccountInformation.getBeneficiary_reference());
    }
}