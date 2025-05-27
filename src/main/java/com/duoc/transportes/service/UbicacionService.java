package com.duoc.transportes.service;

import com.duoc.transportes.model.Ubicacion;
import com.duoc.transportes.repository.UbicacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class UbicacionService {

    @Autowired
    public UbicacionRepository ubicacionRepository;

    //traer todos los ubicacions
    public List<Ubicacion> findAll() {
        return ubicacionRepository.findAll();
    };

    //traer un ubicacion
    public Ubicacion findById(Integer id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    // Eliminar un ubicacion
    public void delete(Integer id) {
        ubicacionRepository.deleteById(id);
    }


    //guardar un ubicacion
    public Ubicacion save(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

}
