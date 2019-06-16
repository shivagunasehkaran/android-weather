package com.example.shivagunasehkaran.weather.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.shivagunasehkaran.weather.AppConstants;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ApiClient {

    public IWeatherApi getInstance() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(IWeatherApi.class);
    }

}
