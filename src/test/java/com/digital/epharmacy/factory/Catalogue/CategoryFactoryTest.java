package com.digital.epharmacy.factory.Catalogue;

import com.digital.epharmacy.entity.Catalogue.Category;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryFactoryTest {

    @Test
    public void createCategory() {
        Category category = CategoryFactory.createCategory("Toiletries", "image_url");
        assertEquals("Toiletries", category.getCategory_name());
    }
}