package com.digital.epharmacy.controller.Order;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 24/09/2020
 * Description: Controller for the Orders, (crud for orders, tracking orders and getting past orders by a user)
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.service.Order.Impl.OrderServiceImpl;
import com.digital.epharmacy.service.User.impl.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserProfileServiceImpl userProfileService;


    @PostMapping("/create/{user_id}/{payment_type}")
    public Order create(@RequestBody List<Long> item_ids, @PathVariable String user_id, @PathVariable String payment_type){

        List<CatalogueItem> items = orderService.addItemsToOrder(item_ids);

        UserProfile user = userProfileService.read(user_id);

        Order newOrder = OrderFactory
                .createOrder(user, items, payment_type);
       return orderService.create(newOrder);
    }

    @GetMapping("/read/{order_id}")
    public Order read(@PathVariable Long order_id){
        return orderService.read(order_id);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{order_id}")
    public boolean delete(@PathVariable Long order_id) {
        return orderService.delete(order_id);
    }

    @GetMapping("")
    public Set<Order> getAll() {
        return orderService.getAll();
    }

    //get all completed orders with payment successful for the delivery guys
    @GetMapping("/processing")
    public Set<Order> getAllProcessingOrders() {
        return orderService.getAllProcessing();
    }

    @GetMapping("/completed")
    public Set<Order> getAllCompletedOrders() {
        return orderService.getAllCompletedOrders();
    }

    @GetMapping("/canceled")
    public Set<Order> getAllCanceledOrders() {
        return orderService.getAllCanceled();
    }

    //tracking order status
    @GetMapping("/track/{order_id}")
    public String trackOrderStatus(@PathVariable Long order_id) {
        return orderService.trackOrderStatus(order_id);
    }

    //getting all the history by a user
    @GetMapping("/past/{user_id}")
    public Set<Order> getAllOrdersByUser(@PathVariable String user_id) {
        return orderService.getAllOrdersByUser(user_id);
    }

}