package com.oysteinstrand.androidrest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.btn_login);

        // Post an event to login user when loginButton is pressed
    }

}
