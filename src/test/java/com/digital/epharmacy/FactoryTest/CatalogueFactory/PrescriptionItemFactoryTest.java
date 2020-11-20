package com.digital.epharmacy.FactoryTest.CatalogueFactory;

import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.factory.Catalogue.PrescriptionItemFactory;
import org.junit.Test;
/*
 * Name: Nelson Mpyana
 * Desc: Testing the Prescription Item factory
 * Date : 05/07/2020
 */

import static org.junit.Assert.*;

public class PrescriptionItemFactoryTest {

    @Test
    public void createPrescriptionItem() {
        PrescriptionItem prescriptionItem = PrescriptionItemFactory.createPrescriptionItem("Eye glasses",
                "Dr Opatile");
        assertEquals("Eye glasses", prescriptionItem.getPrescription_type());
        assertEquals("Dr Opatile", prescriptionItem.getPrescribing_doctor());

    }

}