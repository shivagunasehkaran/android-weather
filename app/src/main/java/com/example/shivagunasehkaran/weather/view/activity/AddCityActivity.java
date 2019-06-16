package com.example.shivagunasehkaran.weather.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shivagunasehkaran.weather.R;
import com.example.shivagunasehkaran.weather.presenter.AddCityPresenter;
import com.example.shivagunasehkaran.weather.presenter.iPresenter.IAddCityPresenter;
import com.example.shivagunasehkaran.weather.utils.NavigatorUtils;
import com.example.shivagunasehkaran.weather.view.iView.IAddCityView;

import butterknife.BindView;
import butterknife.OnClick;

public class AddCityActivity extends BaseActivity implements IAddCityView {

    private IAddCityPresenter iAddCityPresenter = null;

    @BindView(R.id.edit_title)
    EditText edit_title;

    @BindView(R.id.text_time)
    TextView text_time;

    @BindView(R.id.btnAdd)
    Button btnAdd;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iAddCityPresenter = new AddCityPresenter(this);
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_add_note;
    }

    @OnClick(R.id.btnAdd)
    public void onButtonClick(View view) {
        String cityName = edit_title.getText().toString();
        iAddCityPresenter.addNewCity(cityName);
    }


    @Override public void navigateToDashBoard() {
        NavigatorUtils.redirectToDashboardScreen(this);
    }

}
