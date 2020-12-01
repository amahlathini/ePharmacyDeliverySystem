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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", insertable = false, updatable = false)
    private long id;
    @NotNull
    private String category_name;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String category_image;

    protected Category() {
    }

    private Category(Builder builder) {
        this.id = builder.id;
        this.category_name = builder.category_name;
        this.category_image = builder.category_image;
    }

    public Long getId() {
        return id;
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
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                ", category_image=" + category_image +
                '}';
    }

    public static class Builder {
        //setting  value using builder pattern
        private long id;
        private String category_name;
        private String category_image;

        public Builder setId(Long id) {
            this.id = id;
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
            this.id = category.id;
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
        return id == category.id &&
                category_name.equals(category.category_name) &&
                Objects.equals(category_image, category.category_image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category_name, category_image);
    }
}
