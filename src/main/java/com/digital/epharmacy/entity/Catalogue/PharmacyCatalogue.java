//package com.digital.epharmacy.entity.Catalogue;
//
//import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.HashSet;
//import java.util.Set;
//
///*
//Name: Nelson Mpyana
// * Desc: Pharmacy Catalogue Entity composed of Pharmacy
// * Date: 04/07/2020
// */
//
//@Entity
//public class PharmacyCatalogue {
//    @Id
//    @Column(name = "catalogue_id")
//    private String catalogue_id;
//    @NotNull(message = "Catalogue Name is required")
//    private String catalogue_name;
//    @NotNull(message = "Catalogue Description is required")
//    private String catalogue_desc;
//    @OneToOne
//    @PrimaryKeyJoinColumn(name = "pharmacy_id")
//    private Pharmacy pharmacy;
//    protected PharmacyCatalogue(){}
//    //constructor for Builder class
//    private PharmacyCatalogue(Builder builder) {
//        this.catalogue_id = builder.catalogue_id;
//        this.catalogue_name = builder.catalogue_name;
//        this.catalogue_desc = builder.catalogue_desc;
//        this.pharmacy = builder.pharmacy;
//
//
//    }
//    // Mutators (getters) for pharmacy catalogue
//
//    public String getCatalogueId() {
//        return catalogue_id;
//    }
//
//    public String getCatalogueName() {
//        return catalogue_name;
//    }
//
//    public String getCatalogueDescription() {
//        return catalogue_desc;
//    }
//
//    public Pharmacy getPharmacy() {
//        return pharmacy;
//    }
//
//    //to String method
//
//    @Override
//    public String toString() {
//        return "PharmacyCatalogue{" +
//                "catalogue_id='" + catalogue_id + '\'' +
//                ", catalogue_name='" + catalogue_name + '\'' +
//                ", catalogue_desc='" + catalogue_desc + '\'' +
//                ", pharmacy=" + pharmacy +
//                '}';
//    }
//
//    //create a inner static builder class (Immutable)
//    public static class Builder {
//
//        private String catalogue_id;
//        private String catalogue_name, catalogue_desc;
//        private Pharmacy pharmacy;
//
//        public Builder setCatalogueId(String catalogue_id) {
//            this.catalogue_id = catalogue_id;
//            return this;
//        }
//
//        public Builder setCatalogueName(String catalogue_name) {
//            this.catalogue_name = catalogue_name;
//            return this;
//        }
//
//        public Builder setCatalogueDescription(String catalogue_desc) {
//            this.catalogue_desc = catalogue_desc;
//            return this;
//        }
//
//        public Builder setPharmacy(Pharmacy pharmacy) {
//            this.pharmacy = pharmacy;
//            return this;
//        }
//
//        // Builder copy method that create instance of ContactInformation and makes a copy out of it
//        public PharmacyCatalogue.Builder copy(PharmacyCatalogue pharmacyCatalogue) {
//            this.catalogue_id = pharmacyCatalogue.catalogue_id;
//            this.catalogue_name = pharmacyCatalogue.catalogue_name;
//            this.catalogue_desc = pharmacyCatalogue.catalogue_desc;
//            this.pharmacy = pharmacyCatalogue.pharmacy;
//            return this;
//        }
//
//        public PharmacyCatalogue build() {
//
//            return new PharmacyCatalogue(this);
//        }
//    }
//
//
//}
