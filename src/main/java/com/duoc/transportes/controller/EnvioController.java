package com.duoc.transportes.controller;

import com.duoc.transportes.model.Envio;
import com.duoc.transportes.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnvioController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private EnvioService envioService;

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/envios")
    public ResponseEntity<?> getEnvios() {
        return ResponseEntity.status(200).body(envioService.findAll());
    }

    @GetMapping("/api/v1/envios/{id}")
    public ResponseEntity<?> getEnvio(@PathVariable Integer id) {
        Envio envio = envioService.findById(id);

        if (null == envio) {
            return ResponseEntity.status(404).body("Envio no encontrado");
        }

        return ResponseEntity.status(200).body(envioService.findById(id));
    }

    @DeleteMapping("/api/v1/envios/{id}")
    public ResponseEntity<?> deleteEnvio(@PathVariable Integer id) {
        Envio envio = envioService.findById(id);

        if (null == envio) {
            return ResponseEntity.status(404).body("Envio no encontrado");
        }

        envioService.delete(id);

        return ResponseEntity.status(200).body("Envio eliminado");
    }

    @PostMapping("/api/v1/envios")
    public ResponseEntity<?> saveEnvio(@RequestBody Envio envio) {
        Envio envioGuardado = envioService.save(envio);

        return ResponseEntity.status(201).body(envioGuardado);
    }


}
