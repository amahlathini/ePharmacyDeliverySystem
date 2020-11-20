package com.digital.epharmacy.FactoryTest.OrderFactory;
//Matthew Pearce - Test to create new order - 05 July
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class OrderFactoryTest {

    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");
    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);
     UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F","aa@gmail.com", "password");

    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());


    @Test
    public void createOrder() {


         Order order = OrderFactory.createOrder(user, items, "EFT");

        assertEquals(user.getUser_id(), order.getUser().getUser_id());
        assertEquals(1, order.getItems().size());
        assertEquals(200.00, order.getOrder_total().doubleValue(), 0);
        assertEquals(1,order.getTotal_catalogue_items());
        assertEquals("Processing", order.getOrder_status());
        assertEquals("EFT",order.getPayment_type());
        //assertEquals("02-9-2020",order.getDate());
    }


}