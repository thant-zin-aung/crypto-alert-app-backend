package com.panda.cryptoalertapp.services;

import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserService(UserRepository userRepository) {

    public void saveUser(String username, String email, String password) {
        userRepository.save(new User(username, email, password));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
