package com.digital.epharmacy.factory.Order;
//Nicole Hawthorne - OrderHistory Factory - 05 July
import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.entity.User.UserProfile;

import java.math.BigDecimal;

public class OrderHistoryFactory {
// still need to retrieve the userId and pharmacyId from their actual classes

    public static OrderHistory createOrderHistory(UserProfile user, int total_number_of_orders, BigDecimal total_order_value){
        OrderHistory orderHistory = new OrderHistory.Builder()
                .setId(user.getUser_id())
                .setUser(user)
                .setTotal_number_of_orders(total_number_of_orders)
                .setTotal_order_value(total_order_value)
                .build();
        return orderHistory;
    }
}