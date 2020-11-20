package com.digital.epharmacy.service.Order.Impl;


/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Testing Implementation for the OrderHistory service, getting all orders from the database
 */


import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Order.OrderHistoryFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import com.digital.epharmacy.service.Order.OrderHistoryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderHistoryServiceImplTest {

    @Autowired
    private OrderHistoryService service;

    private static UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F","aa@gmail.com", "password");

    private static OrderHistory orderHistory = OrderHistoryFactory
            .createOrderHistory(user, 25,new BigDecimal(6500.00));

    @Order(1)
    @Test
    void a_create() {

        OrderHistory createdOrderHistory = service.create(orderHistory);
        Assert.assertEquals(orderHistory.getUser().getUser_id(), createdOrderHistory.getUser().getUser_id());
        System.out.println("Created:" + createdOrderHistory);

    }

    @Order(2)
    @Test
    void b_read() {

        OrderHistory readOrderHistory = service.read(orderHistory.getUser().getUser_id());
        assertEquals(25, readOrderHistory.getTotal_number_of_orders());
        System.out.println("Read:" + readOrderHistory);
    }

    @Order(3)
    @Test
    void c_update() {

        OrderHistory updatedOrderHistory = new OrderHistory
                .Builder()
                .copy(orderHistory)
                .setTotal_number_of_orders(150)
                .build();

        service.update(updatedOrderHistory);

        assertNotEquals(orderHistory.getTotal_number_of_orders(), updatedOrderHistory.getTotal_number_of_orders());

        System.out.println("Updated: " + updatedOrderHistory);
    }

    @Order(4)
    @Test
    void d_getAll() {

        Set<OrderHistory> orderHistories = service.getAll();
        assertEquals(1, orderHistories.size());

        System.out.println("Get All: " + orderHistories);
    }

    @Order(5)
    @Test
    void e_delete() {
        boolean deleted = service.delete(orderHistory.getId());

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + orderHistory.getId());
        }
    }


}