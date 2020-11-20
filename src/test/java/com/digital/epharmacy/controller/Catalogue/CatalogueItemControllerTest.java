
package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item controller Test
 * Date: 09/26/2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CatalogueItemControllerTest {

    private static String USERNAME = "UserProfile";
    private static String USER_PASSWORD = "54321";
    private static String SECURITY_USERNAME = "Admin";
    private static String SECURITY_PASSWORD = "12345";

    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");
    private static CatalogueItem catItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);


    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/items";


    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("POST Data: " + catItem);

        ResponseEntity<CatalogueItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, catItem, CatalogueItem.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        catItem = response.getBody();
        System.out.println("Saved Data: " + catItem);
        assertEquals(catItem.getItem_number(), response.getBody().getItem_number());
    }

    @Order(2)
    @Test
    void b_readByItemNumber() {
        String url = baseURL + "/read/" + catItem.getItem_number();
        System.out.println("URL: " + url);
        ResponseEntity<CatalogueItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, CatalogueItem.class);
        assertEquals(catItem.getItem_number(), response.getBody().getItem_number());
    }

    @Order(3)
    @Test
    @Ignore
    void c_readByCatalogueDesc() {
        String url = baseURL + "/desc/" + catItem.getItem_description();
        System.out.println("URL: " + url);
        ResponseEntity<CatalogueItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, CatalogueItem.class);
        assertEquals(catItem.getItem_description(), response.getBody().getItem_description());
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(5)
    @Test
    void getAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(4)
    @Test
    void update() {
        CatalogueItem catalogueItemUpdate = new CatalogueItem
                .Builder()
                .copy(catItem)
                .setItem_quantity( 20
                )
                .build();
        String url = baseURL + "/update/" + catItem.getItem_quantity();

        System.out.println("URL: " + url);
        System.out.println("POST Data: " + catalogueItemUpdate);
        ResponseEntity<CatalogueItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, catalogueItemUpdate, CatalogueItem.class);

        catItem = response.getBody();

        assertEquals(catItem.getItem_quantity(), response.getBody().getItem_quantity());
    }

    @Order(6)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + catItem.getItem_number();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
    @Order(6)
    @Test
    @Ignore
    void deleteByPrescriptionNumber() {
        String url = baseURL + "/delete/" + catItem;
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}