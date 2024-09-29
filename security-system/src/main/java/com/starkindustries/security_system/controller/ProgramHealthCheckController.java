package com.starkindustries.security_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.starkindustries.security_system.repository.UserRepository;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("publico/api/v1/health")
public class ProgramHealthCheckController {

    private final UserRepository userRepository;

    @Autowired
    public ProgramHealthCheckController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        try {
            // Intentar hacer una operación en la base de datos
            userRepository.count();
            return ResponseEntity.ok("UP");
        } catch (Exception e) {
            return ResponseEntity.status(503).body("DOWN");
        }
    }
}
