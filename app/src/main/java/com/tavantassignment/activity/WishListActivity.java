package com.tavantassignment.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.tavantassignment.adapter.ProductAdapter;
import com.tavantassignment.adapter.WishListAdapter;
import com.tavantassignment.databinding.ActivityWishListBinding;
import com.tavantassignment.roomdb.FavoriteList;

import java.util.List;

public class WishListActivity extends AppCompatActivity {


    private ActivityWishListBinding binding;
    private WishListAdapter wishListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWishListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getFavData();


    }

    private void getFavData() {
        List<FavoriteList> favoriteLists=MainActivity.favoriteDatabase.favoriteDao().getFavoriteData();

        wishListAdapter=new WishListAdapter(favoriteLists,getApplicationContext());
        binding.wishListRecyclerView.setAdapter(wishListAdapter);
    }

}