package com.geektech.punkapp.data;

import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.BeerRepository;
import com.geektech.punkapp.data.beer.local.BeerLocalDataSource;
import com.geektech.punkapp.data.beer.remote.BeerRemoteDataSource;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class DataSourceProvider {
    public static BeerDataSource getBeerSource(){
        return BeerRepository.getInstance(
                BeerLocalDataSource.getInstance(),
                BeerRemoteDataSource.getInstance());
    }
}
