package com.digital.epharmacy.controller.Catalogue;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.PrescriptionItemFactory;
import com.digital.epharmacy.service.CatalogueItem.impl.CatalogueItemServiceImpl;
import com.digital.epharmacy.service.PrescriptionItem.impl.PrescriptionItemServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;
@RestController
@RequestMapping("/prescriptions")
public class  PrescriptionItemController {
    @Autowired
    private PrescriptionItemServiceImpl prescriptionItemService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public PrescriptionItem create(@Valid @RequestBody PrescriptionItem prescriptionItem){

//        ResponseEntity<PrescriptionItem> errorMap = (ResponseEntity<PrescriptionItem>) validationService.MapValidationService(result);
//        if (errorMap != null)
//            return errorMap;
        PrescriptionItem newPrescriptionItem = PrescriptionItemFactory
                .createPrescriptionItem(
                        prescriptionItem.getPrescription_type(),
                        prescriptionItem.getPrescribing_doctor()

                );

        return prescriptionItemService.create(newPrescriptionItem);

    }
    @GetMapping("/read/{prescription_number}")
    public PrescriptionItem read(@PathVariable String prescription_number) {
        return prescriptionItemService.read(prescription_number);
    }
    @PostMapping("/update")
    public PrescriptionItem update(@Valid @RequestBody PrescriptionItem prescriptionItemInfo){
        return prescriptionItemService.update(prescriptionItemInfo);
    }
    @GetMapping("/")
    public Set<PrescriptionItem> getall(){
        return prescriptionItemService.getAll();
    }

    @DeleteMapping("/delete/{prescription_number}")
    public boolean delete(@PathVariable String prescriptionNumber){
        return prescriptionItemService.delete(prescriptionNumber);
    }
}

