package com.example.shivagunasehkaran.weather.utils;

import android.text.format.DateFormat;

import com.example.shivagunasehkaran.weather.model.WeatherPOJO;

import java.util.Calendar;
import java.util.Locale;

public final class StringFormatterUtil {

    private StringFormatterUtil() {
        throw new AssertionError();
    }

    public static String getPlace(WeatherPOJO weatherResponse) {
        StringBuilder stringBuilder = new StringBuilder(weatherResponse.getName());
        if (weatherResponse.getSys() != null) {
            stringBuilder.append(", ").append(weatherResponse.getSys().getCountry());
        }
        return stringBuilder.toString();
    }

    public static String getTemperature(WeatherPOJO weatherResponse) {
        if (weatherResponse.getMain() != null &&
                weatherResponse.getMain().getTemp() != null) {
            return getTemperatureString(weatherResponse.getMain().getTemp());
        }
        return null;
    }

    private static String getTemperatureString(double temperature) {
        return String.valueOf(Math.round(temperature)).concat(" °C");
    }

    public static String getWind(WeatherPOJO weatherResponse) {
        if (weatherResponse.getWind() != null) {
            return String.valueOf(weatherResponse.getWind().getWindSpeed()).concat(" m/s");
        }
        return null;
    }

    public static String getDate(WeatherPOJO weatherResponse) {
        if (weatherResponse.getDate() != null) {
            return getConvertedDate(weatherResponse.getDate());
        }
        return null;
    }

    private static String getConvertedDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        return DateFormat.format("dd-MM-yyyy HH:mm:ss", cal).toString();
    }

    public static String getDescription(WeatherPOJO weatherResponse) {
        if (weatherResponse.getWeather() != null &&
                weatherResponse.getWeather().get(0) != null) {
            return weatherResponse.getWeather().get(0).getDescription();
        }
        return null;
    }
}
