package com.oysteinstrand.androidrest.api;

import retrofit.RetrofitError;

public class ApiErrorEvent {
    private RetrofitError error;

    public ApiErrorEvent(RetrofitError error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return error.getMessage();
    }

    public String getRawResponse() {
        return error.getResponse().getBody().toString();
    }
}
