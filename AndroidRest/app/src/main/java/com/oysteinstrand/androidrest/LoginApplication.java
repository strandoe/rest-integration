package com.oysteinstrand.androidrest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.oysteinstrand.androidrest.api.ApiErrorEvent;
import com.oysteinstrand.androidrest.api.LoginApi;
import com.oysteinstrand.androidrest.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class LoginApplication extends Application {

    public static final String API_ENDPOINT = "http://mobil2014.herokuapp.com/api";
    public static final String CLIENT_ID = "REST-INTEGRATION-EXAMPLE-APP";
    public static final String CLIENT_SECRET = "supersecret123";

    private LoginService loginService;

    @Override
    public void onCreate() {
        super.onCreate();
        this.loginService = new LoginService(BusProvider.getBus(), buildLoginApi());
        BusProvider.getBus().register(this);
    }

    @Subscribe
    public void onApiError(ApiErrorEvent event) {
        toast("Something went wrong, please try again.");
        Log.e("UserApi", event.getErrorMessage());
        Log.e("UserApi", event.getRawResponse());
    }

    public boolean isUserLoggedIn() {
        Log.d(LoginApplication.class.getSimpleName(), "Is user logged in? " + (getLoginPreferences().contains(getString(R.string.token)) && getToken() != null));
        return getLoginPreferences().contains(getString(R.string.token)) && getToken() != null;
    }

    public String getToken() {
        return getLoginPreferences().getString(getString(R.string.token), null);
    }

    public SharedPreferences getLoginPreferences() {
        return getSharedPreferences(getString(R.string.login_preferences), Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        Log.d(LoginApplication.class.getSimpleName(), "Saving token " + token);
        getLoginPreferences().edit().putString(getString(R.string.token), token).commit();
    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private LoginApi buildLoginApi() {
        return new RestAdapter.Builder()
                .setEndpoint(API_ENDPOINT)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        if (getToken() != null) {
                            String authHeader = "Bearer " + getToken();
                            request.addHeader("Authorization", authHeader);
                            Log.d("AuthHeader", authHeader);
                        }
                    }
                })
                .build()
                .create(LoginApi.class);
    }
}
