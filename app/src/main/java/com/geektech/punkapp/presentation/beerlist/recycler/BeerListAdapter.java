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
    private BeerListViewHolder.BeerVHClickListener mListener;

    //region Constructors

    public BeerListAdapter(
            ArrayList data,
            BeerListViewHolder.BeerVHClickListener listener
    ){
        this.mData = data;
        this.mListener = listener;
    }

    //endregion

    //region Override

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BeerListViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_beer_item, viewGroup, false),
                mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BeerListViewHolder) {
            ((BeerListViewHolder) viewHolder).onBind(mData.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //endregion

    //region Public

    public void setData(List<Beer> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
        //TODO: Implement data set and call #notifyDataSetChanged()
    }

    @Nullable
    public Beer getBeer(int position) {
        return null; //TODO: Implement beer instance return
    }

    //endregion
}
