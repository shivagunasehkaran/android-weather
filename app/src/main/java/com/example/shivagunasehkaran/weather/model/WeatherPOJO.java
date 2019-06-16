package com.example.shivagunasehkaran.weather.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherPOJO {

    @SerializedName("weather") private ArrayList<Weather> mWeather;

    @SerializedName("main") private Main mMain;

    @SerializedName("name") private String mName;

    @SerializedName("cod") private int mCode;

    @SerializedName("message") private String mMessage;

    public ArrayList<Weather> getWeather() {
        return mWeather;
    }

    public Main getMain() {
        return mMain;
    }

    public String getName() {
        return mName;
    }

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }
}
