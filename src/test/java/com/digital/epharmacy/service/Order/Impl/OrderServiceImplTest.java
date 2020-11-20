package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Testing Implementation for the Order service, getting all orders from the database and handling the business logic
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.Category;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.CategoryFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;
import com.digital.epharmacy.service.Order.OrderService;
import com.digital.epharmacy.service.User.UserProfileService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceImplTest {

    private static Category category = CategoryFactory.createCategory("Colds & Flu", "image_url");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Clicks");
    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem("Mayogel", "oral health",
            36, BigDecimal.valueOf(200.00), "image_url", category, pharmacy);
    private static UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F","aa@gmail.com", "password");

    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());



    @Autowired
    private OrderService service;

    //as per business rules, we need items to place orders

    private static Order order = OrderFactory
            .createOrder(user, items,"yoco");

    @org.junit.jupiter.api.Order(1)
    @Test
    void a_create() {

        System.out.println(order);
        Order createdOrder = service.create(order);
        System.out.println(createdOrder);
        Assert.assertEquals(order.getOrder_number(), createdOrder.getOrder_number());
        System.out.println("Created:" + createdOrder);
    }

    @org.junit.jupiter.api.Order(2)
    @Test
    void b_read() {
        System.out.println(order.getOrder_number());
        Order readOrder = service.read(order.getOrder_number());
        assertEquals(order.getOrder_number(), readOrder.getOrder_number());
        System.out.println("Read:" + readOrder);
    }

    @org.junit.jupiter.api.Order(3)
    @Test
    void c_update() {
        Order updatedOrder = new Order
                .Builder()
                .copy(order)
                .setPayment_type("paypal")
                .build();

        service.update(updatedOrder);
        assertNotEquals(order.getPayment_type(), updatedOrder.getPayment_type());
        System.out.println("Updated: " + updatedOrder);
    }

    @org.junit.jupiter.api.Order(4)
    @Test
    void d_getAll() {

        Set<Order> orders = service.getAll();
        assertEquals(1, orders.size());

        System.out.println("Get All: " + orders);
    }

    @org.junit.jupiter.api.Order(5)
    @Test
    void e_getAllCompletedOrders() {

        Order updatedOrder = new Order
                .Builder()
                .copy(order)
                .setOrder_status("Completed")
                .build();

        service.update(updatedOrder);

        Set<Order> completedOrders = service.getAllCompletedOrders();
        assertEquals(1, completedOrders.size());

        System.out.println("Get All Completed Orders: " + completedOrders);
    }

    @org.junit.jupiter.api.Order(6)
    @Test
    void f_getAllByUser() {

        Set<Order> ordersByUser = service.getAllOrdersByUser(order.getUser().getUser_id());
        assertEquals(1, ordersByUser.size());

        System.out.println("Get All By User's ID: " + ordersByUser);
    }

    @org.junit.jupiter.api.Order(7)
    @Test
    void g_delete() {
        String orderToDel = order.getOrder_number();
        boolean deleted = service.delete(orderToDel);

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + orderToDel);
        }
    }

}