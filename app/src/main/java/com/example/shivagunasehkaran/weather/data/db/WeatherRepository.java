package com.example.shivagunasehkaran.weather.data.db;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.shivagunasehkaran.weather.R;

import java.util.List;

public class WeatherRepository {

    private WeatherDb weatherDb;

    public WeatherRepository(Context context) {
        weatherDb = Room
                .databaseBuilder(context, WeatherDb.class, context.getString(R.string.app_name))
                .build();
    }

    @SuppressLint("StaticFieldLeak") public void insertCity(final City city) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                weatherDb.cityDao().insertCity(city);
                return null;
            }
        }.execute();
    }

    public LiveData<List<City>> getTasks() {
        return weatherDb.cityDao().fetchAllCities();
    }

    @SuppressLint("StaticFieldLeak") public void insertWeatherReport(
            final WeatherReport weatherReport) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                weatherDb.weatherReportDao().insertWeatherReport(weatherReport);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak") public void updateWeatherReport(
            final WeatherReport weatherReport) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                weatherDb.weatherReportDao().updateWeatherReport(weatherReport);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak") public WeatherReport getWeatherReport(final int cityid) {
        final WeatherReport[] weatherReport = new WeatherReport[1];
        new AsyncTask<Void, Void, WeatherReport>() {
            @Override
            protected WeatherReport doInBackground(Void... voids) {
                weatherReport[0] = weatherDb.weatherReportDao().getWeatherData(cityid);
                return weatherReport[0];
            }
        }.execute();
        return weatherReport[0];
    }

}
