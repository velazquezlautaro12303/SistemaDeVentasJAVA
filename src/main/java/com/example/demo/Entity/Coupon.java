package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Coupons")
public class Coupon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "codCoupon", nullable = false)
    private String codCoupon;
    @Basic
    @ColumnDefault("true")
    @Column(name = "available", nullable = false)
    private Boolean available;
    @Basic
    @Column(name = "discount", nullable = false)
    private Integer discount;
    @JsonBackReference
    @OneToMany(mappedBy = "coupon")
    private Collection<Cart> carts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodCoupon() {
        return codCoupon;
    }

    public void setCodCoupon(String codCoupon) {
        this.codCoupon = codCoupon;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        if (id != null ? !id.equals(coupon.id) : coupon.id != null) return false;
        if (codCoupon != null ? !codCoupon.equals(coupon.codCoupon) : coupon.codCoupon != null) return false;
        if (available != null ? !available.equals(coupon.available) : coupon.available != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codCoupon != null ? codCoupon.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }

    public Collection<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Collection<Cart> carts) {
        this.carts = carts;
    }
}
