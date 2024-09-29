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
    public UserController(UserService servicioUsuario, PasswordEncoder passwordEncoder) {
        this.userService = servicioUsuario;
        this.passwordEncoder = passwordEncoder;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getUsers() {
        return UserService.getUsers();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return UserService.getUserById(id);
    }

    // Agregar un nuevo usuario
    @PostMapping
    public void addUser(@RequestBody User user) {
        UserService.addNewUser(new User(user.getName(), user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getRole()));
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        UserService.deleteUser(id);
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public void updateUser(
            @PathVariable("id") Long id,
            @RequestBody User UpdatedUser) {
        UserService.updateUser(id, UpdatedUser);
    }
}

