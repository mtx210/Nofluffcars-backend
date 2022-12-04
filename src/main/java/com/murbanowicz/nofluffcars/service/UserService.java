package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.api.dto.request.RegisterUserRequest;
import com.murbanowicz.nofluffcars.data.entity.User;
import com.murbanowicz.nofluffcars.data.repo.UserRepository;
import com.murbanowicz.nofluffcars.exception.UserAlreadyExistsException;
import com.murbanowicz.nofluffcars.security.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegisterUserRequest registerUserRequest) throws UserAlreadyExistsException {
        if (userRepository.existsByEmail(registerUserRequest.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        User user = new User();
        user.setName(registerUserRequest.getName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}