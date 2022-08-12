package com.example.demo.View;

import com.example.demo.Entity.Product;
import com.example.demo.Services.ServiceSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.Transient;
import java.text.DecimalFormat;

@Projection(types = Product.class)
public interface ProductView {

    Long getId();

    public String getNameProduct();

    public Double getPrice();

    public Integer getBrandId();

    public Integer getCategoryId();

    public Integer getStock();
}