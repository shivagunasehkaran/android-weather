package com.example.shivagunasehkaran.weather.utils;

import com.example.shivagunasehkaran.weather.AppConstants;

public class AddressBuilderUtil {

    private AddressBuilderUtil() {
        throw new AssertionError();
    }

    public static String getIconAddress(String iconName) {
        if (iconName != null) {
            return AppConstants.ICON_BASE_URL.concat(iconName).concat(".png");
        }
        return null;
    }

}
