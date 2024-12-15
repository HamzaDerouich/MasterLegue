package com.example.app2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities
{
    public static Retrofit retrofit = null;

    public static ApiClient getApiClient ()
    {
        if ( retrofit == null )
        {
            retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiClient.class);
    }
}
