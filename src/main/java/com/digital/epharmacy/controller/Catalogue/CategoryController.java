package com.digital.epharmacy.controller.Catalogue;

import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.service.CatalogueItem.impl.CategoryServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public Category create(@Valid @RequestBody Category category) {
//        ResponseEntity<Category>  errorMap = (ResponseEntity<Category>) validationService.MapValidationService(result);
//
//        if(errorMap != null){
//
//            return errorMap;
//        }

        Category newCategory = CategoryFactory
                .createCategory(category.getCategory_name(), category.getCategory_image());
        return categoryService.create(newCategory);

    }

    @GetMapping("/read/{category_id}")
    public Category read (@PathVariable String category_id){

        return categoryService.read(category_id);
    }

    @PostMapping("/update")
    public Category update(@Valid @RequestBody Category category){
        return categoryService.update(category);
    }

    @GetMapping("/")
    public Set<Category>getAll(){
        return categoryService.getAll();
    }

    @DeleteMapping("/delete/{category_id}")
    public boolean delete(@PathVariable String category_id){
        return categoryService.delete(category_id);
    }
}
