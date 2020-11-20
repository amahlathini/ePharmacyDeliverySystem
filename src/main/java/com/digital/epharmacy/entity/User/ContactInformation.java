package com.digital.epharmacy.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
;

/*
 * Author: Nicole Hawthorne
 * Desc: ContactInformation entity composed of UserProfile
 *       and Pharmacy entity that stores user and pharmacy contact information
 * Date: 03/07/2020
 * */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 Also created the class for all userProfile composite keys
 * Date: 25/10/2020
 * */
//main class
@Entity
@Table(name = "contacts")
public class ContactInformation {
    //naming entity attributes and assigning their variable values
    @Id
    @Column(name = "user_id")
    private String contact_id;
    private String primary_number;
    private String secondary_number;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserProfile user;

    protected ContactInformation(){}
    
    //constructor for Builder class
    private ContactInformation (Builder builder){
        this.contact_id = builder.contact_id;
        this.primary_number = builder.primary_number;
        this.secondary_number = builder.secondary_number;
        this.user = builder.user;
    }

    //getters to get all values of attributes


    public String getContact_id() {
        return contact_id;
    }

    public String getPrimary_number() {
        return primary_number;
    }

    public String getSecondary_number() {
        return secondary_number;
    }

    public UserProfile getUser() {
        return user;
    }

    // toString to display what is in the ContactInformation class
    @Override
    public String toString() {
        return "ContactInformation{" +
                "contact_id=" + contact_id +
                ", primary_number=" + primary_number +
                ", secondary_number=" + secondary_number +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder{
        private String primary_number;
        private String secondary_number;
        private String contact_id;
        private UserProfile user;

        //setting UserId value using builder pattern

        public Builder setPrimary_number(String primary_number) {
            this.primary_number = primary_number;
            return this;
        }

        public Builder setSecondary_number(String secondary_number) {
            this.secondary_number = secondary_number;
            return this;
        }

        public Builder setContact_id(String contact_id) {
            this.contact_id = contact_id;
            return this;
        }

        public Builder setUser(UserProfile user) {
            this.user = user;
            return this;
        }

        // Builder copy method that create instance of ContactInformation and makes a copy out of it
        public Builder copy(ContactInformation contactInformation){
            this.contact_id = contactInformation.contact_id;
            this.primary_number = contactInformation.primary_number;
            this.secondary_number = contactInformation.secondary_number;
            this.user = contactInformation.user;
            return this;
        }

        //creating and instance of this class
        public ContactInformation build(){
            return new ContactInformation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation that = (ContactInformation) o;
        return contact_id.equals(that.contact_id) &&
                primary_number.equals(that.primary_number) &&
                Objects.equals(secondary_number, that.secondary_number) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact_id, primary_number, secondary_number, user);
    }
}
