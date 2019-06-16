package com.example.shivagunasehkaran.weather.view.iView;

import android.content.Context;

public interface IBaseView {

    Context getContext();

    boolean isNetworkAvail();

    void showToast(String message);

}
