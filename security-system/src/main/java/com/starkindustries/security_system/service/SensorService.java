package com.starkindustries.security_system.service;



import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Optional<Sensor> getSensorById(Long id) {
        return sensorRepository.findById(id);
    }

    public Sensor updateSensor(Long id, Sensor sensorDetails) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow();
        sensor.setName(sensorDetails.getName());
        sensor.setType(sensorDetails.getType());
        sensor.setStatus(sensorDetails.getStatus());
        sensor.setLocation(sensorDetails.getLocation()); // Actualizar ubicación
        return sensorRepository.save(sensor);
    }

    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }
}
