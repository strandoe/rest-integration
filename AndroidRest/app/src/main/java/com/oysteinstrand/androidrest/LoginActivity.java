package com.oysteinstrand.androidrest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.oysteinstrand.androidrest.events.LoginUserEvent;
import com.oysteinstrand.androidrest.events.UserLoadedEvent;
import com.oysteinstrand.androidrest.events.UserLoggedInEvent;
import com.oysteinstrand.androidrest.R;
import com.squareup.otto.Subscribe;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBus().post(new LoginUserEvent(etUsername.getText().toString(), etPassword.getText().toString()));
            }
        });
    }

    @Subscribe
    public void onUserLoggedIn(UserLoggedInEvent event) {
        getApp().saveToken(event.token);
        startActivity(new Intent(this, UserActivity.class));
    }

}
