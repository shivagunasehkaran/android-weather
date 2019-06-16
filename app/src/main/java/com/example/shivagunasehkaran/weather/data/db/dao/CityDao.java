package com.example.shivagunasehkaran.weather.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.shivagunasehkaran.weather.data.db.City;

import java.util.List;

@Dao
public interface CityDao {

    @Insert
    Long insertCity(City city);

    @Query("SELECT * FROM City")
    LiveData<List<City>> fetchAllCities();

    @Query("SELECT * FROM City WHERE cityName=:cityName")
    City getCity(String cityName);

}
