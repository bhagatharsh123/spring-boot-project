package com.yourcompany.auth.service;

import com.yourcompany.auth.config.JwtTokenProvider;
import com.yourcompany.auth.model.User;
import com.yourcompany.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Invalid username/password"));

        // ✅ Correct way: compare raw password with encoded password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid username/password");
        }

        // ✅ Pass only username (not password)
        return jwtTokenProvider.generateToken(user.getUsername());
    }
}
