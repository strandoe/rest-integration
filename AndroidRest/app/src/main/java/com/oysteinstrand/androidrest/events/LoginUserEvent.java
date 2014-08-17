package com.oysteinstrand.androidrest.events;

public class LoginUserEvent {
    public final String username, password;

    public LoginUserEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
