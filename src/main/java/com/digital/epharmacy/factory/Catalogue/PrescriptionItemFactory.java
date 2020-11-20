package com.digital.epharmacy.factory.Catalogue;
/*
* Name: Nelson Mpyana
* Desc: Prescription Item factory class
* Date : 05/07/2020
 */
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.util.GenericHelper;

public class PrescriptionItemFactory {

    public static PrescriptionItem createPrescriptionItem(String prescription_type, String prescribing_doctor)
    {
        PrescriptionItem prescriptionItem = new PrescriptionItem.Builder()
                .setPrescription_type(prescription_type)
                .setPrescribing_doctor(prescribing_doctor)
                .build();
        return prescriptionItem;
    }
}
