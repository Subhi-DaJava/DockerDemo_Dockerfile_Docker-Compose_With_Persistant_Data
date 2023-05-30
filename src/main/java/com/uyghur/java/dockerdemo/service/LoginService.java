package com.uyghur.java.dockerdemo.service;

import com.uyghur.java.dockerdemo.model.Login;

public interface LoginService {
    Login checkUsername(String username);
}
