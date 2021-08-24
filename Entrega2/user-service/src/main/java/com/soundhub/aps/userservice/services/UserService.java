package com.soundhub.aps.userservice.services;

import java.util.List;
import java.util.Optional;
import com.soundhub.aps.userservice.model.User;
import com.soundhub.aps.userservice.model.dto.UserDTO;
import com.soundhub.aps.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO getUserById(Long id){
        User user = repository.getById(id);
        return new UserDTO(user);
    }

    public void saveUser(String name, String email, String password){
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        repository.save(newUser);
        return;
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public Optional<User> getUser(Long id){
        return repository.findById(id);
    }
}
