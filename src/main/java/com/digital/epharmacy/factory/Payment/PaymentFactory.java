/*
 * Author: Ayabulela Mahlathini
 * Desc: Factory for Payment entity
 * Date: 05/07/2020
 * */

package com.digital.epharmacy.factory.Payment;

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.util.GenericHelper;

public class PaymentFactory {
    //IDs still need to be retrieved from the UserProfile, Order and Pharmacy classes

    public static Payment makePayment(Order order) {

        //payment status, notification and date from the helper utility
        String payment_status = GenericHelper.handlePaymentServices(order.getPayment_type(), order.getOrder_total());
        String payment_notification = GenericHelper.handleNotifications(payment_status);
        String date = GenericHelper.paymentDate();

        Payment payment = new Payment.Builder()
                .setType_of_payment(order.getPayment_type())
                .setPayment_total(order.getOrder_total())
                .setPharmacy(order.getPharmacy())
                .setUser(order.getUser())
                .setDate(date)
                .setReference_number(order.getOrder_number())
                .setPayment_status(payment_status)
                .setPayment_notification(payment_notification)
                .build();

        return payment;
    }

}
