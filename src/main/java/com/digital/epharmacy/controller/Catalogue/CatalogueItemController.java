package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item controller test
 * Date: 09/26/2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.service.CatalogueItem.impl.CatalogueItemServiceImpl;
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
    private ValidationService validationService;

    @PostMapping("/create")
    public CatalogueItem create(@Valid @RequestBody CatalogueItem catalogueItem){

//        ResponseEntity<CatalogueItem> errorMap = (ResponseEntity<CatalogueItem>) validationService.MapValidationService(result);
//        if (errorMap != null)
//            return errorMap;

        CatalogueItem newCatalogueItem = CatalogueItemFactory
                .createCatalogueItem(
                        catalogueItem.getItem_name(),
                        catalogueItem.getItem_description(),
                        catalogueItem.getItem_quantity(),
                        catalogueItem.getItem_price(),
                        catalogueItem.getItem_image(),
                        catalogueItem.getCategory(),
                        catalogueItem.getPharmacy()

                );

       return catalogueItemService.create(newCatalogueItem);

    }
    @GetMapping("/read/{catalogue_name}")
    public CatalogueItem read(@PathVariable String catalogue_name) {
        return catalogueItemService.read(catalogue_name);
    }
    @PostMapping("/update")
    public CatalogueItem update(@Valid @RequestBody CatalogueItem catItemInfo){
        return catalogueItemService.update(catItemInfo);
    }
    @GetMapping("/")
    public Set<CatalogueItem> getall(){
        return catalogueItemService.getAll();
    }

    @DeleteMapping("/delete/{item_name}")
    public boolean delete(@PathVariable String item_name){
        return catalogueItemService.delete(item_name);
    }
}
