package com.example.shivagunasehkaran.weather.data.remote;

import android.util.Log;

import com.example.shivagunasehkaran.weather.AppConstants;
import com.example.shivagunasehkaran.weather.data.callback.IWeatherResponseListener;
import com.example.shivagunasehkaran.weather.model.WeatherPOJO;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class WeatherApiModel implements Callback<WeatherPOJO> {

    private IWeatherResponseListener iWeatherResponseListener = null;

    public WeatherApiModel(IWeatherResponseListener iWeatherResponseListener) {
        this.iWeatherResponseListener = iWeatherResponseListener;
    }

    public void apiCall(String city, boolean isNetworkAvailable) {
        if (isNetworkAvailable) {
            ApiClient apiClient = new ApiClient();
            IWeatherApi iWeatherApi = apiClient.getInstance();
            Call<WeatherPOJO> api = iWeatherApi.loadData(city, AppConstants.API_KEY);
            api.enqueue(this);
        } else {
            iWeatherResponseListener.loadOfflineData();
        }
    }

    @Override public void onResponse(Response<WeatherPOJO> response, Retrofit retrofit) {
        if (response != null) {
            if (response.isSuccess()) {
                WeatherPOJO weatherPOJO = response.body();
                Log.d("response::", "" + weatherPOJO.getName());
                iWeatherResponseListener.onSuccess(weatherPOJO);
            }
        }
    }

    @Override public void onFailure(Throwable error) {
        Log.d("response:", "" + error.getMessage());
        iWeatherResponseListener.onError(error.getMessage());
    }
}
