package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    String base_URL ="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<FetchNews> getNews(
            @Query("country") String county,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<FetchNews> getCategoryNews(
            @Query("country") String county,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
            );
}
