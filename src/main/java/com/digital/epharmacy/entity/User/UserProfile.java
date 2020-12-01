package com.digital.epharmacy.entity.User;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
;

/*
 * Author: Nicole Hawthorne
 * Desc: UserProfile entity for registered user information
 * Date: 03/07/2020
 * */

/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key as ID also added noBlank values each entity so that its not empty
 and changed default constructor to protected.
 Lastly added equals and hashcode for Id
 * Date: 25/10/2020
 * */
//main class
@Entity
@Table(name = "users")
public class UserProfile {
    //naming entity attributes and assigning their variable values
    @Id
    @GeneratedValue(generator = "USER-generator")
    @GenericGenerator(name = "USER-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "USER"),
            strategy = "com.digital.epharmacy.util.CustomIDGenerator")
    @Column(name = "id", columnDefinition = "varchar(255)")
    private String id;
    @NotNull(message = "Name is required")
    private String user_name;
    @NotNull(message = "Surname is required")
    private String user_surname;
    private String gender;
    @Email(message = "Email Address is required")
    private String email;
    private String password;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "contact_id")
    @Embedded
    private ContactInformation contact;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
    @Embedded
    private Address address;
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "medical_aid_id")
    @Embedded
    private MedicalAid medical_aid;


    protected UserProfile(){}

    //constructor for Builder class
    private UserProfile (Builder builder){
        this.id = builder.id;
        this.user_name = builder.user_name;
        this.user_surname = builder.user_surname;
        this.gender = builder.gender;
        this.address = builder.address;
        this.contact = builder.contact;
        this.medical_aid = builder.medical_aid;
        this.email = builder.email;
        this.password = builder.password;

    }
    //getters to get all values of attributes


    public String getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public String getGender() {
        return gender;
    }

    public ContactInformation getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public MedicalAid getMedical_aid() {
        return medical_aid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // toString to display what is in the UserProfile class

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_surname='" + user_surname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                ", address=" + address +
                ", medical_aid=" + medical_aid +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder{
        //same assigned attributes in main class with variable values
        private String id;
        private String user_name, user_surname, gender, email, password;
        private ContactInformation contact;
        private Address address;
        private MedicalAid medical_aid;


        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUser_name(String user_name) {
            this.user_name = user_name;
            return this;
        }

        public Builder setUser_surname(String user_surname) {
            this.user_surname = user_surname;
            return this;
        }

        //setting Gender value using builder pattern
        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setContact(ContactInformation contact) {
            this.contact = contact;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setMedical_aid(MedicalAid medical_aid) {
            this.medical_aid = medical_aid;
            return this;
        }

        // Builder copy method that create instance of UserProfile and makes a copy out of it
        public Builder copy(UserProfile userProfile){
            this.id = userProfile.id;
            this.user_name = userProfile.user_name;
            this.user_surname = userProfile.user_surname;
            this.gender = userProfile.gender;
            this.medical_aid = userProfile.medical_aid;
            this.address = userProfile.address;
            this.contact = userProfile.contact;
            this.email = userProfile.email;
            this.password = userProfile.password;
            return this;

        }
        //creating and instance of this class
        public UserProfile build(){
            return new UserProfile(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user_name, that.user_name) &&
                Objects.equals(user_surname, that.user_surname) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(address, that.address) &&
                Objects.equals(medical_aid, that.medical_aid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_name, user_surname, gender, email, password, contact, address, medical_aid);
    }
}
