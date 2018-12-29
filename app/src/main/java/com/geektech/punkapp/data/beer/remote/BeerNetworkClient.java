package com.geektech.punkapp.data.beer.remote;

import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
//TODO: Add remaining API calls
public interface BeerNetworkClient {

    @GET(BeerRemoteConfig.BEERS_URL)
    Single<ArrayList<Beer>> getBeerList(
            @Query("page") int page,
            @Query("per_page") int perPage);

    @GET(BeerRemoteConfig.BEERS_URL + "/{id}")
    Single<Beer> getBeer(@Path("id") int id);

    @GET(BeerRemoteConfig.RANDOM_URL)
    Single<Beer> getRandomBeer();
}
