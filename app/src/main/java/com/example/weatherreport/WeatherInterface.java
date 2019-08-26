package com.example.weatherreport;

import com.example.weatherreport.models.WeatherForcast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WeatherInterface {

    @GET
    Call<WeatherForcast> getData(@Url String url);

}
