package com.geektech.punkapp.presentation.beerlist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.RepositoryProvider;
import com.geektech.punkapp.data.beer.model.Beer;
import com.geektech.punkapp.presentation.beerdetails.BeerDetailsActivity;
import com.geektech.punkapp.presentation.beerlist.recycler.BeerListAdapter;
import com.geektech.punkapp.presentation.beerlist.recycler.BeerListViewHolder;
import com.geektech.util.ToastUtil;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
        mAdapter = new BeerListAdapter(new ArrayList(), this);

        mRecycler = rootView.findViewById(R.id.fragment_beer_list_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(
                    getContext(),
                    RecyclerView.VERTICAL,
                    false));
        mRecycler.setAdapter(mAdapter);

        loadBeerList();
    }

    @SuppressLint("CheckResult")
    private void loadBeerList() {
        RepositoryProvider.getBeerSource()
                .getBeerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::updateData,
                        error -> showToast("Error " + error.getMessage())
                );
    }

    private void updateData(ArrayList<Beer> beers) {
        mAdapter.setData(beers);
    }

    private void showToast(String message) {
        if (getContext() != null) {
            ToastUtil.showShortToast(getContext(), message);
        }
    }

    //endregion
}
