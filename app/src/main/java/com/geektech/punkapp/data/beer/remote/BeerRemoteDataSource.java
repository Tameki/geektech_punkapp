package com.geektech.punkapp.data.beer.remote;

import android.support.annotation.Nullable;
import android.util.Log;

import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerRemoteDataSource implements BeerDataSource {

    private BeerNetworkClient mClient = getRetrofit(BeerRemoteConfig.BASE_URL)
            .create(BeerNetworkClient.class);

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(){
        if (INSTANCE == null)
            INSTANCE = new BeerRemoteDataSource();

        return INSTANCE;
    }

    //endregion

    //region Private

    private Retrofit getRetrofit(String baseUrl){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //endregion

    //region Contract

    @Override
    public void getBeerList(BeerListCallback callback) {
        Call<ArrayList<Beer>> call = mClient.getBeerList(1, 50);

        call.enqueue(new Callback<ArrayList<Beer>>() {
            @Override
            public void onResponse(Call<ArrayList<Beer>> call, Response<ArrayList<Beer>> response) {
                Log.d("ololo", "Response code " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Beer>> call, Throwable t) {
                Log.d("ololo", "Failure " + t.getMessage());
                callback.onError(new Exception());
            }
        });
    }

    @Nullable
    @Override
    public Beer getBeer(int id) {
        return null;
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
    }

    //endregion
}
