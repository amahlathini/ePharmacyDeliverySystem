package com.digital.epharmacy.FactoryTest.OrderFactory;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
//Author: Keagan Tabisher - Test for creating OrderReceipt 5 July 2020

public class OrderReceiptFactoryTest{
    // Test class creating an OrderReceiept object and then using the "assertEquals" to test each variable

    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");

    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);

    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());

    UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F", "aa@gmail.com", "password");

    Order order = OrderFactory.createOrder(user, items, "EFT");

    @Test
    // method for testing
    public void CreateOrderReceipt() {
        Date testDate = new Date();
        OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(order);
        assertEquals(order.getOrder_number(), orderReceipt.getOrder().getOrder_number());
        assertEquals(pharmacy.getPharmacy_id(), orderReceipt.getPharmacy());
        assertEquals(user.getUser_id(), orderReceipt.getUser().getUser_id());
        assertEquals(1, orderReceipt.getQuantity());
        assertEquals(order.getOrder_total().doubleValue(), orderReceipt.getPayment_total().doubleValue(), 0);
        assertEquals("EFT", orderReceipt.getType_of_payment());
        assertEquals(testDate, orderReceipt.getDate());
    }
}