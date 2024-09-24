package com.starkindustries.security_system.model;


import com.starkindustries.security_system.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SensorSimulator {

    @Autowired
    private SensorService sensorService; // Suponiendo que tienes un servicio para manejar sensores

    private Random random = new Random();

    @Async
    public void simulateSensor(Sensor sensor) {
        while (true) {
            // Simular la actualización de estado
            String newStatus = random.nextBoolean() ? "Activo" : "Inactivo"; // Simulación aleatoria
            sensor.setStatus(newStatus);
            sensorService.updateSensor(sensor.getId(), sensor); // Actualizar el sensor en la base de datos
            try {
                Thread.sleep(5000); // Esperar 5 segundos entre actualizaciones
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
