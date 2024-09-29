package com.starkindustries.security_system.model;


import com.starkindustries.security_system.repository.ReaderRepository;
import jakarta.persistence.Entity;

@Entity
public class AccessSensor extends Sensor {
    public AccessSensor() {
    }

    public AccessSensor(String name, String location, boolean status) {
        super(name, location, status, SensorType.ACCESS);
    }

    public AccessSensor(long id, String name, String location, boolean status) {
        super(id, name, location, status, SensorType.ACCESS);
    }

    @Override
    public void detect(String value, ReaderRepository readerRepository) {
        super.detect(value, readerRepository);

        // Imprimir mensaje de detección (puedes personalizar o sustituir por lógica más avanzada)
        System.out.println("Sensor de acceso detectó valor: " + value);
    }
}
