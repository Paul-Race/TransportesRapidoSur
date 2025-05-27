package com.duoc.transportes.service;

import com.duoc.transportes.model.Persona;
import com.duoc.transportes.repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class PersonaService {

    @Autowired
    public PersonaRepository personaRepository;

    //traer todos los personas
    public List<Persona> findAll() {
        return personaRepository.findAll();
    };

    //traer un persona
    public Persona findById(Integer id) {
        return personaRepository.findById(id).orElse(null);
    }

    // Eliminar un persona
    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }


    //guardar un persona
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

}
