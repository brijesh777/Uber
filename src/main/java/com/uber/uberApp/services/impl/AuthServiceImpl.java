package com.uber.uberApp.services.impl;

import com.uber.uberApp.dto.DriverDto;
import com.uber.uberApp.dto.SignupDto;
import com.uber.uberApp.dto.UserDto;
import com.uber.uberApp.entities.Driver;
import com.uber.uberApp.entities.User;
import com.uber.uberApp.entities.enums.Role;
import com.uber.uberApp.exceptions.ResourceNotFoundException;
import com.uber.uberApp.exceptions.RuntimeConflictException;
import com.uber.uberApp.repositories.UserRepository;
import com.uber.uberApp.security.JwtService;
import com.uber.uberApp.services.AuthService;
import com.uber.uberApp.services.DriverService;
import com.uber.uberApp.services.RiderService;
import com.uber.uberApp.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final WalletService walletService;
    private final RiderService riderService;
    private final DriverService driverService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override

    public String[] login(String email, String password) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        User user = (User) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new String[]{accessToken, refreshToken};
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);

        if (user != null)
            new RuntimeConflictException("Cannot signup, User already exists with email " + signupDto.getEmail());

        user = modelMapper.map(signupDto, User.class);
        user.setRoles(Set.of(Role.RIDER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        // Create Use related entities
        riderService.createNewRider(user);
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vechileId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        if (user.getRoles().contains(Role.DRIVER)) {
            throw new RuntimeConflictException("User with id " + userId + " is already a Driver");
        }

        Driver createdDriver = Driver.builder()
                .user(user)
                .vechileId(vechileId)
                .available(true)
                .build();

        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);

        Driver savedDriver = driverService.createNewDriver(createdDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }

    @Override
    public String refreshToken(String refreshToken) {
        Long userId = jwtService.getUserIdFromToken(refreshToken);

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        return jwtService.generateRefreshToken(user);
    }
}
