package com.digital.epharmacy.entity.Order;

/*
 * Author: Matthew Pearce
 * Desc: Order Entity composed of Order and OrderReceipt entity that stores the Order and Order Receipt of the customer
 * Date: 04/07/2020
 * */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 *
 * Author: Ayabulela Mahlathini - altered entity to connect to database
 * 25/10/2020
 *
 * */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders") //Order seems to be a reserved word, had to change to ORDERS
public class Order {

    //Entity attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", insertable = false, updatable = false)
    private Long id; // (Ayabulela Mahlathini) changed order number to string so that it is auto generated in the factor;
    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserProfile user;
    private BigDecimal order_total;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CatalogueItem> items = new ArrayList<>(); //Ayabulela Mahlathini - for relationship with CatalogueItem Entity
    private int total_catalogue_items;
    private String payment_type;
    private String order_status; //(Ayabulela Mahlathini)added order_status
    private String date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Pharmacy pharmacy;


    //default contructor - Ayabulela Mahlathini
    protected Order(){}

    //Builder class constructor
    private Order(Builder builder){

        this.user =  builder.user;
        this.id = builder.id;
        this.items = builder.items;
        this.total_catalogue_items = builder.total_catalogue_items;
        this.order_total = builder.order_total;
        this.payment_type = builder.payment_type;
        this.order_status = builder.order_status;

        this.date = builder.date;
    }
    //Getters for all attributes.

    public Long getId() {
        return id;
    }

    public UserProfile getUser() {
        return user;
    }

    public BigDecimal getOrder_total() {
        return order_total;
    }

    public List<CatalogueItem> getItems() {
        return items;
    }

    public int getTotal_catalogue_items() {
        return total_catalogue_items;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getDate() {
        return date;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    //toString method that displays whats in the order class


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", order_total=" + order_total +
                ", items=" + items +
                ", total_catalogue_items=" + total_catalogue_items +
                ", payment_type='" + payment_type + '\'' +
                ", order_status='" + order_status + '\'' +
                ", date='" + date + '\'' +
                ", pharmacy=" + pharmacy +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{


        private UserProfile user;
        private long id;
        private List<CatalogueItem> items;
        private int total_catalogue_items;
        private BigDecimal order_total;
        private String payment_type, order_status;
        private Pharmacy pharmacy;
        private String date;

        // setting user value using builder pattern


        public Builder setUser(UserProfile user) {
            this.user = user;
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setItems(List<CatalogueItem> items) {
            this.items = items;
            return this;
        }

        public Builder setTotal_catalogue_items(int total_catalogue_items) {
            this.total_catalogue_items = total_catalogue_items;
            return this;
        }

        public Builder setOrder_total(BigDecimal order_total) {
            this.order_total = order_total;
            return this;
        }

        public Builder setPayment_type(String payment_type) {
            this.payment_type = payment_type;
            return this;
        }

        public Builder setOrder_status(String order_status) {
            this.order_status = order_status;
            return this;
        }

        public Builder setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        // Builder copy method that create instance of Order
        public Builder copy(Order order){

            this.user = order.user;
            this.id = order.id;
            this.items = order.items;
            this.total_catalogue_items = order.total_catalogue_items;
            this.order_total = order.order_total;
            this.payment_type = order.payment_type;
            this.order_status = order.order_status;
            this.date = order.date;

            return this;
        }

        //creating an instance of this class
        public Order build(){return new Order(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return total_catalogue_items == order.total_catalogue_items &&
                id.equals(order.id) &&
                user.equals(order.user) &&
                order_total.equals(order.order_total) &&
                items.equals(order.items) &&
                Objects.equals(payment_type, order.payment_type) &&
                Objects.equals(order_status, order.order_status) &&
                Objects.equals(date, order.date) &&
                Objects.equals(pharmacy, order.pharmacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, order_total, items, total_catalogue_items, payment_type, order_status, date, pharmacy);
    }
}