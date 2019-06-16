package com.example.shivagunasehkaran.weather.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.shivagunasehkaran.weather.data.db.WeatherReport;

@Dao
public interface WeatherReportDao {

    @Query("SELECT * FROM WeatherReport WHERE cityId =:cityId")
    WeatherReport getWeatherData(int cityId);

    @Insert
    Long insertWeatherReport(WeatherReport weatherReport);

    @Update
    void updateWeatherReport(WeatherReport weatherReport);

}
