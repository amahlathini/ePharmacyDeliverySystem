package com.digital.epharmacy.entity.Order;
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 * Author: Ayabulela Mahlathini - altered entity to connect to database
 * 25/10/2020
 * */
import com.digital.epharmacy.entity.User.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
;

@Entity
@Table(name = "history")
public class OrderHistory implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull(message = "User is required")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    private UserProfile user;
    @NotNull(message = "Total number of orders is required")
    private int total_number_of_orders;
    @NotNull(message = "Total Order value is required")
    private BigDecimal total_order_value; //Ayabulela Mahlathini - change from double to BigDecimal

    //default contructor - Ayabulela Mahlathini
    protected OrderHistory(){}

    public OrderHistory(Builder builder){
        this.id = builder.id;
        this.user = builder.user;
        this.total_number_of_orders = builder.total_number_of_orders;
        this.total_order_value = builder.total_order_value;
    }

    public String getId() {
        return id;
    }

    public UserProfile getUser() {
        return user;
    }

    public int getTotal_number_of_orders() {
        return total_number_of_orders;
    }

    public BigDecimal getTotal_order_value() {
        return total_order_value;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", user=" + user +
                ", total_number_of_orders=" + total_number_of_orders +
                ", total_order_value=" + total_order_value +
                '}';
    }

    public static class Builder{
        private String id;
        private UserProfile user;
        private int total_number_of_orders;
        private BigDecimal total_order_value;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUser(UserProfile user) {
            this.user = user;
            return this;
        }

        public Builder setTotal_number_of_orders(int total_number_of_orders) {
            this.total_number_of_orders = total_number_of_orders;
            return this;
        }

        public Builder setTotal_order_value(BigDecimal total_order_value) {
            this.total_order_value = total_order_value;
            return this;
        }

        public Builder copy(OrderHistory orderHistory){
            this.id = orderHistory.id;
            this.user = orderHistory.user;
            this.total_number_of_orders = orderHistory.total_number_of_orders;
            this.total_order_value= orderHistory.total_order_value;
            return this;
        }

        public OrderHistory build(){
            return  new OrderHistory(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHistory that = (OrderHistory) o;
        return total_number_of_orders == that.total_number_of_orders &&
                id.equals(that.id) &&
                user.equals(that.user) &&
                Objects.equals(total_order_value, that.total_order_value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, total_number_of_orders, total_order_value);
    }
}