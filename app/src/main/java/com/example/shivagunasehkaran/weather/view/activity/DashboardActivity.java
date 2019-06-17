package com.example.shivagunasehkaran.weather.view.activity;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shivagunasehkaran.weather.R;
import com.example.shivagunasehkaran.weather.data.db.City;
import com.example.shivagunasehkaran.weather.data.db.WeatherReport;
import com.example.shivagunasehkaran.weather.data.db.WeatherRepository;
import com.example.shivagunasehkaran.weather.model.WeatherPOJO;
import com.example.shivagunasehkaran.weather.presenter.DashboardPresenter;
import com.example.shivagunasehkaran.weather.presenter.iPresenter.IDashboardPresenter;
import com.example.shivagunasehkaran.weather.utils.AddressBuilderUtil;
import com.example.shivagunasehkaran.weather.utils.NavigatorUtils;
import com.example.shivagunasehkaran.weather.utils.StringFormatterUtil;
import com.example.shivagunasehkaran.weather.view.adapter.CustomArrayAdapter;
import com.example.shivagunasehkaran.weather.view.iView.IDashboardView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DashboardActivity extends BaseActivity implements IDashboardView {

    private IDashboardPresenter iDashboardPresenter = null;
    private WeatherRepository weatherRepository = null;
    List<City> cities = null;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.weather_icon)
    ImageView weatherIcon;

    @BindView(R.id.text_city)
    TextView cityName;

    @BindView(R.id.text_temperature)
    TextView temperature;

    @BindView(R.id.text_wind_speed)
    TextView windSpeed;

    @BindView(R.id.text_updated_date)
    TextView date;

    @BindView(R.id.text_description)
    TextView description;

    @BindView(R.id.btn_add)
    TextView btnAdd;

    @BindView(R.id.btnSubmit)
    LinearLayout btnSubmit;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        weatherRepository = new WeatherRepository(this);
        iDashboardPresenter = new DashboardPresenter(this);

    }

    @Override protected int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @OnClick(R.id.btnSubmit)
    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(),
                "Selected state : " + String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT)
                .show();

        iDashboardPresenter.dashboardApiCall(String.valueOf(spinner.getSelectedItem()),
                cities.get(spinner.getSelectedItemPosition()));
    }

    @Override public void showWeather(WeatherPOJO weatherResponse) {
        Picasso.with(this)
                .load(AddressBuilderUtil
                        .getIconAddress(weatherResponse.getWeather().get(0).getIcon()))
                .fit()
                .centerCrop()
                .into(weatherIcon);
        cityName.setText(StringFormatterUtil.getPlace(weatherResponse));
        temperature.setText(StringFormatterUtil.getTemperature(weatherResponse));
        windSpeed.setText(StringFormatterUtil.getWind(weatherResponse));
        date.setText(StringFormatterUtil.getDate(weatherResponse));
        description.setText(StringFormatterUtil.getDescription(weatherResponse));
    }

    @Override public void setSpinnerAdapter(List<City> cities) {
        if (cities != null && cities.size() > 0) {
            CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.spinner_adapter,
                    cities);
            this.cities = cities;
            spinner.setAdapter(adapter);
        } else {
            //Toast.makeText(this, "enters else", Toast.LENGTH_LONG).show();
        }
    }

    @Override public void fetchCities() {
        weatherRepository.getTasks().observe(this, new Observer<List<City>>() {
            @Override
            public void onChanged(@Nullable List<City> cities) {
                if (cities != null && cities.size() > 0) {
                    iDashboardPresenter.doSpinnerAdapter(cities);
                } else {
                    City city = new City();
                    city.setCityName("Sydney");
                    iDashboardPresenter.insertCity(city, weatherRepository);

                    city = new City();
                    city.setCityName("Melbourne");
                    iDashboardPresenter.insertCity(city, weatherRepository);

                    city = new City();
                    city.setCityName("Wollongong");
                    iDashboardPresenter.insertCity(city, weatherRepository);

                    iDashboardPresenter.callFetchCities();
                }
            }
        });
    }

    @OnClick(R.id.btn_add)
    public void redirect(View view) {
        NavigatorUtils.redirectToAddCityScreen(this);
    }

    @Override public WeatherRepository getWeatherRespority() {
        return weatherRepository;
    }

    @Override public WeatherReport fetchWeatherReportWithCityId(int cityId) {
        return weatherRepository.getWeatherReport(cityId);
    }
}

