package com.example.app2;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient
{
    public static String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<NoticiaResponse> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<NoticiaResponse> getCategory(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

}
