package com.example.shivagunasehkaran.weather.presenter;

import android.text.TextUtils;

import com.example.shivagunasehkaran.weather.R;
import com.example.shivagunasehkaran.weather.data.db.City;
import com.example.shivagunasehkaran.weather.data.db.WeatherRepository;
import com.example.shivagunasehkaran.weather.presenter.iPresenter.IAddCityPresenter;
import com.example.shivagunasehkaran.weather.view.iView.IAddCityView;
import com.example.shivagunasehkaran.weather.view.iView.IBaseView;

public class AddCityPresenter extends BasePresenter implements IAddCityPresenter {

    private IAddCityView iAddCityView;

    public AddCityPresenter(IBaseView iView) {
        super(iView);

        iAddCityView = (IAddCityView) iView;
    }

    @Override public void addNewCity(String cityStr) {
        if (!TextUtils.isEmpty(cityStr)) {

            WeatherRepository weatherRepository = new WeatherRepository(iView.getContext());
            City city = new City();
            city.setCityName(cityStr);
            weatherRepository.insertCity(city);

            iAddCityView.showToast(iView.getContext().getString(R.string.city_inserted));
            iAddCityView.navigateToDashBoard();

        } else {
            iAddCityView.showToast(iView.getContext().getString(R.string.enter_city));
        }
    }

}
