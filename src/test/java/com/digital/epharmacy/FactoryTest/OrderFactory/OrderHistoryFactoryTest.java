package com.digital.epharmacy.FactoryTest.OrderFactory;

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Order.OrderHistoryFactory;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderHistoryFactoryTest {

    UserProfile user = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F","aa@gmail.com", "password");


    @Test
    public void createOrderHistory() {

        OrderHistory orderHistory = new OrderHistoryFactory().createOrderHistory(user, 30, new BigDecimal(1500));
        assertEquals(user.getUser_id(), orderHistory.getUser().getUser_id());
        assertEquals(1500.00, orderHistory.getTotal_order_value().doubleValue(), 0);
        assertEquals(30, orderHistory.getTotal_number_of_orders());
    }
}
