package com.geektech.punkapp.data.beer.local;

import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerLocalDataSource implements BeerDataSource {

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(){
        if (INSTANCE == null)
            INSTANCE = new BeerLocalDataSource();

        return INSTANCE;
    }

    //endregion

    //region Contract

    @Override
    public void getBeerList(BeerListCallback callback) {
        //TODO: Implement fetch from DB
        callback.onSuccess(new ArrayList<>());
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
        //TODO: Write beers into DB
    }

    @Nullable
    @Override
    public Beer getBeer(int id) {
        //TODO: Fetch target Beer info from db
        return null;
    }

    //endregion
}
