package com.oysteinstrand.androidrest;

import android.app.Activity;

import com.squareup.otto.Bus;

public class BaseActivity extends Activity {
    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getBus().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getBus().unregister(this);
    }

    public LoginApplication getApp() {
        return (LoginApplication)getApplication();
    }

    public Bus getBus() {
        return BusProvider.getBus();
    }
}
