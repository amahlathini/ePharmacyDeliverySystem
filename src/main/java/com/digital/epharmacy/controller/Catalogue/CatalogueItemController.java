package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item controller test
 * Date: 09/26/2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.service.CatalogueItem.CategoryService;
import com.digital.epharmacy.service.CatalogueItem.impl.CatalogueItemServiceImpl;
import com.digital.epharmacy.service.CatalogueItem.impl.CategoryServiceImpl;
import com.digital.epharmacy.service.Pharmacy.impl.PharmacyServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;
;

@RestController
@RequestMapping("/items")
public class CatalogueItemController {


    @Autowired
    private CatalogueItemServiceImpl catalogueItemService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private PharmacyServiceImpl pharmacyService;

    @PostMapping("/create/{category_id}/{pharmacy_id}")
    public CatalogueItem create(@Valid @RequestBody CatalogueItem catalogueItem, @PathVariable Long category_id, @PathVariable String pharmacy_id){

//        ResponseEntity<CatalogueItem> errorMap = (ResponseEntity<CatalogueItem>) validationService.MapValidationService(result);
//        if (errorMap != null)
//            return errorMap;

        Category category = categoryService.read(category_id);
        Pharmacy pharmacy = pharmacyService.read(pharmacy_id);

        CatalogueItem newCatalogueItem = CatalogueItemFactory
                .createCatalogueItem(
                        catalogueItem.getItem_name(),
                        catalogueItem.getItem_description(),
                        catalogueItem.getItem_quantity(),
                        catalogueItem.getItem_price(),
                        catalogueItem.getItem_image(),
                        category,
                        pharmacy

                );

       return catalogueItemService.create(newCatalogueItem);

    }
    @GetMapping("/read/{catalogue_name}")
    public CatalogueItem read(@PathVariable Long item_id) {
        return catalogueItemService.read(item_id);
    }
    @PostMapping("/update")
    public CatalogueItem update(@Valid @RequestBody CatalogueItem catItemInfo){
        return catalogueItemService.update(catItemInfo);
    }
    @GetMapping("")
    public Set<CatalogueItem> getall(){
        return catalogueItemService.getAll();
    }

    @DeleteMapping("/delete/{item_name}")
    public boolean delete(@PathVariable Long item_id){
        return catalogueItemService.delete(item_id);
    }
}
