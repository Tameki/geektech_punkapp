package com.geektech.punkapp.data.beer.remote;

import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerRemoteDataSource implements BeerDataSource {

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(){
        if (INSTANCE == null)
            INSTANCE = new BeerRemoteDataSource();

        return INSTANCE;
    }

    //endregion

    //region Contract

    @Override
    public void getBeerList(BeerListCallback callback) {
        //TODO: Perform network call via #Retrofit client
        callback.onSuccess(new ArrayList<>());
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
