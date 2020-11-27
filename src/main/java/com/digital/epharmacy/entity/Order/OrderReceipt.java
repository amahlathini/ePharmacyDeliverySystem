package com.digital.epharmacy.entity.Order;
/*
 * Author: Keagan Tabisher
 * Desc: OrderReceipt entity composed of Order, Pharmacy, UserProfile, Payment and CatalogueItem
 *       showing the customer their final receipt.
 * String: 04/07/2020
 *
 * Author: Nicole Hawthorne
 * Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 * and changed default constructor to protected
 * String: 25/10/2020
 * */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "receipts")
public class OrderReceipt {

    //Ayabulela Mahlathini - Fixed relationships
    //Entity attributes
    @Id
    @Column(name = "receipt_number")
    private Long receipt_number;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "order_number")
    private Order order;
    @NotNull(message = "Item Qty is required")
    private int quantity;
    @NotNull(message = "Payment total is required")
    private BigDecimal payment_total;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Pharmacy pharmacy;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserProfile user;
    @NotNull(message = "Items are required")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CatalogueItem> items = new ArrayList<>();
    @NotNull(message = "Type of Payment total is required")
    private String type_of_payment;
    @NotNull(message = "String is required")
    private String date;

    // Added default constructor for Springboot implementation.
    protected OrderReceipt() {

    }

    //Builder class constructor
    private OrderReceipt(Builder builder) {

        this.receipt_number = builder.receipt_number;
        this.order = builder.order;
        this.date = builder.date;
        this.pharmacy = builder.pharmacy;
        this.user = builder.user;
        this.payment_total = builder.payment_total;
        this.type_of_payment = builder.type_of_payment;
        this.items = builder.items;
        this.quantity = builder.quantity;
    }

    //Getters for all attributes


    public Long getReceipt_number() {
        return receipt_number;
    }

    public Order getOrder() {
        return order;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPayment_total() {
        return payment_total;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public UserProfile getUser() {
        return user;
    }

    public List<CatalogueItem> getItems() {
        return items;
    }

    public String getType_of_payment() {
        return type_of_payment;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "OrderReceipt{" +
                "receipt_number=" + receipt_number +
                ", order=" + order +
                ", quantity=" + quantity +
                ", payment_total=" + payment_total +
                ", pharmacy=" + pharmacy +
                ", user=" + user +
                ", items=" + items +
                ", type_of_payment='" + type_of_payment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder {

        private long receipt_number;
        private Order order;
        private int quantity;
        private BigDecimal payment_total;
        private Pharmacy pharmacy;
        private UserProfile user;
        private List<CatalogueItem> items;
        private String type_of_payment;
        private String date;


        //setting orderNumber value using builder pattern


        public Builder setReceipt_number(Long receipt_number) {
            this.receipt_number = receipt_number;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPayment_total(BigDecimal payment_total) {
            this.payment_total = payment_total;
            return this;
        }

        public Builder setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
            return this;
        }

        public Builder setUser(UserProfile user) {
            this.user = user;
            return this;
        }

        public Builder setItems(List<CatalogueItem> items) {
            this.items = items;
            return this;
        }

        public Builder setType_of_payment(String type_of_payment) {
            this.type_of_payment = type_of_payment;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        // Builder copy method that create instance of OrderReceipt
        public Builder copy(OrderReceipt orderReceipt) {

            this.receipt_number = orderReceipt.receipt_number;
            this.order = orderReceipt.order;
            this.date = orderReceipt.date;
            this.pharmacy = orderReceipt.pharmacy;
            this.user = orderReceipt.user;
            this.payment_total = orderReceipt.payment_total;
            this.type_of_payment = orderReceipt.type_of_payment;
            this.items = orderReceipt.items;
            this.quantity = orderReceipt.quantity;

            return this;

        }

        //creating an instance of this class
        public OrderReceipt build() {
            return new OrderReceipt(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderReceipt that = (OrderReceipt) o;
        return quantity == that.quantity &&
                receipt_number.equals(that.receipt_number) &&
                order.equals(that.order) &&
                payment_total.equals(that.payment_total) &&
                pharmacy.equals(that.pharmacy) &&
                user.equals(that.user) &&
                items.equals(that.items) &&
                type_of_payment.equals(that.type_of_payment) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receipt_number, order, quantity, payment_total, pharmacy, user, items, type_of_payment, date);
    }
}
