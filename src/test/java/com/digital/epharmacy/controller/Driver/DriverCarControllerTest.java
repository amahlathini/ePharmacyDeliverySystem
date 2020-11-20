package com.digital.epharmacy.controller.Driver;

import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.entity.Driver.DriverLocation;
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverCarFactory;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
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

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class DriverCarControllerTest {

    DriverLocation driverLocation = new DriverLocation(20, 50);
    DriverProfile driverProfile = DriverProfileFactory.createDriverProfile("Chaddy","Hawthorne",driverLocation);


    DriverCar driverCar = DriverCarFactory.createDriverCar("CY 240", "blue", "Ford", "Figo", driverProfile);

    private static String SECURITY_USERNAME = "Caruser";
    private static String SECURITY_PASSWORD = "Carpassword";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/cars/";

    @Order(1)
    @Test
    public void create() {

        String url = baseURL + "create";
        System.out.println("URL: " +url);
        System.out.println("Post Data:" + driverCar);
        ResponseEntity<DriverCar> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url,driverCar,DriverCar.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        driverCar = postResponse.getBody();

        System.out.println("Saved Data:" +driverCar);
        assertEquals(driverCar.getCar_id(),postResponse.getBody().getCar_id());
    }

    @Order(2)
    @Test
    public void read() {

        String url = baseURL + "read/" + driverCar.getCar_id();
        System.out.println("URL: " +url);
        ResponseEntity<DriverCar> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url,DriverCar.class);
        assertEquals(driverCar.getCar_id(), response.getBody().getCar_id());
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(3)
    @Test
    public void update() {

        DriverCar updated = new DriverCar.Builder().copy(driverCar).setCar_name("Toyota").build();
        String url = baseURL = "update";
        System.out.println("URL: " +url);
        System.out.println("Post Data: " +updated);

        ResponseEntity<DriverCar> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url,updated,DriverCar.class);
        assertEquals(driverCar.getCar_id(), response.getBody().getCar_id());
    }

    @Order(4)
    @Test
    public void getAll() {

        String url = baseURL + "all";
        System.out.println("URL: " +url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Order(5)
    @Test
    public void delete() {

        String url = baseURL +"delete/" +driverCar.getCar_id();
        System.out.println("URL: " +url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}
