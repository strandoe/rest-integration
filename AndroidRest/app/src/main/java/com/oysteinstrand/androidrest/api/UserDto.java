package com.oysteinstrand.androidrest.api;

public class UserDto {
    public final String username, password;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
