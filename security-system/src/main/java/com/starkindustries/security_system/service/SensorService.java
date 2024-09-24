package com.starkindustries.security_system.service;

import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        List<Sensor> sensors = sensorRepository.findAll();
        System.out.println("Total de sensores encontrados: " + sensors.size()); // Log de depuración
        return sensors;
    }

    public Sensor createSensor(Sensor sensor) {
        // Aquí podrías agregar validaciones adicionales antes de guardar
        return sensorRepository.save(sensor);
    }

    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found with id: " + id));
    }

    public Sensor updateSensor(Long id, Sensor sensorDetails) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found with id: " + id));

        // Actualizamos los detalles del sensor
        sensor.setName(sensorDetails.getName());
        sensor.setType(sensorDetails.getType());
        sensor.setStatus(sensorDetails.getStatus());
        sensor.setLocation(sensorDetails.getLocation()); // Actualizar ubicación

        return sensorRepository.save(sensor);
    }

    public void deleteSensor(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new RuntimeException("Sensor not found with id: " + id);
        }
        sensorRepository.deleteById(id);
    }
}
