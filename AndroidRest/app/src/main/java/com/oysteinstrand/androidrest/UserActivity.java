package com.oysteinstrand.androidrest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.oysteinstrand.androidrest.events.LoadUserEvent;
import com.oysteinstrand.androidrest.events.UserLoadedEvent;
import com.oysteinstrand.androidrest.R;
import com.squareup.otto.Subscribe;

public class UserActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
//        checkLogin();
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

    @Subscribe
    public void onUserLoaded(UserLoadedEvent event) {
        Log.d(UserActivity.class.getSimpleName(), "User should be loaded. Username = " + event.user.username);
        TextView tvUsername = (TextView) findViewById(R.id.username);
        tvUsername.setText(event.user.username);
    }
}
