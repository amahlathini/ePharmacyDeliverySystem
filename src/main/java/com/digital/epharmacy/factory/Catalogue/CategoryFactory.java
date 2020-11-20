package com.digital.epharmacy.factory.Catalogue;

import com.digital.epharmacy.entity.Catalogue.Category;

public class CategoryFactory {
    public static Category createCategory(String name, String category_image){
        Category category = new Category.Builder()
                .setCategory_name(name)
                .setCategory_image(category_image)
                .build();

        return category;
    }
}
