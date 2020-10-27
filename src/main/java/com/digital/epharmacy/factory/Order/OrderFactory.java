package com.digital.epharmacy.factory.Order;
//Matthew Pearce - Order Factory Created to create a order 05 July 2020
//Ayabulela Mahlathini - Uncommented the code for generating order number and adding code for getting the date

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.util.GenericHelper;

import java.math.BigDecimal;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(String userID, List<CatalogueItem> items, String paymentType) {

        //generating order number
        String orderNumber = GenericHelper.generateId();

        double orderTotal = 0;


        if (items != null) {
            for (CatalogueItem ci : items) {
                double itemsTotal = ci.getItemPrice() * ci.getItemQuantity();
                orderTotal += itemsTotal;
            }
        }
            //getting the date
            String date = GenericHelper.paymentDate();

            //default for the orderStatus
            String orderStatus = "Processing";

            Order order = new Order.Builder()
                    .setUserID(userID)
                    .setOrderNumber(orderNumber)
                    .setItems(items)
                    .setTotalCatalogueItems(items.size())
                    .setOrderTotal(BigDecimal.valueOf(orderTotal))
                    .setPaymentType(paymentType)
                    .setOrderStatus(orderStatus)
                    .setDate(date)
                    .build();
            return order;


        }
    }