package com.example.demo.View;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Coupon;
import com.example.demo.Entity.ItemCart;
import com.example.demo.Entity.MethodBuy;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.Collection;

@Projection(types = Cart.class)
public interface CartView {
    public Integer getId();
    public MethodBuy getMethodBuy ();
    public Coupon getCoupon();
    public Integer getTotal();
    public LocalDateTime getDate();
}
