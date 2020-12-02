package com.digital.epharmacy.entity.Payment;


/*Author: Matthew Pearce
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 26/10/2020
 * */
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

//Main class
@Entity
@Table(name = "payments")
public class Payment {

    //Declaring variables using all attributes from the Payment Entity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @NotNull(message = "Payment Status is required")
    private String payment_status;
    @NotNull(message = "Type of Payment is required")
    private String type_of_payment;
    @NotNull(message = "Payment Notification is required")
    private String payment_notification;
    @NotNull(message = "Payment total is required")
    private BigDecimal payment_total;
    @NotNull(message = "Date is required")
    private String date;
    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Order order;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Pharmacy pharmacy;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserProfile user;
    
    protected Payment (){}
    //builder Constructor
    public Payment(Builder builder) {

        this.pharmacy = builder.pharmacy;
        this.user = builder.user;
        this.order = builder.order;
        this.payment_status = builder.payment_status;
        this.type_of_payment = builder.type_of_payment;
        this.id = builder.id;
        this.payment_notification = builder.payment_notification;
        this.payment_total = builder.payment_total;
        this.date = builder.date;
    }

    //getters for the declared variables


    public Long getId() {
        return id;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getType_of_payment() {
        return type_of_payment;
    }

    public String getPayment_notification() {
        return payment_notification;
    }

    public BigDecimal getPayment_total() {
        return payment_total;
    }

    public String getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public UserProfile getUser() {
        return user;
    }

    //displaying all variables as a string
    @Override
    public String toString() {
        return "Payment{" +
                "payment_status='" + payment_status + '\'' +
                ", type_of_payment='" + type_of_payment + '\'' +
                ", id='" + id + '\'' +
                ", payment_notification='" + payment_notification + '\'' +
                ", payment_total=" + payment_total +
                ", date=" + date +
                ", pharmacy=" + pharmacy +
                ", user=" + user +
                ", order=" + order +
                '}';
    }

    //Inner class to implement the builder pattern
    public static class Builder{

        //Declaring variables using all attributes from the Payment Entity, same as the ones from the main class
        private String payment_status, type_of_payment, payment_notification;
        private long id;
        private BigDecimal payment_total;
        private String date;
        private Pharmacy pharmacy;
        private UserProfile user;
        private Order order;

        //Setters for all declared variables using the Builder pattern

        //setting payment_status


        public Builder setPayment_status(String payment_status) {
            this.payment_status = payment_status;
            return this;
        }

        public Builder setType_of_payment(String type_of_payment) {
            this.type_of_payment = type_of_payment;
            return this;
        }

        public Builder setPayment_notification(String payment_notification) {
            this.payment_notification = payment_notification;
            return this;
        }

        public Builder setReference_number(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPayment_total(BigDecimal payment_total) {
            this.payment_total = payment_total;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
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

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        //Builder copy method for creating instance of Payment
        // and making a copy of it
        public Builder copy(Payment payment){

            this.pharmacy = payment.pharmacy;
            this.user = payment.user;
            this.order = payment.order;
            this.payment_status = payment.payment_status;
            this.payment_notification = payment.payment_notification;
            this.payment_total = payment.payment_total;
            this.type_of_payment = payment.type_of_payment;
            this.date = payment.date;
            this.id = payment.id;
            return this;
        }

        //creating an instance of this class
        public Payment build() {
            return new Payment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                payment_status.equals(payment.payment_status) &&
                Objects.equals(type_of_payment, payment.type_of_payment) &&
                Objects.equals(payment_notification, payment.payment_notification) &&
                Objects.equals(payment_total, payment.payment_total) &&
                Objects.equals(date, payment.date) &&
                order.equals(payment.order) &&
                Objects.equals(pharmacy, payment.pharmacy) &&
                Objects.equals(user, payment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payment_status, type_of_payment, payment_notification, payment_total, date, order, pharmacy, user);
    }
}
