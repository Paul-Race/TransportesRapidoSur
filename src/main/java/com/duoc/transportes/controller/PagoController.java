package com.duoc.transportes.controller;

import com.duoc.transportes.model.Pago;
import com.duoc.transportes.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagoController {

    //"El cable" Inyeccion de dependencias
    @Autowired
    private PagoService pagoService;

    @GetMapping("/api/v1/pago/{id}")
    public ResponseEntity<?> getPago(@PathVariable Integer id) {
        Pago pago = pagoService.findById(id);

        if (null == pago) {
            return ResponseEntity.status(404).body("Pago no encontrado");
        }

        return ResponseEntity.status(200).body(pagoService.findById(id));
    }

    @PostMapping("/api/v1/pago")
    public ResponseEntity<?> savePago(@RequestBody Pago pago) {
        Pago pagoGuardado = pagoService.save(pago);

        return ResponseEntity.status(201).body(pagoGuardado);
    }


}
