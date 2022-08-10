package com.example.demo.View;

import com.example.demo.Entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CategoryView {
    public String getNameCategory();
}
