package com.example.demo;

import com.example.demo.Services.ServiceSpring;
import com.example.demo.Services.ServicioGeoref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private ServiceSpring serviceSpring;

    @Override
    public void run(String... args) throws Exception {
        this.serviceSpring.init();
    }
}

