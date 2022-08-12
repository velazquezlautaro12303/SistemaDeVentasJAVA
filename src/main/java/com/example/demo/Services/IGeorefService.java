package com.example.demo.Services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IGeorefService {
    @GET("dolaroficial")
    Call<API_DOLAR> apiDolar();
}
