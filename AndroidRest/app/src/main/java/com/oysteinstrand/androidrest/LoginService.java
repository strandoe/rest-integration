package com.oysteinstrand.androidrest;

import com.oysteinstrand.androidrest.api.LoginApi;
import com.squareup.otto.Bus;

public class LoginService {
    private Bus bus;
    private LoginApi api;

    public LoginService(Bus bus, LoginApi api) {
        this.bus = bus;
        this.api = api;
        bus.register(this);
    }

}
