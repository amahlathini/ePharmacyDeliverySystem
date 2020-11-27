package com.digital.epharmacy.service.Order;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Interface for the Order service, getting all orders from the database
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.service.IService;

import java.util.List;
import java.util.Set;
;

public interface OrderService extends IService<Order, Long> {
    Set<Order> getAll();

    Set<Order> getAllCompletedOrders();

    Set<Order> getAllProcessing();

    Set<Order> getAllCanceled();

    List<CatalogueItem> addItemsToOrder(List<Long> item_ids);

    String trackOrderStatus(Long orderID);

    Set<Order> getAllOrdersByUser(String userID);


}
