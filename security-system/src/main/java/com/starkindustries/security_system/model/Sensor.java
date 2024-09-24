package com.starkindustries.security_system.model;

import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type; // Ej. Movimiento, Temperatura, Acceso
    private String status; // Ej. Activo, Inactivo
    private String location; // Ubicación del sensor

    // Constructor
    public Sensor() {
    }

    public Sensor(String name, String type, String status, String location) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.location = location;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status; // Este método debe existir
    }

    public String getLocation() {
        return location; // Método para obtener la ubicación
    }

    public void setLocation(String location) {
        this.location = location; // Método para establecer la ubicación
    }

    public boolean isStatus() {
        return "Activo".equalsIgnoreCase(status); // Método para verificar el estado
    }
}
