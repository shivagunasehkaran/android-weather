package com.example.shivagunasehkaran.weather.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.shivagunasehkaran.weather.data.db.dao.CityDao;
import com.example.shivagunasehkaran.weather.data.db.dao.WeatherReportDao;

@Database(entities = {City.class, WeatherReport.class}, version = 1, exportSchema = false)
public abstract class WeatherDb extends RoomDatabase {

    public abstract CityDao cityDao();

    public abstract WeatherReportDao weatherReportDao();

}
