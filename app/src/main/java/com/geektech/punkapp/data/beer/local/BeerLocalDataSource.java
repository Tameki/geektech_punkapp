package com.geektech.punkapp.data.beer.local;

import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;

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
    public Single<ArrayList<Beer>> getBeerList() {
        return null;
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
        //TODO: Write beers into DB
    }

    @Nullable
    @Override
    public Single<Beer> getBeer(int id) {
        return null;
    }

    @Nullable
    @Override
    public Single<Beer> getRandomBeer() {
        return null;
    }

    //endregion
}
