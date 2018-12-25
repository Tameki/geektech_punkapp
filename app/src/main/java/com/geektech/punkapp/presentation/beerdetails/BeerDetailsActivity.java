package com.geektech.punkapp.presentation.beerdetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerDetailsActivity extends AppCompatActivity {

    //region Static

    private static String EXTRA_BEER_ID = "beer_id";

    public static void start(Activity activity, int id){
        activity.startActivity(intent(activity, id));
    }

    public static Intent intent(Context context, int id){
        Intent intent = new Intent(context, BeerDetailsActivity.class);
        intent.putExtra(EXTRA_BEER_ID, id);
        return intent;
    }

    //endregion

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Create #BeerDetailsFragment instance and set it via #SupportFragmentManager
        if (savedInstanceState == null) {
            getIntent().getIntExtra(EXTRA_BEER_ID, -1);
        }
    }
}
