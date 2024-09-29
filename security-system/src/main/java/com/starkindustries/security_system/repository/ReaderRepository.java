package com.starkindustries.security_system.repository;


import com.starkindustries.security_system.model.Reader;
import com.starkindustries.security_system.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    // Buscar lecturas por sensor
    List<Reader> findBySensor(Sensor sensor);

    // Obtener lecturas más recientes por sensor
    @Query("SELECT l FROM Reader l WHERE l.sensor = ?1 ORDER BY l.date DESC")
    List<Reader> findRecentLecturesBySensor(Sensor sensor);
}
