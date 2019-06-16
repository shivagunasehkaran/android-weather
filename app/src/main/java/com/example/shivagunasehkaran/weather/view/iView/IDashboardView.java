package com.example.shivagunasehkaran.weather.view.iView;

import com.example.shivagunasehkaran.weather.data.db.City;
import com.example.shivagunasehkaran.weather.data.db.WeatherReport;
import com.example.shivagunasehkaran.weather.data.db.WeatherRepository;
import com.example.shivagunasehkaran.weather.model.WeatherPOJO;

import java.util.List;

public interface IDashboardView extends IBaseView {

    void showWeather(WeatherPOJO weatherResponse);

    void setSpinnerAdapter(List<City> cities);

    void fetchCities();

    WeatherRepository getWeatherRespority();

    WeatherReport fetchWeatherReportWithCityId(int cityId);

}
