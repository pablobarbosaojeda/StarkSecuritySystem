package com.starkindustries.security_system.config;

import com.starkindustries.security_system.model.Roles;
import com.starkindustries.security_system.model.User;
import com.starkindustries.security_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User defaultAdmin = new User( "admin@starkindustries.com", "admin", passwordEncoder.encode("admin"), Roles.ADMIN);
            User defaultUser = new User( "user@starkindustries.com", "user", passwordEncoder.encode("user"), Roles.USER);
            userRepository.deleteAll();
            userRepository.saveAll(List.of(defaultAdmin, defaultUser));
        };
    }
}
