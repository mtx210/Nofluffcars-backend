package com.murbanowicz.nofluffcars.api.controller;

import com.murbanowicz.nofluffcars.api.dto.request.RegisterUserRequest;
import com.murbanowicz.nofluffcars.api.dto.response.GenerationResponse;
import com.murbanowicz.nofluffcars.exception.UserAlreadyExistsException;
import com.murbanowicz.nofluffcars.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<List<GenerationResponse>> register(
            @RequestBody @Valid RegisterUserRequest registerUserRequest
    ) {
        try {
            userService.registerUser(registerUserRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}