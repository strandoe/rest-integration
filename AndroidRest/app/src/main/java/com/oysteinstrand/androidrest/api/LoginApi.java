package com.oysteinstrand.androidrest.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface LoginApi {
    @GET("/user")
    public void getUser(Callback<List<UserDto>> callback);
}
