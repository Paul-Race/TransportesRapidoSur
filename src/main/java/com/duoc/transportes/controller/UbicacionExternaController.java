package com.duoc.transportes.controller;

import com.duoc.transportes.service.UbicacionExternaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UbicacionExternaController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private UbicacionExternaService ubicacionExternaService;

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/ubicacionExterna")
    public ResponseEntity<?> getUbicacionExterna() {
        return ResponseEntity.status(200).body(ubicacionExternaService.obtenerUbicacion());
    }

}
