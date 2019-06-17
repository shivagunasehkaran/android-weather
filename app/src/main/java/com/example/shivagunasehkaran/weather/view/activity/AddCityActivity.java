package com.example.shivagunasehkaran.weather.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.shivagunasehkaran.weather.R;
import com.example.shivagunasehkaran.weather.presenter.AddCityPresenter;
import com.example.shivagunasehkaran.weather.presenter.iPresenter.IAddCityPresenter;
import com.example.shivagunasehkaran.weather.utils.NavigatorUtils;
import com.example.shivagunasehkaran.weather.view.iView.IAddCityView;

import butterknife.BindView;
import butterknife.OnClick;

public class AddCityActivity extends BaseActivity implements IAddCityView {

    private IAddCityPresenter iAddCityPresenter = null;

    @BindView(R.id.text_city)
    EditText cityText;

    @BindView(R.id.btnSubmit)
    LinearLayout btnSubmit;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iAddCityPresenter = new AddCityPresenter(this);
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_add_note;
    }

    @OnClick(R.id.btnSubmit)
    public void onButtonClick(View view) {
        String cityName = cityText.getText().toString();
        iAddCityPresenter.addNewCity(cityName);
    }

    @Override public void navigateToDashBoard() {
        NavigatorUtils.redirectToDashboardScreen(this);
    }

}
