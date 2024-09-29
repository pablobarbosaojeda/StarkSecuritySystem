package com.starkindustries.security_system.controller;



import com.starkindustries.security_system.model.User;
import com.starkindustries.security_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("publico/api/v1/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers(); // Usamos la instancia inyectada
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id); // Usamos la instancia inyectada
    }

    // Agregar un nuevo usuario
    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addNewUser(new User(user.getName(), user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getRole()));
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id); // Usamos la instancia inyectada
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public void updateUser(
            @PathVariable("id") Long id,
            @RequestBody User updatedUser) {
        userService.updateUser(id, updatedUser); // Usamos la instancia inyectada
    }
}
