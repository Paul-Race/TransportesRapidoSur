package com.duoc.transportes.controller;

import com.duoc.transportes.model.Ubicacion;
import com.duoc.transportes.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UbicacionController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private UbicacionService ubicacionService;

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/ubicaciones")
    public ResponseEntity<?> getUbicacions() {
        return ResponseEntity.status(200).body(ubicacionService.findAll());
    }

    @GetMapping("/api/v1/ubicaciones/{id}")
    public ResponseEntity<?> getUbicacion(@PathVariable Integer id) {
        Ubicacion ubicacion = ubicacionService.findById(id);

        if (null == ubicacion) {
            return ResponseEntity.status(404).body("Ubicacion no encontrado");
        }

        return ResponseEntity.status(200).body(ubicacionService.findById(id));
    }

    @DeleteMapping("/api/v1/ubicaciones/{id}")
    public ResponseEntity<?> deleteUbicacion(@PathVariable Integer id) {
        Ubicacion ubicacion = ubicacionService.findById(id);

        if (null == ubicacion) {
            return ResponseEntity.status(404).body("Ubicacion no encontrado");
        }

        ubicacionService.delete(id);

        return ResponseEntity.status(200).body("Ubicacion eliminado");
    }

    @PostMapping("/api/v1/ubicaciones")
    public ResponseEntity<?> saveUbicacion(@RequestBody Ubicacion ubicacion) {
        Ubicacion ubicacionGuardado = ubicacionService.save(ubicacion);

        return ResponseEntity.status(201).body(ubicacionGuardado);
    }


}
