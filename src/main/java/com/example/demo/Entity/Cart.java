package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Carts", schema = "SistemaVentas", catalog = "")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id", insertable = false,updatable = false)
    private Integer userId;
    @Basic
    @Column(name = "methodBuy_id", insertable = false,updatable = false)
    private Integer methodBuyId;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "cupon_id", insertable = false,updatable = false)
    private Integer cuponId;
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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cupon_id", referencedColumnName = "id")
    private Coupon coupon;
    @JsonBackReference
    @OneToMany(mappedBy = "cart")
    private Collection<ItemCart> itemCarts;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getCuponId() {
        return cuponId;
    }

    public void setCuponId(Integer cuponId) {
        this.cuponId = cuponId;
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
        if (cuponId != null ? !cuponId.equals(cart.cuponId) : cart.cuponId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (methodBuyId != null ? methodBuyId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (cuponId != null ? cuponId.hashCode() : 0);
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
        return itemCarts;
    }

    public void setItemCarts(Collection<ItemCart> itemCarts) {
        this.itemCarts = itemCarts;
    }
}
