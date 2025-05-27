package com.duoc.transportes.service;

import com.duoc.transportes.model.Ruta;
import com.duoc.transportes.repository.RutaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class RutaService {

    @Autowired
    public RutaRepository rutaRepository;

    //traer todos los rutas
    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    };

    //traer un ruta
    public Ruta findById(Integer id) {
        return rutaRepository.findById(id).orElse(null);
    }

    // Eliminar un ruta
    public void delete(Integer id) {
        rutaRepository.deleteById(id);
    }


    //guardar un ruta
    public Ruta save(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

}
