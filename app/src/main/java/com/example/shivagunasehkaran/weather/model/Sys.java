package com.example.shivagunasehkaran.weather.model;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("country") private String mCountry;

    public String getCountry() {
        return mCountry;
    }
}
