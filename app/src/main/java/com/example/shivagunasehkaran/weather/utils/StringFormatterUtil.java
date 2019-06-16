package com.example.shivagunasehkaran.weather.utils;

import com.example.shivagunasehkaran.weather.model.WeatherPOJO;

public final class StringFormatterUtil {

    private StringFormatterUtil() {
        throw new AssertionError();
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

    public static String getDescription(WeatherPOJO weatherResponse) {
        if (weatherResponse.getWeather() != null &&
                weatherResponse.getWeather().get(0) != null) {
            return weatherResponse.getWeather().get(0).getDescription();
        }
        return null;
    }
}
