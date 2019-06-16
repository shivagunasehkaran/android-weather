package com.example.shivagunasehkaran.weather.presenter.iPresenter;

import com.example.shivagunasehkaran.weather.data.db.City;
import com.example.shivagunasehkaran.weather.data.db.WeatherRepository;

import java.util.List;

public interface IDashboardPresenter {

    void dashboardApiCall(String cityValue, City city);

    void loadWeatherReport(int cityId);

    void insertCity(City city, WeatherRepository weatherRepository);

    void doSpinnerAdapter(List<City> cityList);

    void callFetchCities();

}
