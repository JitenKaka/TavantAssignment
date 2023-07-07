package com.tavantassignment.viewholders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tavantassignment.R;

public class FavourateViewHolder extends RecyclerView.ViewHolder{
    public ImageView img;
    public  TextView tv;

    public FavourateViewHolder(@NonNull View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.product_image);
        tv = (TextView) itemView.findViewById(R.id.product_title);
    }
}