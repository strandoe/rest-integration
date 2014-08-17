package com.oysteinstrand.androidrest.api;

public class TokenResponseDto {
    public final String access_token, refresh_token, token_type;
    public final Integer expires_in;

    public TokenResponseDto(String access_token, String refresh_token, String token_type, Integer expires_in) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }
}
