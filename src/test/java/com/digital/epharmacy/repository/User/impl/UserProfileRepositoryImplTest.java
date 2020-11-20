/**package com.digital.epharmacy.repository.User.impl;

 * Author: Nicole Hawthorne
 * Date: 30/08/2020
 * Desc: UserProfileRepository Test, will test all methods if it does it correctly
 *
 import com.digital.epharmacy.entity.User.UserProfile;
 import com.digital.epharmacy.factory.User.UserProfileFactory;
 import com.digital.epharmacy.repository.User.UserProfileRepository;
 import org.junit.Assert;
 import org.junit.FixMethodOrder;
 import org.junit.Test;
 import org.junit.jupiter.api.MethodOrderer;
 import org.junit.jupiter.api.Order;
 import org.junit.jupiter.api.TestMethodOrder;
 import org.junit.runners.MethodSorters;

 import java.util.Set;

 import static org.junit.Assert.*;
 @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 @FixMethodOrder(MethodSorters.NAME_ASCENDING)

 public class UserProfileRepositoryImplTest {
 private static UserProfileRepository repository = new UserProfileRepositoryImpl();
 private static UserProfile  userProfile = UserProfileFactory.createUserProfile(
 "Nicole",
 "Hawthorne",
 "Male");
 @Order(1)
 @Test
 public void a_create() {
 UserProfile created = repository.create(userProfile);
 assertEquals(userProfile.getUser_id(), created.getUser_id());
 System.out.println("Create: " + created);
 }

 @Order(2)
 @Test
 public void b_read() {
 UserProfile read = repository.read(userProfile.getUser_id());
 assertEquals(userProfile.getUser_id(),read.getUser_id());
 System.out.println("Read: " + read);
 }

 @Order(3)
 @Test
 public void c_update() {
 UserProfile updated = new UserProfile.Builder().copy(userProfile).setUser_name("Inneke").setGender("Female").setUser_surname("Hawthorne").build();
 updated = repository.update(updated);
 assertEquals(userProfile.getUser_id(), updated.getUser_id());
 assertNotEquals(userProfile.getUser_name(), updated.getUser_name());
 System.out.println("Update: " + updated );
 }

 @Order(5)
 @Test
 public void e_delete() {
 boolean deleted =   repository.delete(userProfile.getUser_id());
 Assert.assertTrue(deleted);
 if (deleted){
 System.out.println("Entry deleted");
 }
 }

 @Order(4)
 @Test
 public void d_getAll() {
 Set<UserProfile> userProfile = repository.getAll();
 assertEquals(1, userProfile.size());
 System.out.println(repository.getAll());
 }
 }

 */