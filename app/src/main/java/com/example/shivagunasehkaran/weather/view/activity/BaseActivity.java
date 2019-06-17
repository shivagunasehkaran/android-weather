package com.example.shivagunasehkaran.weather.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.shivagunasehkaran.weather.utils.ConnectionUtils;
import com.example.shivagunasehkaran.weather.view.iView.IBaseView;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        // bind the view using butterknife
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    @Override public Context getContext() {
        return this;
    }

    @Override public boolean isNetworkAvail() {
        return ConnectionUtils.isNetworkConnected(this);
    }

    @Override public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

