package com.digital.epharmacy.FactoryTest.CatalogueFactory;
/*
Nelson Mpyana
Desc: Test Adding catalogue items
Date: 05/07/2020
 */
import static org.junit.Assert.assertEquals;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import org.junit.Test;

import java.math.BigDecimal;

public class CatalogueItemFactoryTest {

    Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");

    @Test
    public void createCatalogueItem() {
        CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
                36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);
        assertEquals("Mayogel", catalogueItem.getItem_name());
        assertEquals("oral health", catalogueItem.getItem_description());
        assertEquals(36, catalogueItem.getItem_quantity());
        assertEquals(200, catalogueItem.getItem_price().doubleValue(), 0.1);

    }
}