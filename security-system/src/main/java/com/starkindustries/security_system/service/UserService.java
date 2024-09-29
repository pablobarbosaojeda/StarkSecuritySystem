package com.starkindustries.security_system.service;

import com.starkindustries.security_system.model.User;
import com.starkindustries.security_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // En ServicioUsuario.java
    public Optional<com.starkindustries.security_system.model.User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Aquí usamos tu clase de repositorio para buscar al usuario
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró el usuario con el email: " + email));

        // Retornar un objeto UserDetails utilizando el constructor de la clase User de Spring Security
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())))
                .build();
    }


    // Obtener todos los usuarios
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Agregar un nuevo usuario
    public void addNewUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalArgumentException("El email ya existe");
        }
        userRepository.save(user);
    }

    // Eliminar un usuario por ID
    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El usuario con id " + id + " no existe.");
        }
        userRepository.deleteById(id);
    }

    // Actualizar un usuario por ID
    public void updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El usuario con id " + id + " no existe."));

        if (updatedUser.getName() != null && !updatedUser.getName().isEmpty()) {
            user.setName(updatedUser.getName());
        }

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty()) {
            Optional<User> userByEmail = userRepository.findUserByEmail(updatedUser.getEmail());
            if (userByEmail.isPresent()) {
                throw new IllegalArgumentException("El email ya existe");
            }
            user.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            user.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getRole() != null) {
            user.setRole(updatedUser.getRole());
        }

        userRepository.save(user);
    }
}
