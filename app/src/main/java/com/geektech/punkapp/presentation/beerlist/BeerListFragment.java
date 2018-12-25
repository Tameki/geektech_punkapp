package com.geektech.punkapp.presentation.beerlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.RepositoryProvider;
import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;
import com.geektech.punkapp.presentation.beerdetails.BeerDetailsActivity;
import com.geektech.punkapp.presentation.beerlist.recycler.BeerListAdapter;
import com.geektech.punkapp.presentation.beerlist.recycler.BeerListViewHolder;

import java.util.ArrayList;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerListFragment extends Fragment
    implements BeerListViewHolder.BeerVHClickListener {

    private RecyclerView mRecycler;
    private BeerListAdapter mAdapter;

    //region Static

    public static BeerListFragment newInstance(){
        return new BeerListFragment();
    }

    //endregion

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.from(getContext())
                .inflate(R.layout.fragment_beer_list, container, false);

        init(rootView);

        return rootView;
    }

    //endregion

    @Override
    public void onClick(int position) {
        Beer beer = mAdapter.getBeer(position);
        if (beer != null) {
            BeerDetailsActivity.start(getActivity(), beer.getId());
        }
    }

    //region Private

    private void init(View rootView) {
        //TODO: Initialize Recycler and set Adapter
        mAdapter = new BeerListAdapter(
                new ArrayList(),
                this
        );

        mRecycler = rootView.findViewById(R.id.fragment_beer_list_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(
                    getContext(),
                    RecyclerView.VERTICAL,
                    false));
        mRecycler.setAdapter(mAdapter);

        loadBeerList();
    }

    private void loadBeerList() {
        RepositoryProvider.getBeerSource()
                .getBeerList(new BeerDataSource.BeerListCallback() {
                    @Override
                    public void onSuccess(ArrayList<Beer> beers) {
                        updateData(beers);
                    }

                    @Override
                    public void onError(Exception e) {
                        //TODO: Show Toast on error
                        Log.e("ololo", e.getMessage(), e);
                    }
                });
    }

    private void updateData(ArrayList<Beer> beers) {
        //TODO: Send beers data to mAdapter, call #setData()
        mAdapter.setData(beers);
    }

    //endregion
}
