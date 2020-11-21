package com.digital.epharmacy.entity.User;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
;

/*
 * Author: Nicole Hawthorne
 * Desc: MedicalAid entity composed of UserProfile entity that stores user Medical Aid information if there is any.
 * Date: 03/07/2020
 *
 * Edited By Opatile Kelobang
 * Date: 25 September 2020
 *
 * Modified: 26 October 2020
 * Updated Method call for Read by Pharmacy name
 *
 * */

//@Entity
@Embeddable
//@Table(name = "medical_aids")
public class MedicalAid {
    //naming entity attributes and assigning their variable values
//    @Id
//    @Column(name = "medical_aid_id")
//    private String medical_aid_id;
    @NotNull(message = "Medical aid number is required")
    @Range(min = 1, max = 2147483647, message = "Medical aid number is required")
    private int user_medical_aid_number;
    @NotNull(message = "Medical aid scheme is required")
    private String medical_aid_scheme;
    @NotNull(message = "Medical aid name is required")
    private String medical_aid_name;
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "user_id")
//    private UserProfile user;


    protected MedicalAid(){}

    //constructor for Builder class
    private MedicalAid (Builder builder){
       // this.medical_aid_id = builder.medical_aid_id;
        this.user_medical_aid_number = builder.user_medical_aid_number;
        this.medical_aid_name = builder.medical_aid_name;
        this.medical_aid_scheme = builder.medical_aid_scheme;
       // this.user = builder.user;
     
    }
    
    //getters to get all values of attributes


//    public String getMedical_aid_id() {
//        return medical_aid_id;
//    }

    public int getUser_medical_aid_number() {
        return user_medical_aid_number;
    }

    public String getMedical_aid_scheme() {
        return medical_aid_scheme;
    }

    public String getMedical_aid_name() {
        return medical_aid_name;
    }


//    public UserProfile getUser() {
//        return user;
//    }

    // toString to display what is in the Medical Aid class
    @Override
    public String toString() {
        return "MedicalAid{" +
               // "userId=" + medical_aid_id +
                ", user_medical_aid_number=" + user_medical_aid_number +
                ", medical_aid_name='" + medical_aid_name + '\'' +
                ", medical_aid_scheme='" + medical_aid_scheme + '\'' +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder{
        //same assigned attributes in main class with variable values
        private int  user_medical_aid_number;
        private String medical_aid_name, medical_aid_scheme;
       // private String medical_aid_id;
        //private UserProfile user;

        //setting UserId value using builder pattern


        public Builder setUser_medical_aid_number(int user_medical_aid_number) {
            this.user_medical_aid_number = user_medical_aid_number;
            return this;
        }

        public Builder setMedical_aid_name(String medical_aid_name) {
            this.medical_aid_name = medical_aid_name;
            return this;
        }

        public Builder setMedical_aid_scheme(String medical_aid_scheme) {
            this.medical_aid_scheme = medical_aid_scheme;
            return this;
        }

//        public Builder setMedical_aid_id(String medical_aid_id) {
//            this.medical_aid_id = medical_aid_id;
//            return this;
//        }

//        public Builder setUser(UserProfile user) {
//            this.user = user;
//            return this;
//        }

        // Builder copy method that create instance of MedicalAid and makes a copy out of it
        public Builder copy(MedicalAid medicalAid){
          //  this.medical_aid_id = medicalAid.medical_aid_id;
            this.user_medical_aid_number = medicalAid.user_medical_aid_number;
            this.medical_aid_name = medicalAid.medical_aid_name;
            this.medical_aid_scheme = medicalAid.medical_aid_scheme;
            //this.user = medicalAid.user;
            return this;

        }
        //creating and instance of this class
        public MedicalAid build(){
            return new MedicalAid(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalAid that = (MedicalAid) o;
        return user_medical_aid_number == that.user_medical_aid_number &&
              //  medical_aid_id.equals(that.medical_aid_id) &&
                Objects.equals(medical_aid_scheme, that.medical_aid_scheme) &&
                Objects.equals(medical_aid_name, that.medical_aid_name);
                //Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_medical_aid_number, medical_aid_scheme, medical_aid_name);
    }
}