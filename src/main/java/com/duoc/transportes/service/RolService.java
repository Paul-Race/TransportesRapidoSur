package com.duoc.transportes.service;

import com.duoc.transportes.model.Rol;
import com.duoc.transportes.repository.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class RolService {

    @Autowired
    public RolRepository rolRepository;

    //traer todos los rols
    public List<Rol> findAll() {
        return rolRepository.findAll();
    };

    //traer un rol
    public Rol findById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    // Eliminar un rol
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }


    //guardar un rol
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

}
