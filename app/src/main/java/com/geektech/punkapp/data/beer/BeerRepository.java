package com.geektech.punkapp.data.beer;

import android.support.annotation.Nullable;
import android.util.Log;

import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerRepository implements BeerDataSource {

    @Nullable
    private BeerDataSource mLocal;
    @Nullable
    private BeerDataSource mRemote;

    private HashMap<Integer, Beer> mCache = new HashMap<>();

    //region Constructor

    private BeerRepository(
            @Nullable BeerDataSource mLocal,
            @Nullable BeerDataSource mRemote) {
        this.mLocal = mLocal;
        this.mRemote = mRemote;
    }

    //endregion

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(
            BeerDataSource local,
            BeerDataSource remote) {
        if (INSTANCE == null) {
            INSTANCE = new BeerRepository(local, remote);
        }
        return INSTANCE;
    }

    //endregion

    //region Contract


    @Override
    public Single<ArrayList<Beer>> getBeerList() {
        if (mCache.isEmpty()) {
            Log.d("ololo", "Fetch from remote");
            if (mRemote != null) {
                return mRemote.getBeerList()
                        .map( beers -> {
                            for (Beer beer : beers) {
                                mCache.put(beer.getId(), beer);
                            }
                            return beers;
                        });
            }
        } else {
            Log.d("ololo", "Fetch from cache");
            ArrayList<Beer> beers = new ArrayList<>();
            beers.addAll(mCache.values());

            return Single.just(beers);
        }
        return null;
    }

    @Nullable
    @Override
    public Single<Beer> getBeer(int id) {
        return Single.just(mCache.get(id));
    }

    @Nullable
    @Override
    public Single<Beer> getRandomBeer() {
        return mRemote.getRandomBeer();
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
        //TODO: Send data to local data source
    }

    //endregion
}
