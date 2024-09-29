package com.starkindustries.security_system.controller;


import com.starkindustries.security_system.model.AccessSensor;
import com.starkindustries.security_system.model.MotionSensor;
import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.model.TempSensor;
import com.starkindustries.security_system.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publico/api/v1/sensors")
@CrossOrigin(origins = "http://localhost:8080")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    // Obtener todos los sensores
    @GetMapping
    public List<Sensor> getSensors() {
        return SensorService.getSensors();
    }

    // Obtener sensores de temperatura
    @GetMapping("/temperature")
    public List<TempSensor> getTempSensors() {
        return SensorService.getTempSensors();
    }

    // Obtener sensores de movimiento
    @GetMapping("/motion")
    public List<MotionSensor> getMotionSensors() {
        return SensorService.getMotionSensors();
    }

    // Obtener sensores de acceso
    @GetMapping("/access")
    public List<AccessSensor> getAccessSensors() {
        return SensorService.getAccessSensors();
    }

    // Agregar un nuevo sensor
    @PostMapping
    public void addSensor(@RequestBody Sensor sensor) {
        SensorService.addNewSensor(sensor);
    }

    // Eliminar un sensor por ID
    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable("id") Long id) {
        SensorService.deleteSensor(id);
    }
}
