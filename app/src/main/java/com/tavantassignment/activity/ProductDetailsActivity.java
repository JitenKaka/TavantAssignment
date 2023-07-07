package com.tavantassignment.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.tavantassignment.databinding.ActivityProductDetailsBinding;
import com.tavantassignment.model.ProductListModel;
import com.tavantassignment.model.ProductResposne;
import com.tavantassignment.viewmodel.ProductVeiwModel;

public class ProductDetailsActivity extends AppCompatActivity {


    private ActivityProductDetailsBinding binding;
    private ProductResposne productVeiwModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        productVeiwModel = (ProductResposne) args.getSerializable("data");

        binding.textDetailTitle.setText(productVeiwModel.getTitle());


        binding.textDetailPrice.setText( "Price : "+productVeiwModel.getPrice());
        binding.textDetailDescription.setText(productVeiwModel.getDescription());
     //   binding.textDetailRating.setText(productVeiwModel.getRatingModel().getRate() +" | "+(productVeiwModel.getRatingModel().getCount()));


        Picasso.get().load(productVeiwModel.getImage()).into(binding.imgDetailImage);
    }

}