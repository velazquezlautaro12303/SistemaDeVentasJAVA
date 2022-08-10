package com.example.demo.View;

import com.example.demo.Entity.Coupon;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Coupon.class)
public interface CouponView {
    public Integer getId();
    public String getCodCoupon();
    public Integer getDiscount();
    public Boolean getAvailable();
}
