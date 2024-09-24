package com.starkindustries.security_system.service;


import com.starkindustries.security_system.model.User;
import com.starkindustries.security_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Método para crear un nuevo usuario
    public User createUser(User user) {
        // Encriptar la contraseña antes de guardarla
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);  // Guardar el usuario en la base de datos
    }

    // Método para obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Obtener todos los usuarios de la base de datos
    }

    // Método para obtener un usuario por su ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);  // Buscar un usuario por su ID
    }

    // Método para buscar un usuario por su nombre de usuario
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);  // Buscar un usuario por su nombre de usuario
    }

    // Método para actualizar un usuario
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setRoles(userDetails.getRoles());

            // Verificar si se debe actualizar la contraseña
            if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            }

            return userRepository.save(user);  // Guardar los cambios
        } else {
            throw new RuntimeException("Usuario no encontrado");  // Manejar usuario no encontrado
        }
    }

    // Método para eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);  // Eliminar un usuario por su ID
    }
}
