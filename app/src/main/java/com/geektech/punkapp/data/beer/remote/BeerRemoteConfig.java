package com.geektech.punkapp.data.beer.remote;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
//TODO: Add remaining API urls
class BeerRemoteConfig {
    static final String BASE_URL = "https://api.punkapi.com";
    static final String API_VERSION = "/v2";
    static final String BEERS_URL = API_VERSION + "/beers";
    static final String RANDOM_URL = BEERS_URL + "/random";
}
