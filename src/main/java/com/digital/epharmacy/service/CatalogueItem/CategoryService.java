package com.digital.epharmacy.service.CatalogueItem;

import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface CategoryService extends IService<Category, Long> {
    Set<Category> getAll();
}
