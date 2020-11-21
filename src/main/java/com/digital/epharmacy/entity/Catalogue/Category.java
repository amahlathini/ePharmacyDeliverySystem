package com.digital.epharmacy.entity.Catalogue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private long category_id;
    @NotNull
    private String category_name;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String category_image;

    protected Category() {
    }

    private Category(Builder builder) {
        this.category_id = builder.category_id;
        this.category_name = builder.category_name;
        this.category_image = builder.category_image;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_image() {
        return category_image;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", category_image=" + category_image +
                '}';
    }

    public static class Builder {
        //setting  value using builder pattern
        private long category_id;
        private String category_name;
        private String category_image;

        public Builder setCategory_id(Long category_id) {
            this.category_id = category_id;
            return this;
        }

        public Builder setCategory_name(String category_name) {
            this.category_name = category_name;
            return this;
        }

        public Builder setCategory_image(String category_image) {
            this.category_image = category_image;
            return this;
        }

        //Copy method
        public Builder copy(Category category){
            this.category_id = category.category_id;
            this.category_name = category.category_name;
            this.category_image = category.category_image;
            return this;
        }

        //creating an instance
        public Category build() {
            return new Category(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return category_id == category.category_id &&
                category_name.equals(category.category_name) &&
                Objects.equals(category_image, category.category_image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, category_name, category_image);
    }
}
