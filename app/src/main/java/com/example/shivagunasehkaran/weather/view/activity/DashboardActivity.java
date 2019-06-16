package com.example.shivagunasehkaran.weather.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.shivagunasehkaran.weather.R;

import butterknife.BindView;
import butterknife.OnClick;

public class DashboardActivity extends BaseActivity {

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @BindView(R.id.btnAdd)
    Button btnAdd;

    @BindView(R.id.temp_text)
    TextView temp_text;

    @BindView(R.id.date_text)
    TextView date_text;

    @BindView(R.id.text_time)
    TextView text_time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @OnClick(R.id.btnSubmit)
    public void onButtonClick(View view) {

    }

}

