package com.tavantassignment.api;


import com.tavantassignment.model.ProductResposne;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("products")
    Call<List<ProductResposne>> fetchProductList(@Query("limit") String limit);
}
