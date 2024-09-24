package com.starkindustries.security_system.model;

import jakarta.persistence.*;


@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // Tipo de sensor (movimiento, temperatura, acceso)
    private String location; // Ubicación del sensor
    private boolean active; // Estado del sensor

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
