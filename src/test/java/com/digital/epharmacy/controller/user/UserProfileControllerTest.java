//package com.digital.epharmacy.controller.user;
//
//import com.digital.epharmacy.entity.User.UserProfile;
//import com.digital.epharmacy.factory.User.UserProfileFactory;
//import org.apache.catalina.User;
//import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UserProfileControllerTest {
//
//
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private static String baseURL = "http://localhost:8080/users";
//
//    private static UserProfile userProfile = UserProfileFactory.createUserProfile("Ronnie", "Michaelson", "Female", "ab@gmail.com", "password");
//    private String Security_UserName = "Admin";
//    private String Security_Password = "12345";
//
//    @Order(1)
//    @Test
//    void a_create() {
//        String url = baseURL + "/create";
//        System.out.println("URL:" + url);
//        System.out.println("Post data: " + userProfile);
//
//        ResponseEntity<UserProfile> postResponse= restTemplate
//               .withBasicAuth(Security_UserName,Security_Password)
//                .postForEntity(url, userProfile, UserProfile.class);
//        System.out.println(postResponse.toString());
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        userProfile = postResponse.getBody();
//        System.out.println("Saved data:" + userProfile);
//        assertEquals(HttpStatus.OK,postResponse.getStatusCode());
//
//        assertEquals(userProfile.getUser_id(), postResponse.getBody().getUser_id());
//    }
//    @Order(2)
//    @Test
//    void b_read(){
//        String url = baseURL + "/id/" + userProfile.getUser_id();
//        System.out.println("Url: " + url);
//        ResponseEntity<UserProfile> response = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .getForEntity(url,UserProfile.class);
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//        assertEquals(userProfile.getUser_id(), response.getBody().getUser_id());
//        System.out.println(response);
//        System.out.println(response.getBody());
//
//    }
//
//    @Order(3)
//    @Test
//    void c_FindByUserProfileName(){
//        String url = baseURL + "/name/" + userProfile.getUser_name();
//        System.out.println("Url: " + url);
//        ResponseEntity<UserProfile> response = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .getForEntity(url,UserProfile.class);
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//        assertEquals(userProfile.getUser_name(), response.getBody().getUser_name());
//        System.out.println(response);
//        System.out.println(response.getBody());
//
//    }
//    @Order(5)
//    @Test
//    void d_getAll() {
//        String url = baseURL + "/";
//        System.out.println("Url: " + url);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .exchange(url, HttpMethod.GET,entity,String.class);
//        assertEquals(HttpStatus.FOUND,response.getStatusCode());
//        System.out.println(response);
//        System.out.println(response.getBody());
//
//    }
//
//    @Order(4)
//    @Test
//    void c_update(){
//        UserProfile userProfileUpdated = new UserProfile.Builder().copy(userProfile).setGender("Male").build();
//        String url = baseURL + "/update"; //+ userProfile.getUser_id();
//        System.out.println("Url: " + url);
//        System.out.println("Post data: " + userProfileUpdated);
//        ResponseEntity<UserProfile> response = restTemplate
//                .withBasicAuth(Security_UserName,Security_Password)
//                .postForEntity(url, userProfileUpdated, UserProfile.class);
//        userProfile = response.getBody();
//        assertEquals(HttpStatus.CREATED,response.getStatusCode());
//        assertEquals(userProfile.getGender(),response.getBody().getGender());
//    }
//
//    @Order(6)
//    @Test
//    void e_delete(){
//        String url = baseURL + "/delete/" + userProfile.getUser_id();
//        System.out.println("Url: " + url);
//        restTemplate.withBasicAuth(Security_UserName,Security_Password).delete(url);
//        if (url == null){
//        System.out.println(HttpStatus.OK);} else
//            System.out.println(HttpStatus.FORBIDDEN);
//    }
//
//
//}