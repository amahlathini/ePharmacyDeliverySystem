package com.digital.epharmacy.service.CatalogueItem.impl;

import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.repository.CatalogueItem.CategoryRepository;
import com.digital.epharmacy.service.CatalogueItem.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;


    @Override
    public Set<Category> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Category create(Category Category) {
        return this.repository.save(Category);
    }

    @Override
    public Category read(Long s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Category update(Category Category) {

        if (this.repository.existsById(Category.getId()))
            return this.repository.save(Category);
        return null;
    }

    @Override
    public boolean delete(Long s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
