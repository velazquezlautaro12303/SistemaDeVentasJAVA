package com.example.demo.View;

import com.example.demo.Entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = User.class)
public interface UserView {
    public Integer getId();
    public String getNameUser();
    public String getPassword();
    public Boolean getAvailable();
}
