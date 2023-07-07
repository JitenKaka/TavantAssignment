package com.tavantassignment.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.tavantassignment.R;
import com.tavantassignment.adapter.ProductAdapter;
import com.tavantassignment.clicklisteners.SelectListener;
import com.tavantassignment.databinding.ActivityMainBinding;
import com.tavantassignment.model.ProductListModel;
import com.tavantassignment.model.ProductResposne;
import com.tavantassignment.roomdb.FavoriteDatabase;
import com.tavantassignment.utils.ProgressDialogUtils;
import com.tavantassignment.utils.Resource;
import com.tavantassignment.viewmodel.ProductVeiwModel;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements SelectListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ProductVeiwModel productVeiwModel;
    private ArrayList<ProductResposne> productListModel = new ArrayList<>();
    private ProductAdapter productAdapter;

    public static FavoriteDatabase favoriteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        favoriteDatabase= Room.databaseBuilder(getApplicationContext(),FavoriteDatabase.class,"myfavdb").allowMainThreadQueries().build();
        productVeiwModel = new ViewModelProvider(this).get(ProductVeiwModel.class);
        setSupportActionBar(binding.toolbar);
        getProductListData("10");
        initObserver();
        setupAdapter();

        binding.favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WishListActivity.class));
            }
        });

    }
    private void getProductListData(String limit) {

        productVeiwModel.getProductList(limit);
    }
    /**
     * setup all the observer of  for api call and validations
     */
    private void initObserver(){
        productVeiwModel.responseproductList.observe(this, new Observer<Resource<List<ProductResposne>>>() {
            @Override
            public void onChanged(Resource<List<ProductResposne>> response) {
                Log.d("Resposne",response.toString());
                if(response.status != null){
                    switch (response.status){

                        case LOADING: {
                            Log.d("1","1");
                            ProgressDialogUtils.getInstance().show(MainActivity.this);
                            break;
                        }
                        case ERROR:{
                            Log.d("2","1");
                            ProgressDialogUtils.getInstance().dismiss();

                            break;
                        }
                        case SUCCESS:{
                            Log.d("3","1");
                            ProgressDialogUtils.getInstance().dismiss();
                            List<ProductResposne> productItem = response.data;
                            productListModel.addAll(productItem);
                            productAdapter.notifyDataSetChanged();


                            break;
                        }
                    }
                }
            }
        });
    }
    /**

     * set Adapter for News Article
     */
    private void setupAdapter() {

        productAdapter =  new ProductAdapter(productListModel, getApplicationContext(), MainActivity.this,this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        binding.productRecyclerView.setLayoutManager(layoutManager);
        binding.productRecyclerView.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
          /* binding.productRecyclerView.setHasFixedSize(true);
        binding.productRecyclerView.setLayoutManager(new LinearLayoutManager(this));*/
    }

    /**

     * Item click Listener for deatil news article
     */
    @Override
    public void OnProductClicked(ProductResposne productListModel) {

        Intent i=new Intent(MainActivity.this, ProductDetailsActivity.class);
        Bundle bundle =new Bundle();
        bundle.putSerializable("data",(Serializable)productListModel);
        i.putExtra("BUNDLE",bundle);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}