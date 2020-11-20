package com.digital.epharmacy.factory.Catalogue;
/*
Nelson Mpyana
Desc: Adding catalogue items (catalogue items class)
Date: 05/07/2020
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;

import java.math.BigDecimal;

public class CatalogueItemFactory {

    public static CatalogueItem createCatalogueItem (String item_name, String item_description,
                                                     int item_quantity, BigDecimal item_price, String item_image, Category category, Pharmacy pharmacy ) {


        CatalogueItem catItem = new CatalogueItem.Builder()
                .setItem_name(item_name)
                .setItem_description(item_description)
                .setItem_quantity(item_quantity)
                .setItem_price(item_price)
                .setItem_image(item_image)
                .setPharmacy(pharmacy)
                .setCategory(category)
                .build();

        return catItem;

    }

}
