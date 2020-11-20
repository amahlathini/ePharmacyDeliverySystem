//package com.digital.epharmacy.FactoryTest.PaymentFactory;
//
//import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
//import com.digital.epharmacy.entity.Catalogue.Category;
//import com.digital.epharmacy.entity.Order.Order;
//import com.digital.epharmacy.entity.Payment.Payment;
//import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
//import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
//import com.digital.epharmacy.entity.User.Address;
//import com.digital.epharmacy.entity.User.ContactInformation;
//import com.digital.epharmacy.entity.User.MedicalAid;
//import com.digital.epharmacy.entity.User.UserProfile;
//import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
//import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
//import com.digital.epharmacy.factory.Order.OrderFactory;
//import com.digital.epharmacy.factory.Payment.PaymentFactory;
//import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
//import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
//import com.digital.epharmacy.factory.User.AddressFactory;
//import com.digital.epharmacy.factory.User.ContactInformationFactory;
//import com.digital.epharmacy.factory.User.MedicalAidFactory;
//import com.digital.epharmacy.factory.User.UserProfileFactory;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.*;
//
//public class PaymentFactoryTest {
//
//
//    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
//    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");
//    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
//            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);
//    UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F", "aa@gmail.com", "password");
//
//    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());
//
//    Order order = OrderFactory.createOrder(user, items, "EFT");
//
//
//    @Test
//    public void makePayment() {
//
//
//        Payment payment = new PaymentFactory().makePayment(order);
//
//
//        String paymentReference = payment.getReference_number();
//        String notification = payment.getPayment_notification();
//
//
//        assertEquals(user.getUser_id(), payment.getUser().getUser_id());
//        assertEquals(order.getOrder_number(), payment.getOrder().getOrder_number());
//        assertEquals(pharmacy.getPharmacy_id(), payment.getPharmacy().getPharmacy_id());
//        assertEquals("EFT", payment.getType_of_payment());
//        assertEquals(200.00, payment.getPayment_total().doubleValue(), 0);
//        assertEquals("Processing",payment.getPayment_status());
//        assertEquals(notification, payment.getPayment_notification());
//        assertEquals(paymentReference, payment.getReference_number());
//    }
//}