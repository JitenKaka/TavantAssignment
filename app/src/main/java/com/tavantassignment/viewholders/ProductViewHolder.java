package com.tavantassignment.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tavantassignment.R;

public class ProductViewHolder extends RecyclerView.ViewHolder{
    public CardView card_view;
    public TextView product_title,product_price,product_rating_count;
    public ImageView product_image,img_wishList;
    View view;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        product_title = itemView.findViewById(R.id.product_title);
        product_price = itemView.findViewById(R.id.product_price);
        product_rating_count = itemView.findViewById(R.id.product_rating_count);
        product_image = itemView.findViewById(R.id.product_image);
        img_wishList = itemView.findViewById(R.id.img_wishList);
        card_view = itemView.findViewById(R.id.card_view);
        view = itemView;
    }
}