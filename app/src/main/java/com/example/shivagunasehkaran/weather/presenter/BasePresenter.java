package com.example.shivagunasehkaran.weather.presenter;

import com.example.shivagunasehkaran.weather.presenter.iPresenter.IBasePresenter;
import com.example.shivagunasehkaran.weather.view.iView.IBaseView;

public class BasePresenter implements IBasePresenter {

    IBaseView iView;

    BasePresenter(IBaseView iView) {
        this.iView = iView;
    }

}
