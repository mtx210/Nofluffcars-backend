package com.murbanowicz.nofluffcars.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterUserRequest {

    private final String name;
    private final String email;
    private final String password;
}