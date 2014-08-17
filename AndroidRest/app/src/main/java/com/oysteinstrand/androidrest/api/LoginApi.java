package com.oysteinstrand.androidrest.api;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface LoginApi {
    @GET("/user")
    public void getUser(Callback<List<UserDto>> callback);

    @POST("/user")
    public void saveUser(@Body UserDto userDto, Callback<UserDto> callback);

    @POST("/oauth/token")
    public void getToken(@Body TokenRequestDto tokenRequestDto, Callback<TokenResponseDto> tokenResponseDtoCallback);

    @POST("/client")
    public void saveClient(@Body ClientDto clientDto, Callback<ClientDto> clientDtoCallback);
}
