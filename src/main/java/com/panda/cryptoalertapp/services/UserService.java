package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String username, String email, String password) {
        userRepository.save(new User(username, email, password));
    }
}
