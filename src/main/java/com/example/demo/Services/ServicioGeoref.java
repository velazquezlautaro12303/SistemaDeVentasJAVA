package com.example.demo.Services;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioGeoref {
    private static final String apiURL = "https://api-dolar-argentina.herokuapp.com/api/";
    private Retrofit retrofit;

    public ServicioGeoref() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(apiURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public API_DOLAR apiDolar() throws IOException {
        IGeorefService georefService = this.retrofit.create(IGeorefService.class);
        Call<API_DOLAR> requestApi = georefService.apiDolar();

        Response<API_DOLAR> api = requestApi.execute();
        return api.body();
    }
}
