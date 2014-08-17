package com.oysteinstrand.androidrest.api;

public class ClientDto {
    public final String clientId, name, clientSecret;

    public ClientDto(String clientId, String name, String clientSecret) {
        this.clientId = clientId;
        this.name = name;
        this.clientSecret = clientSecret;
    }
}
