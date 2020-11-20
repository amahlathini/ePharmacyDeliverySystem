//package com.digital.epharmacy.controller.Order;
//
//import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
//import com.digital.epharmacy.entity.Catalogue.Category;
//import com.digital.epharmacy.entity.Order.Order;
//import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
//import com.digital.epharmacy.entity.User.UserProfile;
//import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
//import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
//import com.digital.epharmacy.factory.Order.OrderFactory;
//import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
//import com.digital.epharmacy.factory.User.UserProfileFactory;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class OrderControllerTest {
//
//    private static String USERNAME = "UserProfile";
//    private static String USER_PASSWORD = "54321";
//    private static String ADMIN_USERNAME = "Admin";
//    private static String ADMIN_PASSWORD = "12345";
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
//    Order order = OrderFactory.createOrder(user, items, "EFT");
//
//    @Autowired
//    private static TestRestTemplate restTemplateItem;
//    private static final String baseURLItem = "http://localhost:8080/catalogueItem";
//    private static String itemUrl = baseURLItem + "/create";
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String baseURL = "http://localhost:8080/orders/";
//
//    @org.junit.jupiter.api.Order(1)
//    @Test
//    public void a_create() {
//
//        String url = baseURL + "create";
//        System.out.println("URL:" + url);
//        System.out.println("POST data: " + order);
//        ResponseEntity<Order> postResponse = restTemplate
//                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
//                .postForEntity(url, order, Order.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        System.out.println("Saved data:" + postResponse.getBody());
//        assertEquals(order.getOrder_total(), postResponse.getBody().getOrder_total());
//
//    }
//
//    @org.junit.jupiter.api.Order(2)
//    @Test
//    public void b_read() {
//        String url = baseURL + "read/" + order.getOrder_number();
//        System.out.println("URL: " + url);
//        ResponseEntity<Order> response = restTemplate
//                .withBasicAuth(USERNAME, USER_PASSWORD)
//                .getForEntity(url, Order.class);
//        assertEquals(order.getOrder_number(), response.getBody().getOrder_number());
//    }
//
//    @org.junit.jupiter.api.Order(3)
//    @Test
//    public void c_update() {
//        Order updatedOrder = new Order.Builder().copy(order).setOrder_status("completed").build();
//        String url = baseURL + "update";
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updatedOrder);
//        ResponseEntity<Order> response = restTemplate
//                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
//                .postForEntity(url, updatedOrder, Order.class);
//        System.out.println("Response: " + response.getBody());
//        assertEquals(order.getOrder_number(), response.getBody().getOrder_number());
//    }
//
//    @org.junit.jupiter.api.Order(8)
//    @Test
//    public void h_delete() {
//        String url = baseURL + "delete/" + order.getOrder_number();
//        System.out.println("URL: " + url);
//        restTemplate.withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD).delete(url);
//    }
//
//    @org.junit.jupiter.api.Order(4)
//    @Test
//    public void d_getAll() {
//        String url = baseURL + "all";
//        System.out.println("URL: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(USERNAME, USER_PASSWORD)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//    @org.junit.jupiter.api.Order(5)
//    @Test
//    public void e_getAllCompletedOrders() {
//
//        String url = baseURL + "completed";
//        System.out.println("URL: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//    @org.junit.jupiter.api.Order(6)
//    @Test
//    public void f_trackOrderStatus() {
//        String url = baseURL + "track/" + order.getOrder_number();
//        System.out.println("URL: " + url);
//        ResponseEntity<Order> response = restTemplate
//                .withBasicAuth(USERNAME, USER_PASSWORD)
//                .getForEntity(url, Order.class);
//        assertEquals("completed", response.getBody().getOrder_status());
//    }
//
//    @org.junit.jupiter.api.Order(7)
//    @Test
//    public void g_getAllOrdersByUser() {
//
//        String url = baseURL + "past/"+ user
//                .getUser_id();
//
//        OrderFactory.createOrder(user, items,"yoco");
//
//        System.out.println("URL: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(USERNAME, USER_PASSWORD)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//}