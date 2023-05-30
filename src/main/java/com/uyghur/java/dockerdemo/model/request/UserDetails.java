package com.uyghur.java.dockerdemo.model.request;

import javax.validation.constraints.NotNull;

public class UserDetails {
    @NotNull(message = "username should not be null")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
