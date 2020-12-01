package com.digital.epharmacy.controller.Order;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 24/09/2020
 * Description: Controller for the Order History (crud for order history i.e. total number of orders and order value)
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Order.OrderHistoryFactory;
import com.digital.epharmacy.service.Order.Impl.OrderHistoryServiceImpl;
import com.digital.epharmacy.service.Order.Impl.OrderServiceImpl;
import com.digital.epharmacy.service.User.impl.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
;

@RestController
@RequestMapping("/history")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryServiceImpl orderHistoryService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserProfileServiceImpl userProfileService;

    @PostMapping("/create/{user_id}")
    public OrderHistory create(@PathVariable String user_id){

        Set<Order> orders = orderService.getAllOrdersByUser(user_id);

        UserProfile user = userProfileService.read(user_id);
        int total = orders.size();

        OrderHistory newOrderHistory = OrderHistoryFactory
                .createOrderHistory(user,total,orderHistoryService.totalValueByUser(orders));
        return orderHistoryService.create(newOrderHistory);
    }

    @GetMapping("/read/{id}")
    public OrderHistory read(@PathVariable String id){
        return orderHistoryService.read(id);
    }

    @PostMapping("/update")
    public OrderHistory update(@RequestBody OrderHistory orderHistory) {
        return orderHistoryService.update(orderHistory);
    }

    @DeleteMapping("/delete/{user_id}")
    public boolean delete(@PathVariable String user_id) {
        return orderHistoryService.delete(user_id);
    }

    @GetMapping("")
    public Set<OrderHistory> getAll() {
        return orderHistoryService.getAll();
    }

}
