package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Products")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "nameProduct", nullable = false)
    private String nameProduct;
    @Basic
    @Column(name = "price", nullable = false)
    private Double price;
    @Basic
    @Column(name = "brand_id", insertable = false,updatable = false, nullable = false)
    private Integer brandId;
    @Basic
    @Column(name = "category_id", insertable = false,updatable = false, nullable = false)
    private Integer categoryId;
    @Basic
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Collection<ItemCart> itemCarts;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    private Brand brand;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (nameProduct != null ? !nameProduct.equals(product.nameProduct) : product.nameProduct != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (brandId != null ? !brandId.equals(product.brandId) : product.brandId != null) return false;
        if (categoryId != null ? !categoryId.equals(product.categoryId) : product.categoryId != null) return false;
        if (stock != null ? !stock.equals(product.stock) : product.stock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameProduct != null ? nameProduct.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        return result;
    }

    public Collection<ItemCart> getItemCarts() {
        return itemCarts;
    }

    public void setItemCarts(Collection<ItemCart> itemCarts) {
        this.itemCarts = itemCarts;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
