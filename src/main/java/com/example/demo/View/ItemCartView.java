package com.example.demo.View;

import com.example.demo.Entity.ItemCart;
import com.example.demo.Entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = ItemCart.class)
public interface ItemCartView {
    public Product getProduct();
    public Integer getCant();
}
