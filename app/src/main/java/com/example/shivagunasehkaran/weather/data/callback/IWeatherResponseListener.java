package com.example.shivagunasehkaran.weather.data.callback;

import com.example.shivagunasehkaran.weather.model.WeatherPOJO;

public interface IWeatherResponseListener {

    void onSuccess(WeatherPOJO weatherPOJO);

    void onError();

    void loadOfflineData();

}
