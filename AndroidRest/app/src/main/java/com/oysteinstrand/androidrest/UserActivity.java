package com.oysteinstrand.androidrest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.oysteinstrand.androidrest.events.LoadUserEvent;
import com.squareup.otto.Subscribe;

public class UserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }


    @Override
    protected void onResume() {
        super.onResume();
        checkLogin();
    }

    private void checkLogin() {
        if (getApp().isUserLoggedIn()) {
            getBus().post(new LoadUserEvent());
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    // Subscribe to an event for user loaded and update the textview

}
