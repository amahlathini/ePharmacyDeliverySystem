//package com.digital.epharmacy.controller.payment;
//
//import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
//import com.digital.epharmacy.entity.Catalogue.Category;
//import com.digital.epharmacy.entity.Payment.Payment;
//import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
//import com.digital.epharmacy.entity.User.UserProfile;
//import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
//import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
//import com.digital.epharmacy.factory.Order.OrderFactory;
//import com.digital.epharmacy.factory.Payment.PaymentFactory;
//import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
//import com.digital.epharmacy.factory.User.UserProfileFactory;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//class PaymentControllerTest {
//
//    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
//    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");
//
//    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
//            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);
//
//    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());
//
//    UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F", "aa@gmail.com", "password");
//
//    com.digital.epharmacy.entity.Order.Order order = OrderFactory.createOrder(user, items, "EFT");
//
//
//    private static String Security_UserName = "paymentuser";
//    private static String Security_Password = "paymentpassword";
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String baseURL = "http://localhost:8080/payments";
//
//    Payment payment = PaymentFactory.makePayment(order);
//
//    @Order(1)
//    @Test
//    void create() {
//
//        String url = baseURL + "/create";
//        System.out.println("URL: " +url);
//        System.out.println("Post Data:" + payment);
//        ResponseEntity<Payment> postResponse = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .postForEntity(url,payment,Payment.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        System.out.println("Saved Data:" +payment);
//        assertEquals(payment.getReference_number(),postResponse.getBody().getReference_number());
//    }
//
//    @Order(2)
//    @Test
//    void read() {
//
//        String url = baseURL + "read/" + payment.getReference_number();
//        System.out.println("URL: " +url);
//        ResponseEntity<Payment> reponse = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .getForEntity(url,Payment.class);
//        assertEquals(payment.getReference_number(), reponse.getBody().getReference_number());
//    }
//
//    @Order(3)
//    @Test
//    void update() {
//
//        Payment updated = new Payment.Builder().copy(payment).setPayment_status("delivered").build();
//        String url = baseURL = "update";
//        System.out.println("URL: " +url);
//        System.out.println("Post Data: " +updated);
//        ResponseEntity<Payment> response = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .postForEntity(url,updated,Payment.class);
//        assertEquals(payment.getReference_number(), response.getBody().getReference_number());
//    }
//
//    @Order(4)
//    @Test
//    void getAll() {
//
//        String url = baseURL + "all";
//        System.out.println("URL: " +url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate.withBasicAuth(Security_UserName,Security_Password)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//    @Order(5)
//    @Test
//    void delete() {
//
//        String url = baseURL +"delete/" +payment.getReference_number();
//        System.out.println("URL: " +url);
//        restTemplate.withBasicAuth(Security_UserName,Security_Password).delete(url);
//        if (url == null){
//            System.out.println(HttpStatus.OK);} else
//            System.out.println(HttpStatus.FORBIDDEN);
//    }
//}