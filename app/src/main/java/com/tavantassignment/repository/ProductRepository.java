package com.tavantassignment.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.tavantassignment.api.ApiModule;
import com.tavantassignment.api.ApiService;
import com.tavantassignment.model.ProductResposne;
import com.tavantassignment.utils.Resource;
import com.tavantassignment.utils.ResourcesProvider;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private static final String TAG = ProductRepository.class.getSimpleName();
    private final ApiService apiService;
    private ApiModule apiModule;
    private ResourcesProvider resourcesProvider;
    public MutableLiveData<Resource<List<ProductResposne>>> _responseProductList = new MutableLiveData<>();

    @Inject
    public ProductRepository(ApiService apiService,ResourcesProvider resourcesProvider) {
        this.apiService = apiService;
        this.resourcesProvider = resourcesProvider;

    }

    /**
     * Api call for display Product Item
     * @param limit

     */
    public void fetchProductList(String limit) {
        _responseProductList.postValue(Resource.loading(null));
        Call<List<ProductResposne>> responseArticleCall= apiService.fetchProductList(limit);
        responseArticleCall.enqueue(new Callback<List<ProductResposne>>() {
            @Override
            public void onResponse(Call<List<ProductResposne>> call, Response<List<ProductResposne>> response) {

                handleFindProductListData(response);
                Log.d("API Success","API Success");
            }
            @Override
            public void onFailure(Call<List<ProductResposne>> call, Throwable t) {
                Log.d("API Failed",t.toString());
            }
        });
    }

    /**
     * handled  Product article response
     */
    private void handleFindProductListData(Response<List<ProductResposne>> response) {
        try{
            if(response.isSuccessful()){
                _responseProductList.postValue(Resource.success(response.body()));
            }
            else
            {

            }
        } catch (Exception message){ }



    }

}
