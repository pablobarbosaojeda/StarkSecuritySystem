package com.starkindustries.security_system.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "readings")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String value;

    @Getter @Setter
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id")
    @Getter @Setter
    private Sensor sensor;

    public Reader(Long id, String value, LocalDateTime date, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.sensor = sensor;
    }

    public Reader() {
        this.date = LocalDateTime.now();
    }

    public Reader(String value, Sensor sensor) {
        this.value = value;
        this.sensor = sensor;
        this.date = LocalDateTime.now();
    }

    public Reader(String value, Sensor sensor, LocalDateTime time) {
        this.value = value;
        this.sensor = sensor;
        this.date = time;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", date=" + date +
                ", sensor=" + sensor +
                '}';
    }
}
