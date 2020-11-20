package com.digital.epharmacy.controller.Catalogue;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.PrescriptionItemFactory;
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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class PrescriptionItemControllerTest {

    private static String USERNAME = "UserProfile";
    private static String USER_PASSWORD = "54321";
    private static String SECURITY_USERNAME = "Admin";
    private static String SECURITY_PASSWORD = "12345";

    PrescriptionItem prescriptionItem = PrescriptionItemFactory.createPrescriptionItem( " Optometory ", "");
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/prescriptions";

    @Order(1)
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        System.out.println("POST Data: " + prescriptionItem);

        ResponseEntity<PrescriptionItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, prescriptionItem, PrescriptionItem.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        prescriptionItem = response.getBody();
        System.out.println("Saved Data: " + prescriptionItem);
        assertEquals(prescriptionItem.getPrescription_number(), response.getBody().getPrescription_number());
    }

    @Order(2)
    @Test
    void b_read() {
        String url = baseURL + "/read/" + prescriptionItem.getPrescription_number();
        System.out.println("URL: " + url);
        ResponseEntity<PrescriptionItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, PrescriptionItem.class);
        assertEquals(prescriptionItem.getPrescription_number(), response.getBody().getPrescription_number());
    }

    @Order(4)
    @Test
    void update() {
        PrescriptionItem prescriptionItemItemUpdate = new PrescriptionItem
                .Builder()
                .copy(prescriptionItem)
                .setPrescription_type(" Chronic")
                .build();
        String url = baseURL + "/update/" + prescriptionItem.getPrescription_number();

        System.out.println("URL: " + url);
        System.out.println("POST Data: " + prescriptionItemItemUpdate);
        ResponseEntity<PrescriptionItem> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, prescriptionItemItemUpdate, PrescriptionItem.class);

        prescriptionItem = response.getBody();

        assertEquals(prescriptionItem.getPrescription_type(), response.getBody().getPrescription_type());
    }

    @Order(5)
    @Test
    void getAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(6)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + prescriptionItem.getPrescription_number();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}