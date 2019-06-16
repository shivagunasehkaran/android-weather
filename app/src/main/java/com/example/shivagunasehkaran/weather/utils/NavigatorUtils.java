package com.example.shivagunasehkaran.weather.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.shivagunasehkaran.weather.view.activity.AddCityActivity;
import com.example.shivagunasehkaran.weather.view.activity.DashboardActivity;

public class NavigatorUtils {

    public static void redirectToAddCityScreen(Activity activity) {
        Intent intent = new Intent(activity, AddCityActivity.class);
        activity.startActivityForResult(intent, 200);
    }

    public static void redirectToDashboardScreen(Activity activity) {
        Intent intent = new Intent(activity, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        activity.startActivity(intent);
        activity.finish();
    }
}

