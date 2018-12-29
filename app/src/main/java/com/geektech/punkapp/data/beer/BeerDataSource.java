package com.geektech.punkapp.data.beer;


import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public interface BeerDataSource {

    Single<ArrayList<Beer>> getBeerList();

    void setBeerList(ArrayList<Beer> beers);

    @Nullable Single<Beer> getBeer(int id);

    @Nullable Single<Beer> getRandomBeer();
}
