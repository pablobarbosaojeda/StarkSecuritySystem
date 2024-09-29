package com.starkindustries.security_system.repository;



import com.starkindustries.security_system.model.AccessSensor;
import com.starkindustries.security_system.model.MotionSensor;
import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.model.TempSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query("SELECT s FROM Sensor s WHERE s.name = ?1")
    Optional<Sensor> findSensorByName(String name);

    // Consultas personalizadas para los distintos tipos de sensores
    @Query("SELECT s FROM TempSensor s")
    List<TempSensor> findAllTempSensors();

    @Query("SELECT s FROM MotionSensor s")
    List<MotionSensor> findAllMotionSensors();

    @Query("SELECT s FROM AccessSensor s")
    List<AccessSensor> findAllAccessSensors();

    List<Sensor> findByStatus(boolean b);
}
