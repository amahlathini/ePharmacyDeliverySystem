package com.digital.epharmacy.service.CatalogueItem.impl;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CatalogueItemServiceImplTest {



    @Autowired
    private CatalogueItemService service;
    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");
    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem( "MyBulen", "Pain Killers", 6, BigDecimal.valueOf(80.99), "image_url", category, pharmacy);

    @Order(4)
    @Test
    void d_getAll() {
        Set<CatalogueItem> catalogueItems = service.getAll();
        assertEquals(1, catalogueItems.size());
        System.out.println("Catalogue Items: " + catalogueItem);
    }

    @Order(1)
    @Test
    void a_create() {
        CatalogueItem createdCatalogItem = service.create(catalogueItem);
        Assert.assertEquals(catalogueItem.getItem_number(), createdCatalogItem.getItem_number());
        System.out.println("Created:" + createdCatalogItem);
    }

    @Order(2)
    @Test
    void b_read() {
        CatalogueItem read = service.read(catalogueItem.getItem_number());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void c_update() {
        CatalogueItem updatedCatItem = new CatalogueItem
                .Builder()
                .copy(catalogueItem)
                .setItem_name("Disprin")
                .build();

        service.update(updatedCatItem);
        assertNotEquals(catalogueItem.getItem_name(), updatedCatItem.getItem_name());
        System.out.println("Updated: " + updatedCatItem);
    }

    @Order(5)
    @Test
    void e_delete() {
        boolean deleted = service.delete(catalogueItem.getItem_number());

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + catalogueItem.getItem_number());
        }
    }
}