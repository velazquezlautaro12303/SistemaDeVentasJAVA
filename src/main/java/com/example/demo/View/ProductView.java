package com.example.demo.View;

import com.example.demo.Entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface ProductView {
    Long getId();

    public String getNameProduct();

    public Double getPrice();

    public Integer getBrandId();

    public Integer getCategoryId();

    public Integer getStock();
}