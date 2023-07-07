package com.tavantassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tavantassignment.R;
import com.tavantassignment.activity.MainActivity;
import com.tavantassignment.clicklisteners.SelectListener;
import com.tavantassignment.model.ProductListModel;
import com.tavantassignment.model.ProductResposne;
import com.tavantassignment.roomdb.FavoriteList;
import com.tavantassignment.viewholders.ProductViewHolder;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>{

    private Context ctx;
    private List<ProductResposne> productList;
    public MainActivity activity;
    private SelectListener listener;


    public ProductAdapter(List<ProductResposne> productList,Context ctx,MainActivity activity,SelectListener listener ) {
        this.ctx = ctx;
        this.productList = productList;
        this.activity = activity;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(activity).inflate(R.layout.row_view_product_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.product_title.setText(productList.get(position).getTitle());
        holder.product_price.setText( "Price : "+productList.get(position).getPrice());
       // holder.product_rating_count.setText(productList.get(position).getRatingModel().getRate() +" | "+productList.get(position).getRatingModel().getCount());

        if(productList.get(position).getImage()!=null)
        {
            Picasso.get().load(productList.get(position).getImage()).into(holder.product_image);
        }

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnProductClicked(productList.get(position));
            }
        });

         holder.img_wishList.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 FavoriteList favoriteList=new FavoriteList();

                 int id= Integer.parseInt(productList.get(position).getId());
                 String image=productList.get(position).getImage();
                 String name=productList.get(position).getTitle();

                 favoriteList.setId(id);
                 favoriteList.setImage(image);
                 favoriteList.setName(name);

                 if (MainActivity.favoriteDatabase.favoriteDao().isFavorite(id)!=1){
                     holder.img_wishList.setImageResource(R.drawable.favourate);
                     MainActivity.favoriteDatabase.favoriteDao().addData(favoriteList);

                 }else {
                     holder.img_wishList.setImageResource(R.drawable.wishlist);
                     MainActivity.favoriteDatabase.favoriteDao().delete(favoriteList);

                 }

             }
         });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
