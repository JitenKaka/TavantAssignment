package com.tavantassignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tavantassignment.R;
import com.tavantassignment.roomdb.FavoriteList;
import com.tavantassignment.viewholders.FavourateViewHolder;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<FavourateViewHolder> {
    private List<FavoriteList> favoriteLists;
    Context context;

    public WishListAdapter(List<FavoriteList> favoriteLists, Context context) {
        this.favoriteLists = favoriteLists;
        this.context = context;
    }

    @NonNull
    @Override
    public FavourateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_view_favourate_list, viewGroup, false);
        return new FavourateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull FavourateViewHolder holder, int position) {
        FavoriteList fl = favoriteLists.get(position);
        Picasso.get().load(fl.getImage()).into(holder.img);
        holder.tv.setText(fl.getName());
    }





    @Override
    public int getItemCount() {
        return favoriteLists.size();
    }

}

