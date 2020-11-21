package com.digital.epharmacy.entity.User;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
;

/*
 * Author: Nicole Hawthorne
 * Desc: Address Entity composed of User Profile and Pharmacy entity that stores the user and pharmacy address/location
 * Date: 03/07/2020
 * */

/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 * */
//main class
//@Entity
//@Table(name = "addresses")
@Embeddable
public class Address {
    //naming entity attributes and assigning their variable values
//    @Id
//    @Column(name = "address_id")
//    private String address_id;
    @NotNull(message = "Street number is required")
    @Range(min = 1, max = 2147483647, message = "Street number is required")
    private int street_number;
    @NotNull(message = "Area code is required")
    @Range(min = 1, max = 2147483647, message = "Area code is required")
    private int area_code;
    @NotNull(message = "Street name is required")
    private String street_name;
    @NotNull(message = "Area name is required")
    private String area_name;
    //@OneToOne
    //@MapsId
    //@JoinColumn(name = "user_id")
    //private UserProfile user;




    // Added default constructor for SpringBoot implementation.
    protected Address(){

    }
    //constructor for Builder class
    private Address (Builder builder){
       // this.address_id = builder.address_id;
        this.street_number = builder.street_number;
        this.area_code = builder.area_code;
        this.street_name = builder.street_name;
        this.area_name = builder.area_name;
        //this.user = builder.user;
    }

    //getters to get all values of attributes


//    public String getAddress_id() {
//        return address_id;
//    }

    public int getStreet_number() {
        return street_number;
    }

    public int getArea_code() {
        return area_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public String getArea_name() {
        return area_name;
    }

//    public UserProfile getUser() {
//        return user;
//    }

    // toString to display what is in the Address class
    @Override
    public String toString() {
        return "Address{" +
             //   ", pharmacyId=" + address_id +
                ", street_number=" + street_number +
                ", area_code=" + area_code +
                ", street_name='" + street_name + '\'' +
                ", area_name='" + area_name + '\'' +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder {
        private String address_id;
        private int street_number, area_code;
        private String street_name, area_name;
       // private UserProfile user;

        //setting PharmacyId value using builder pattern


        public Builder setAddress_id(String address_id) {
            this.address_id = address_id;
            return this;
        }

        public Builder setStreet_number(int street_number) {
            this.street_number = street_number;
            return this;
        }

        public Builder setArea_code(int area_code) {
            this.area_code = area_code;
            return this;
        }

        public Builder setStreet_name(String street_name) {
            this.street_name = street_name;
            return this;
        }

        public Builder setArea_name(String area_name) {
            this.area_name = area_name;
            return this;
        }

//        public Builder setUser(UserProfile user) {
//            this.user = user;
//            return this;
//        }

        // Builder copy method that create instance of ContactInformation and makes a copy out of it
        public Builder copy(Address address){
           // this.address_id = address.address_id;
            this.street_number = address.street_number;
            this.area_code = address.area_code;
            this.street_name = address.street_name;
            this.area_name = address.area_name;
            //this.user = address.user;
            return this;
        }

        //creating and instance of this class
        public Address build(){
            return new Address(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street_number == address.street_number &&
                area_code == address.area_code &&
              //  address_id.equals(address.address_id) &&
                street_name.equals(address.street_name) &&
                area_name.equals(address.area_name);
                //Objects.equals(user, address.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street_number, area_code, street_name, area_name);
    }
}
