package com.geektech.punkapp.presentation.beerdetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.punkapp.R;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
//TODO: All setup is in your hands
public class BeerDetailsFragment extends Fragment {

    //region Static

    public static BeerDetailsFragment newInstance() {
        return new BeerDetailsFragment();
    }

    //endregion

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.from(getContext())
                .inflate(R.layout.fragment_beer_details, container, false);

        init(rootView);

        return rootView;
    }

    //endregion

    //region Private

    private void init(View rootView) {

    }

    //endregion
}
