package com.example.shivagunasehkaran.weather.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp") private Double mTemp;

    public Double getTemp() {
        return mTemp;
    }

}
