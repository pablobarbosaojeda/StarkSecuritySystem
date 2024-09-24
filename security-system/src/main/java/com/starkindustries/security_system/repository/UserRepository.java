package com.starkindustries.security_system.repository;


import com.starkindustries.security_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Buscar usuario por nombre
}
