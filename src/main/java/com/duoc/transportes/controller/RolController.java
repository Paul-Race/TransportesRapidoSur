package com.duoc.transportes.controller;

import com.duoc.transportes.model.Rol;
import com.duoc.transportes.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private RolService rolService;

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/roles")
    public ResponseEntity<?> getRols() {
        return ResponseEntity.status(200).body(rolService.findAll());
    }

    @GetMapping("/api/v1/roles/{id}")
    public ResponseEntity<?> getRol(@PathVariable Integer id) {
        Rol rol = rolService.findById(id);

        if (null == rol) {
            return ResponseEntity.status(404).body("Rol no encontrado");
        }

        return ResponseEntity.status(200).body(rolService.findById(id));
    }

    @DeleteMapping("/api/v1/roles/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Integer id) {
        Rol rol = rolService.findById(id);

        if (null == rol) {
            return ResponseEntity.status(404).body("Rol no encontrado");
        }

        rolService.delete(id);

        return ResponseEntity.status(200).body("Rol eliminado");
    }

    @PostMapping("/api/v1/roles")
    public ResponseEntity<?> saveRol(@RequestBody Rol rol) {
        Rol rolGuardado = rolService.save(rol);

        return ResponseEntity.status(201).body(rolGuardado);
    }


}
