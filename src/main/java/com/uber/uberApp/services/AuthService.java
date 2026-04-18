package com.uber.uberApp.services;

import com.uber.uberApp.dto.DriverDto;
import com.uber.uberApp.dto.SignupDto;
import com.uber.uberApp.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vechileId);

    String refreshToken(String refreshToken);
}
