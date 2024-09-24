package com.starkindustries.security_system.service;



import com.starkindustries.security_system.model.User;
import com.starkindustries.security_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRoles(userDetails.getRoles()); // Actualiza los roles
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Set<String> getRoles(Long id) {
        return userRepository.findById(id)
                .map(User::getRoles)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Devuelve todos los usuarios
    }

}
