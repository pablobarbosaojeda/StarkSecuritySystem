package com.starkindustries.security_system.service;

import com.starkindustries.security_system.model.AccessSensor;
import com.starkindustries.security_system.model.MotionSensor;
import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.model.TempSensor;
import com.starkindustries.security_system.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    // Obtener todos los sensores
    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    // Obtener sensores de temperatura
    public List<TempSensor> getTempSensors() {
        return sensorRepository.findAllTempSensors();
    }

    // Obtener sensores de movimiento
    public List<MotionSensor> getMotionSensors() {
        return sensorRepository.findAllMotionSensors();
    }

    // Obtener sensores de acceso
    public List<AccessSensor> getAccessSensors() {
        return sensorRepository.findAllAccessSensors();
    }

    // Agregar un nuevo sensor
    public void addNewSensor(Sensor sensor) {
        Optional<Sensor> sensorByName = sensorRepository.findSensorByName(sensor.getName());
        if (sensorByName.isPresent()) {
            throw new IllegalArgumentException("El sensor ya existe");
        }
        sensorRepository.save(sensor);
    }

    // Eliminar un sensor por ID
    public void deleteSensor(Long id) {
        boolean exists = sensorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El sensor con id " + id + " no existe.");
        }
        sensorRepository.deleteById(id);
    }
}
