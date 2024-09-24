package com.starkindustries.security_system.controller;

import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Validated // Asegúrate de aplicar la validación a la clase
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> getAllSensors() {
        System.out.println("Llamada a getAllSensors en el controlador."); // Log de depuración
        return sensorService.getAllSensors();
    }


    @PostMapping
    public Sensor createSensor(@Validated @RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Long id) {
        try {
            Sensor sensor = sensorService.getSensorById(id);
            return ResponseEntity.ok(sensor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable Long id, @Validated @RequestBody Sensor sensorDetails) {
        Sensor updatedSensor = sensorService.updateSensor(id, sensorDetails);
        return ResponseEntity.ok(updatedSensor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }
}
