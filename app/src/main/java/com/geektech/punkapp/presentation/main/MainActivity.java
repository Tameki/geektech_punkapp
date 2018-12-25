package com.geektech.punkapp.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geektech.punkapp.R;
import com.geektech.punkapp.presentation.beerlist.BeerListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Create #BeerListFragment instance and set it via #SupportFragmentManager
        if (savedInstanceState == null) {
            BeerListFragment fragment = BeerListFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, fragment)
                    .commit();
        }
    }
}
