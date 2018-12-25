package com.geektech.punkapp.presentation.beerlist.recycler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.beer.model.Beer;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerListViewHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private BeerVHClickListener mListener;

    BeerListViewHolder(@NonNull View itemView, @Nullable BeerVHClickListener listener) {
        super(itemView);
        this.mListener = listener;
        init(itemView);
    }

    private void init(View itemView){
        mName = itemView.findViewById(R.id.adapter_beer_item_name);
        itemView.setOnClickListener(v -> mListener.onClick(getAdapterPosition()));
    }

    void onBind(Beer beer){
        mName.setText(beer.getName());
        //TODO: Display beer data in views
    }

    public interface BeerVHClickListener {
        void onClick(int position);
    }
}
