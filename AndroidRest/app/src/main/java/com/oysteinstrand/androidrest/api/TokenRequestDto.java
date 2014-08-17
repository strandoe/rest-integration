package com.oysteinstrand.androidrest.api;

public class TokenRequestDto {
    public final String
        grant_type = "password",
        client_id,
        client_secret,
        username,
        password;

    public TokenRequestDto(String client_id, String client_secret, String username, String password) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.username = username;
        this.password = password;
    }
}
