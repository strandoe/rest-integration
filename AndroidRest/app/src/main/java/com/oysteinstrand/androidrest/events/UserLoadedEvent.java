package com.oysteinstrand.androidrest.events;

import com.oysteinstrand.androidrest.api.UserDto;

public class UserLoadedEvent {
    public final UserDto user;

    public UserLoadedEvent(UserDto user) {
        this.user = user;
    }
}
