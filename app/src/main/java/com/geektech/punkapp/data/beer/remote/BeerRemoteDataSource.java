package com.geektech.punkapp.data.beer.remote;

import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //endregion

    //region Contract


    @Override
    public Single<ArrayList<Beer>> getBeerList() {
        return mClient.getBeerList(1, 50);
    }

    @Nullable
    @Override
    public Single<Beer> getBeer(int id) {
        return mClient.getBeer(id);
    }

    @Nullable
    @Override
    public Single<Beer> getRandomBeer() {
        return mClient.getRandomBeer();
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
    }

    //endregion
}
