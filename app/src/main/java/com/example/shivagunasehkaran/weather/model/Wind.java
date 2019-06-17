package com.example.shivagunasehkaran.weather.model;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed") private String mSpeed;

    public String getWindSpeed() {
        return mSpeed;
    }
}
