package com.murbanowicz.nofluffcars.controller;

import com.murbanowicz.nofluffcars.data.dynamicdata.entity.User;
import com.murbanowicz.nofluffcars.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }
}