package com.example.demo.View;

import com.example.demo.Entity.Brand;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Brand.class)
public interface BrandView {
    public String getNameBrand();
    public Integer getCountProducts();
}
