package com.starkindustries.security_system.service;

import com.starkindustries.security_system.model.Reader;
import com.starkindustries.security_system.model.Sensor;
import com.starkindustries.security_system.repository.ReaderRepository;
import com.starkindustries.security_system.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository, SensorRepository sensorRepository) {
        this.readerRepository = readerRepository;
        this.sensorRepository = sensorRepository;
    }

    // Obtener todas las lecturas
    public List<Reader> getReader() {
        return readerRepository.findAll();
    }

    // Obtener lecturas por sensor
    public List<Reader> getReaderBySensor(Long sensorId) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new IllegalStateException("Sensor no encontrado"));
        return readerRepository.findBySensor(sensor);
    }

    // Agregar nueva lectura
    public void addReader(Reader lectura) {
        readerRepository.save(lectura);
    }

    // Eliminar lectura por ID
    public void deleteReader(Long readerId) {
        boolean exists = readerRepository.existsById(readerId);
        if (!exists) {
            throw new IllegalStateException("La lectura con id " + readerId + " no existe.");
        }
        readerRepository.deleteById(readerId);
    }
}
