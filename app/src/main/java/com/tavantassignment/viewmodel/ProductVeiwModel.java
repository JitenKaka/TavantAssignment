package com.tavantassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.tavantassignment.model.ProductResposne;
import com.tavantassignment.repository.ProductRepository;
import com.tavantassignment.utils.Resource;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ProductVeiwModel  extends BaseViewModel {

    ProductRepository headlineRepository;
    public MutableLiveData<Resource<List<ProductResposne>>> responseproductList = new MutableLiveData<>();

    @Inject
    public ProductVeiwModel(@NonNull Application application, ProductRepository headlineRepository) {
        super(application);
        this.headlineRepository = headlineRepository;
        this.responseproductList = headlineRepository._responseProductList;
    }

    public void getProductList(String limit){
        headlineRepository.fetchProductList("10");
    }
}