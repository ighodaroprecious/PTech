package com.example.myonlineapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowersApi {

    @GET("/feeds/flowers.json")
    Call<List<Books>> getAllFlowers();

}
