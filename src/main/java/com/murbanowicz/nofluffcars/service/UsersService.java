package com.murbanowicz.nofluffcars.service;

import com.murbanowicz.nofluffcars.data.dynamicdata.entity.User;
import com.murbanowicz.nofluffcars.data.dynamicdata.repo.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAll() {
        return usersRepository.findAll();
    }
}
