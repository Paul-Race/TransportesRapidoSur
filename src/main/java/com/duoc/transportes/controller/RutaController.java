package com.duoc.transportes.controller;

import com.duoc.transportes.model.Ruta;
import com.duoc.transportes.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RutaController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private RutaService rutaService;

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/rutas")
    public ResponseEntity<?> getRutas() {
        return ResponseEntity.status(200).body(rutaService.findAll());
    }

    @GetMapping("/api/v1/rutas/{id}")
    public ResponseEntity<?> getRuta(@PathVariable Integer id) {
        Ruta ruta = rutaService.findById(id);

        if (null == ruta) {
            return ResponseEntity.status(404).body("Ruta no encontrado");
        }

        return ResponseEntity.status(200).body(rutaService.findById(id));
    }

    @DeleteMapping("/api/v1/rutas/{id}")
    public ResponseEntity<?> deleteRuta(@PathVariable Integer id) {
        Ruta ruta = rutaService.findById(id);

        if (null == ruta) {
            return ResponseEntity.status(404).body("Ruta no encontrado");
        }

        rutaService.delete(id);

        return ResponseEntity.status(200).body("Ruta eliminado");
    }

    @PostMapping("/api/v1/rutas")
    public ResponseEntity<?> saveRuta(@RequestBody Ruta ruta) {
        Ruta rutaGuardado = rutaService.save(ruta);

        return ResponseEntity.status(201).body(rutaGuardado);
    }


}
