package com.shubham.retrofitrecyclerview.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    public static final String Url = "https://reqres.in/api/";

    private  static  ApiController apiController;

    private static Retrofit retrofit;

    public ApiController() {
        retrofit = new Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiController getInstance(){
        if(apiController == null){
            apiController =  new ApiController();
        }
        return apiController;
    }
    public RetrofitApi getApi(){
        return  retrofit.create(RetrofitApi.class);
    }
}
