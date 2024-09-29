package com.starkindustries.security_system.controller;

import com.starkindustries.security_system.model.Reader;
import com.starkindustries.security_system.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publico/api/v1/lecturas")
@CrossOrigin(origins = "http://localhost:5173")
public class ReaderController {

    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    // Obtener todas las lecturas
    @GetMapping
    public List<Reader> getReader() {
        return readerService.getReader();
    }

    // Obtener lecturas por sensor
    @GetMapping("/sensor/{sensorId}")
    public List<Reader> getReaderBySensor(@PathVariable("sensorId") Long sensorId) {
        return readerService.getReaderBySensor(sensorId);
    }

    // Agregar nueva lectura
    @PostMapping
    public void addReader(@RequestBody Reader reader) {
        ReaderService.addReader(reader);
    }

    // Eliminar lectura por ID
    @DeleteMapping("/{readerId}")
    public void deleteReader(@PathVariable("readerId") Long readerId) {
        ReaderService.deleteReader(readerId);
    }
}
