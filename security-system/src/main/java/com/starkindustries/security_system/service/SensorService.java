package com.starkindustries.security_system.service;


import com.starkindustries.security_system.model.Event;
import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getActiveSensors() {
        return sensorRepository.findByActiveTrue(); // Retorna sensores activos
    }

    @Async
    public void processSensorData(Sensor sensor) {
        // Lógica de procesamiento de datos
        // Generar un evento si es necesario
        Event event = new Event();
        event.setSensor(sensor);
        event.setEventType("Movement Detected");
        // Guardar el evento (se puede llamar a un repositorio aquí)
    }
}
