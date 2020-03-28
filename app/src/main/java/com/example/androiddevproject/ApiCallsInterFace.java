package com.example.androiddevproject;

import com.example.androiddevproject.ApiResponse.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiCallsInterFace {


    @Headers({"Content-Type: application/json"})
    @POST("/user/login_android")
    Call<LoginResponse> login(@Body RequestBody jsonLogin);


}
