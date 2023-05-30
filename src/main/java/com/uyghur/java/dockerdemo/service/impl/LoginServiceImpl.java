package com.uyghur.java.dockerdemo.service.impl;

import com.uyghur.java.dockerdemo.exceptions.UserNotFoundException;
import com.uyghur.java.dockerdemo.model.Login;
import com.uyghur.java.dockerdemo.repository.LoginRepository;
import com.uyghur.java.dockerdemo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login checkUsername(String username) {
        Optional<Login> loginDetails = loginRepository.findByUsername(username);
        if (loginDetails.isEmpty()) throw new UserNotFoundException(username);
        logger.info("login details has been successfully retrieved");
        return loginDetails.get();
    }
}
