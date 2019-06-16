package com.example.shivagunasehkaran.weather.data.remote;

import com.example.shivagunasehkaran.weather.model.WeatherPOJO;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface IWeatherApi {

    @GET("2.5/weather")
    Call<WeatherPOJO> loadData(@Query("q") String city, @Query("APPID") String apiId);
}
