package com.example.shivagunasehkaran.weather.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

}
