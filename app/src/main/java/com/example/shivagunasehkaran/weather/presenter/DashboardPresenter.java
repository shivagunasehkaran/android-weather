package com.example.shivagunasehkaran.weather.presenter;

import com.google.gson.Gson;

import com.example.shivagunasehkaran.weather.data.remote.WeatherApiModel;
import com.example.shivagunasehkaran.weather.data.callback.IWeatherResponseListener;
import com.example.shivagunasehkaran.weather.data.db.City;
import com.example.shivagunasehkaran.weather.data.db.WeatherReport;
import com.example.shivagunasehkaran.weather.data.db.WeatherRepository;
import com.example.shivagunasehkaran.weather.model.WeatherPOJO;
import com.example.shivagunasehkaran.weather.presenter.iPresenter.IDashboardPresenter;
import com.example.shivagunasehkaran.weather.view.iView.IBaseView;
import com.example.shivagunasehkaran.weather.view.iView.IDashboardView;

import java.util.List;

public class DashboardPresenter extends BasePresenter
        implements IDashboardPresenter, IWeatherResponseListener {

    private IDashboardView iDashboardView;
    private int cityId;

    public DashboardPresenter(IBaseView iView) {
        super(iView);

        iDashboardView = (IDashboardView) iView;
        iDashboardView.fetchCities();
    }

    @Override public void dashboardApiCall(String cityStr, City city) {

        cityId = city.getId();

        WeatherApiModel weatherApiModel = new WeatherApiModel(this);
        weatherApiModel.apiCall(city.getCityName(), iDashboardView.isNetworkAvail());
    }

    @Override public void loadWeatherReport(int cityId) {
        this.cityId = cityId;

        WeatherReport weatherReport = iDashboardView.fetchWeatherReportWithCityId(cityId);

        if (weatherReport != null) {
            // Convert String to Pojo
            Gson gsonObj = new Gson();
            WeatherPOJO weatherPOJO = gsonObj.fromJson(weatherReport.getData(), WeatherPOJO.class);

            iDashboardView.showWeather(weatherPOJO);
        } else {
            iDashboardView.showToast("No weather Data");
        }
    }

    @Override public void insertCity(City city, WeatherRepository weatherRepository) {
        iDashboardView.getWeatherRespority().insertCity(city);
    }

    @Override public void doSpinnerAdapter(List<City> cityList) {
        iDashboardView.setSpinnerAdapter(cityList);
    }

    @Override public void callFetchCities() {
        iDashboardView.fetchCities();
    }


    @Override public void onSuccess(WeatherPOJO weatherPOJO) {

        WeatherReport weatherReport = iDashboardView.fetchWeatherReportWithCityId(cityId);

        boolean updateFlag = true;
        if (weatherReport == null) {
            weatherReport = new WeatherReport();
            weatherReport.setCityId(cityId);
            updateFlag = false;
        }

        // Convert Pojo to String
        Gson gsonObj = new Gson();
        String json = gsonObj.toJson(weatherPOJO);

        weatherReport.setData(json);
        if (updateFlag) {
            iDashboardView.getWeatherRespority().updateWeatherReport(weatherReport);
        } else {
            iDashboardView.getWeatherRespority().insertWeatherReport(weatherReport);
        }

        iDashboardView.showWeather(weatherPOJO);
    }

    @Override public void onError(String message) {
        iDashboardView.showToast(message);
    }

    @Override public void loadOfflineData() {
        loadWeatherReport(cityId);
    }
}
