package com.duoc.transportes.controller;

import com.duoc.transportes.model.Persona;
import com.duoc.transportes.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private PersonaService personaService;

    //ResponseEntity Transforma a JSON tiene un serializer dentro
    @GetMapping("/api/v1/personas")
    public ResponseEntity<?> getPersonas() {
        return ResponseEntity.status(200).body(personaService.findAll());
    }

    @GetMapping("/api/v1/personas/{id}")
    public ResponseEntity<?> getPersona(@PathVariable Integer id) {
        Persona persona = personaService.findById(id);

        if (null == persona) {
            return ResponseEntity.status(404).body("Persona no encontrado");
        }

        return ResponseEntity.status(200).body(personaService.findById(id));
    }

    @DeleteMapping("/api/v1/personas/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Integer id) {
        Persona persona = personaService.findById(id);

        if (null == persona) {
            return ResponseEntity.status(404).body("Persona no encontrado");
        }

        personaService.delete(id);

        return ResponseEntity.status(200).body("Persona eliminado");
    }

    @PostMapping("/api/v1/personas")
    public ResponseEntity<?> savePersona(@RequestBody Persona persona) {
        Persona personaGuardado = personaService.save(persona);

        return ResponseEntity.status(201).body(personaGuardado);
    }


}
