package com.example.demo.Services;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ServiceSpring {

    private double compra;

    public ServiceSpring() {
    }

    public void init() throws IOException {

        ServicioGeoref servicioGeoref = new ServicioGeoref();
        API_DOLAR api_dolar = servicioGeoref.apiDolar();
        this.compra = api_dolar.compra;

    }

    public double getCompra() {
        return this.compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }
}
