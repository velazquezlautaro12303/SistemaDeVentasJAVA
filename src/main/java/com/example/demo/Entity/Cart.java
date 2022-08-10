package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "Carts")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id", insertable = false,updatable = false, nullable = false)
    private Integer userId;
    @Basic
    @Column(name = "methodBuy_id", insertable = false,updatable = false, nullable = false)
    private Integer methodBuyId;
    @Basic
    @CreationTimestamp
    @Column(name = "date")
    private LocalDateTime date;
    @Basic
    @Column(name = "total")
    private Integer total;
    @Basic
    @Column(name = "cupon_id", insertable = false,updatable = false)
    private Integer couponId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "methodBuy_id", referencedColumnName = "id", nullable = false)
    private MethodBuy methodBuy;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cupon_id", referencedColumnName = "id")
    private Coupon coupon;
    @JsonBackReference
    @OneToMany(mappedBy = "cart")
    private Collection<ItemCart> itemCarts;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMethodBuyId() {
        return methodBuyId;
    }

    public void setMethodBuyId(Integer methodBuyId) {
        this.methodBuyId = methodBuyId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    /* public void setDate(Timestamp date) {
        this.date = date;
    }*/

    public Integer getCouponId() {
        return couponId;
    }

    public void setCuponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (id != null ? !id.equals(cart.id) : cart.id != null) return false;
        if (userId != null ? !userId.equals(cart.userId) : cart.userId != null) return false;
        if (methodBuyId != null ? !methodBuyId.equals(cart.methodBuyId) : cart.methodBuyId != null) return false;
        if (date != null ? !date.equals(cart.date) : cart.date != null) return false;
        if (couponId != null ? !couponId.equals(cart.couponId) : cart.couponId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (methodBuyId != null ? methodBuyId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (couponId != null ? couponId.hashCode() : 0);
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MethodBuy getMethodBuy() {
        return methodBuy;
    }

    public void setMethodBuy(MethodBuy methodBuy) {
        this.methodBuy = methodBuy;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Collection<ItemCart> getItemCarts() {
        return this.itemCarts;
    }

    public void setItemCarts(Collection<ItemCart> itemCarts) {
        this.itemCarts = itemCarts;
    }

}
