package com.oysteinstrand.androidrest;

import com.squareup.otto.Bus;

public class BusProvider {

    private static Bus bus = new Bus();

    public static Bus getBus() {
        return bus;
    }
}
