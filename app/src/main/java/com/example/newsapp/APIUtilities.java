package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIUtilities {
    private static Retrofit retrofit=null;

    static APIInterface getApiInterface(){

        if(retrofit==null) {

            retrofit = new Retrofit.Builder().baseUrl(APIInterface.base_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIInterface.class);
    }

}
