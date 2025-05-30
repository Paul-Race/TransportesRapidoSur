package com.duoc.transportes.service;

import com.duoc.transportes.model.Envio;
import com.duoc.transportes.repository.EnvioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class EnvioService {

    @Autowired
    public EnvioRepository envioRepository;

    //traer todos los envios
    public List<Envio> findAll() {
        return envioRepository.findAll();
    };

    //traer un envio
    public Envio findById(Integer id) {
        return envioRepository.findById(id).orElse(null);
    }

    // Eliminar un envio
    public void delete(Integer id) {
        envioRepository.deleteById(id);
    }


    //guardar un envio
    public Envio save(Envio envio) {
        return envioRepository.save(envio);
    }

    public List<Envio> asignarEnvios(Integer rutaId){
        List<Envio> envios = envioRepository.findAll();
        for (Envio envio : envios) {
            envio.setRutaId(rutaId);
        }
        return envios;
    }

    public boolean ObtenerEstado(Integer id){
        Envio envio = envioRepository.findById(id).orElse(null);
        if(envio == null){
            return false;
        }
        return envio.active;
    }

    // Ejecuta cambios
    public Envio finalizarEnvio(Integer id) {
        Envio envioBbdd = envioRepository.findById(id).orElse(null);
        envioBbdd.active = false;
        return envioRepository.save(envioBbdd);
    }
}
