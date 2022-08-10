package com.example.demo.View;

import com.example.demo.Entity.MethodBuy;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = MethodBuy.class)
public interface MethodBuyView {

    public Integer getId();
    public String getNameMethod();

}
