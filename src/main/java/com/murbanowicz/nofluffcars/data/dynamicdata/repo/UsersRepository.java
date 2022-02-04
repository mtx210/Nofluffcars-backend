package com.murbanowicz.nofluffcars.data.dynamicdata.repo;

import com.murbanowicz.nofluffcars.data.dynamicdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {


}