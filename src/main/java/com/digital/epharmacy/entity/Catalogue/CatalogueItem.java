package com.digital.epharmacy.entity.Catalogue;

/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item Entity composed of Pharmacy Catalogue
 * Date: 04/07/2020
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "items")
public class CatalogueItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long item_number;
    @NotNull
    private int item_quantity;
    @NotNull
    private String item_name;
    private String item_description;
    @NotNull
    private BigDecimal item_price;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String item_image;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    //non argument constructor
    protected CatalogueItem(){}
    //constructor for Builder class
    private CatalogueItem(Builder builder) {
        this.item_description = builder.item_description;
        this.item_name = builder.item_name;
        this.item_number = builder.item_number;
        this.item_quantity = builder.item_quantity;
        this.item_price = builder.item_price;
        this.item_image = builder.item_image;
        this.category = builder.category;
        this.pharmacy = builder.pharmacy;
    }

    //getters to get all values of attributes

    public Long getItem_number() {
        return item_number;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public BigDecimal getItem_price() {
        return item_price;
    }

    public String getItem_image() {
        return item_image;
    }

    public Category getCategory() {
        return category;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }


    // toString to display what is in the ContactInformation class


    @Override
    public String toString() {
        return "CatalogueItem{" +
                "item_number=" + item_number +
                ", item_quantity=" + item_quantity +
                ", item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                ", item_price=" + item_price +
                ", item_image=" + item_image +
                ", category=" + category +
                ", pharmacy=" + pharmacy +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder {
        //setting  value using builder pattern
        private long item_number;
        private int item_quantity;
        String item_name, item_description;
        BigDecimal item_price;
        private String item_image;
        private Category category;
        private Pharmacy pharmacy;

        public Builder setItem_number(Long item_number) {
            this.item_number = item_number;
            return this;
        }

        public Builder setItem_quantity(int item_quantity) {
            this.item_quantity = item_quantity;
            return this;
        }

        public Builder setItem_name(String item_name) {
            this.item_name = item_name;
            return this;
        }

        public Builder setItem_description(String item_description) {
            this.item_description = item_description;
            return this;
        }

        public Builder setItem_price(BigDecimal item_price) {
            this.item_price = item_price;
            return this;
        }

        public Builder setItem_image(String item_image) {
            this.item_image = item_image;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
            return this;
        }

        //Copy method
        public Builder copy(CatalogueItem catalogueItem){
            this.item_number = catalogueItem.item_number;
            this.item_quantity = catalogueItem.item_quantity;
            this.item_name = catalogueItem.item_name;
            this.item_description = catalogueItem.item_description;
            this.item_price = catalogueItem.item_price;
            this.item_image = catalogueItem.item_image;
            this.category = catalogueItem.category;
            this.pharmacy = catalogueItem.pharmacy;
            return this;
        }

        //creating an instance
        public CatalogueItem build() {
            return new CatalogueItem(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogueItem that = (CatalogueItem) o;
        return item_number == that.item_number &&
                item_quantity == that.item_quantity &&
                item_name.equals(that.item_name) &&
                Objects.equals(item_description, that.item_description) &&
                item_price.equals(that.item_price) &&
                Objects.equals(item_image, that.item_image) &&
                category.equals(that.category) &&
                pharmacy.equals(that.pharmacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_number, item_quantity, item_name, item_description, item_price, item_image, category, pharmacy);
    }
}

