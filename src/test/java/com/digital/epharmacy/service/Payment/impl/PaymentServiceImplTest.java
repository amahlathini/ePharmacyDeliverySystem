package com.digital.epharmacy.service.Payment.impl;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import com.digital.epharmacy.service.Payment.PaymentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceImplTest {

    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");

    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);

    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());

    private static UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F", "aa@gmail.com", "password");

    private static Order order = OrderFactory.createOrder(user, items, "EFT");


    @Autowired
    private static PaymentService service;
    private static Payment payment = PaymentFactory.makePayment(order);

    @Test
    void getAll() {

        Set<Payment> payment = service.getAll();
        assertEquals(0,payment.size());
        System.out.println("Amount of Payments" + payment);
    }

    @Test
    void create() {

        Payment created = service.create(payment);
        assertEquals(payment.getUser(),created.getUser().toString());
        System.out.println("New User Created: " + created);
    }

    @Test
    void read() {

        Payment read = service.read(payment.getReference_number());
        assertEquals(payment.getUser().getUser_id().toString(), read.getUser().getUser_id().toString());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {

        Payment updated = new Payment.Builder().copy(payment).setType_of_payment("yoco").build();
        updated = service.update(updated);
        System.out.println("User updated successfully: " + updated);
    }

    @Test
    void delete() {

        boolean deleted = service.delete(payment.getReference_number());
        Assert.assertTrue(deleted);
        System.out.println("User has been deleted successfully.");
    }
}