package com.oysteinstrand.androidrest.events;

public class UserLoggedInEvent {
    public final String token;

    public UserLoggedInEvent(String token) {
        this.token = token;
    }
}
