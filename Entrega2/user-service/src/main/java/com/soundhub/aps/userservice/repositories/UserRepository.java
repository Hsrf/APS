package com.soundhub.aps.userservice.repositories;

import com.soundhub.aps.userservice.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
