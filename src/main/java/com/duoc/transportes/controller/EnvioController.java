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

    @GetMapping("/api/v1/envios/obtenerEstado/{id}")
    public ResponseEntity<?> obtenerEstadoEnvio(@PathVariable Integer id) {
        boolean esta_activo = envioService.ObtenerEstado(id);
        if (esta_activo) {
            return ResponseEntity.status(200).body("SIIIII Esta en camino!! 🚛");
        }
        return ResponseEntity.status(400).body("Su pedido esta entregadooo!!!!!📦");
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

    @PutMapping("/api/v1/envios/ConfirmaEntrega/{id}")
    public ResponseEntity<?> confirmaEntrega(@PathVariable Integer id) {
        Envio envioActualizado = envioService.finalizarEnvio(id);
        return ResponseEntity.status(201).body(envioActualizado);
    }

}
