package com.starkindustries.security_system.config;

import com.starkindustries.security_system.model.*;
import com.starkindustries.security_system.repository.ReaderRepository;
import com.starkindustries.security_system.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("ALL")
@Configuration
public class SensorConfig {

    @Bean
    CommandLineRunner sensorRunner(SensorRepository sensorRepository, ReaderRepository readerRepository) {
        return args -> {
            // Creamos los sensores
            TempSensor sensor1on = new TempSensor("sensor1", "Vestibulo", true);
            TempSensor sensor2off = new TempSensor("sensor2", "Entrada", false);
            MotionSensor sensor3on = new MotionSensor("sensor3", "Despacho", true);
            AccessSensor sensor4on = new AccessSensor("sensor4", "Entrada", true);

            // Guardamos los sensores en la base de datos
            sensorRepository.deleteAll(); // Usamos la instancia inyectada
            sensorRepository.saveAll(List.of(sensor1on, sensor2off, sensor3on, sensor4on)); // Usamos la instancia inyectada

            // Creamos las lecturas para sensor1on
            Reader lectura1 = new Reader("25.5", sensor1on, LocalDateTime.of(2024, 8, 27, 14, 0));
            Reader lectura2 = new Reader("24.5", sensor1on, LocalDateTime.of(2024, 8, 27, 14, 35));
            Reader lectura3 = new Reader("26.2", sensor1on, LocalDateTime.of(2024, 8, 27, 14, 50));
            Reader lectura4 = new Reader("22.5", sensor1on, LocalDateTime.of(2024, 8, 27, 15, 15));
            Reader lectura5 = new Reader("23.5", sensor1on, LocalDateTime.of(2024, 8, 27, 16, 20));

            // Creamos lecturas para sensor2off (aunque esté apagado, podríamos tener datos previos)
            Reader lectura6 = new Reader("20.0", sensor2off, LocalDateTime.of(2024, 8, 27, 14, 0));
            Reader lectura7 = new Reader("18.8", sensor2off, LocalDateTime.of(2024, 8, 27, 14, 30));
            Reader lectura8 = new Reader("21.0", sensor2off, LocalDateTime.of(2024, 8, 27, 15, 0));

            // Creamos lecturas para sensor3on (sensor de movimiento)
            Reader lectura9 = new Reader("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 14, 15));
            Reader lectura10 = new Reader("Sin movimiento", sensor3on, LocalDateTime.of(2024, 8, 27, 14, 45));
            Reader lectura11 = new Reader("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 15, 10));
            Reader lectura12 = new Reader("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 15, 15));
            Reader lectura13 = new Reader("Sin movimiento", sensor3on, LocalDateTime.of(2024, 8, 27, 15, 45));
            Reader lectura14 = new Reader("Movimiento detectado", sensor3on, LocalDateTime.of(2024, 8, 27, 16, 10));

            // Creamos lecturas para sensor4on (sensor de acceso)
            Reader lectura15 = new Reader("Acceso denegado", sensor4on, LocalDateTime.of(2024, 8, 27, 14, 20));
            Reader lectura16 = new Reader("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 14, 50));
            Reader lectura17 = new Reader("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 15, 25));
            Reader lectura18 = new Reader("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 15, 40));
            Reader lectura19 = new Reader("Acceso denegado", sensor4on, LocalDateTime.of(2024, 8, 27, 15, 50));
            Reader lectura20 = new Reader("Acceso permitido", sensor4on, LocalDateTime.of(2024, 8, 27, 16, 25));

            // Guardamos todas las lecturas en la base de datos
            readerRepository.deleteAll(); // Usamos la instancia inyectada
            readerRepository.saveAll(List.of(
                    lectura1, lectura2, lectura3, lectura4, lectura5,
                    lectura6, lectura7, lectura8,
                    lectura9, lectura10, lectura11,
                    lectura12, lectura13, lectura14,
                    lectura15, lectura16, lectura17,
                    lectura18, lectura19, lectura20
            )); // Usamos la instancia inyectada
        };
    }
}
