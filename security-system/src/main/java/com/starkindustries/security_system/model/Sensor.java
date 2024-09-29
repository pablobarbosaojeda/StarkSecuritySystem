package com.starkindustries.security_system.model;


import com.starkindustries.security_system.repository.ReaderRepository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sensors")
public abstract class Sensor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Getter @Setter
    private String name, location;

    @Getter @Setter
    private boolean status;

    @Getter
    @Enumerated(EnumType.STRING)
    SensorType type;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reader> readings;

    public Sensor() {
    }

    public Sensor(String name, String location, boolean status, SensorType type) {
        this.name = name;
        this.location = location;
        this.status = status;
        this.type = type;
    }

    public Sensor(long id, String name, String location, boolean status, SensorType type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
        this.type = type;
    }

    public void detect(String value, ReaderRepository readerRepository){
        // Crear una nueva lectura con el valor recibido y la fecha actual
        Reader reader = new Reader(value, this, LocalDateTime.now());

        // Guardar la lectura en la base de datos
        readerRepository.save(reader);
    }

    @Override
    public String toString() {
        return "Sensor[" +
                "Id: " + id +
                ", Name: " + name + '\'' +
                ", Location: " + location + '\'' +
                ", Status:" + status;
    }
}
