package com.starkindustries.security_system.repository;


import com.starkindustries.security_system.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByActiveTrue(); // Obtener sensores activos
}
