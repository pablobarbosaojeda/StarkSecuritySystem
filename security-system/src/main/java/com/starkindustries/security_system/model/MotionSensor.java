package com.starkindustries.security_system.model;


import com.starkindustries.security_system.repository.ReaderRepository;
import jakarta.persistence.Entity;

@Entity
public class MotionSensor extends Sensor {
    public MotionSensor() {
    }

    public MotionSensor(String name, String location, boolean status) {
        super(name, location, status, SensorType.MOTION);
    }

    public MotionSensor(long id, String name, String location, boolean status) {
        super(id, name, location, status, SensorType.MOTION);
    }

    @Override
    public void detect(String value, ReaderRepository readerRepository) {
        super.detect(value, readerRepository);

        // Imprimir mensaje de detección (puedes personalizar o sustituir por lógica más avanzada)
        System.out.println("Sensor de movimiento detectó valor: " + value);
    }
}
