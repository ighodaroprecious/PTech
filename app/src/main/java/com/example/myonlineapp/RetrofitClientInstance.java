package com.example.myonlineapp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    public static  final String PHOTO_BASE_URL =
            "http://services.hanselandpetal.com";

    public static Retrofit  getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new  retrofit2.Retrofit.Builder()
                    .baseUrl(PHOTO_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
