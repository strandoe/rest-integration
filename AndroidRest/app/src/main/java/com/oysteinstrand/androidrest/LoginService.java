package com.oysteinstrand.androidrest;

import com.oysteinstrand.androidrest.api.UserDto;
import com.oysteinstrand.androidrest.events.LoadUserEvent;
import com.oysteinstrand.androidrest.events.LoginUserEvent;
import com.oysteinstrand.androidrest.api.ApiErrorEvent;
import com.oysteinstrand.androidrest.api.LoginApi;
import com.oysteinstrand.androidrest.api.TokenRequestDto;
import com.oysteinstrand.androidrest.api.TokenResponseDto;
import com.oysteinstrand.androidrest.events.UserLoadedEvent;
import com.oysteinstrand.androidrest.events.UserLoggedInEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginService {
    private Bus bus;
    private LoginApi api;

    public LoginService(Bus bus, LoginApi api) {
        this.bus = bus;
        this.api = api;
        bus.register(this);
    }

    @Subscribe
    public void onLoginUser(LoginUserEvent event) {
        api.getToken(new TokenRequestDto(LoginApplication.CLIENT_ID, LoginApplication.CLIENT_SECRET, event.username, event.password), new Callback<TokenResponseDto>() {
            @Override
            public void success(TokenResponseDto tokenResponseDto, Response response) {
                bus.post(new UserLoggedInEvent(tokenResponseDto.access_token));
            }

            @Override
            public void failure(RetrofitError error) {
                bus.post(new ApiErrorEvent(error));
            }
        });
    }

    @Subscribe
    public void onLoadUser(LoadUserEvent event) {
        api.getUser(new Callback<List<UserDto>>() {
            @Override
            public void success(List<UserDto> users, Response response) {
                bus.post(new UserLoadedEvent(users.get(0)));
            }

            @Override
            public void failure(RetrofitError error) {
                bus.post(new ApiErrorEvent(error));
            }
        });
    }

}
