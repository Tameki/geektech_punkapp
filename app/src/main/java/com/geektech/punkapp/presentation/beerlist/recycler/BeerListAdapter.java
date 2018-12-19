package com.geektech.punkapp.presentation.beerlist.recycler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerListAdapter extends RecyclerView.Adapter {

    private ArrayList<Beer> mData;

    //region Constructors

    public BeerListAdapter(ArrayList data){
        this.mData = data;
    }

    //endregion

    //region Override

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BeerListViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_beer_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BeerListViewHolder) {
            ((BeerListViewHolder) viewHolder).onBind(mData.get(i % mData.size()));
        }
    }

    //100 % 3 = 1
    //0 % 3 = 0
    //1 % 3 = 1
    //2 % 3 = 2
    //3 % 3 = 0
    //4 % 3 = 1
    //5 % 3 = 2

    @Override
    public int getItemCount() {
        return mData.size() * 10;
    }

    //endregion

    //region Public

    public void setData(List<Beer> data) {
        //TODO: Implement data set and call #notifyDataSetChanged()
    }

    @Nullable
    public Beer getBeer(int position) {
        return null; //TODO: Implement beer instance return
    }

    //endregion
}
