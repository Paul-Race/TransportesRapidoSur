package com.duoc.transportes.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class UbicacionExternaService {

    public String servicioEmulado(){
        return "{ 'latitud': -965768, 'longitud': -9685768 }";
    }

    //traer todos los personas
    public String obtenerUbicacion() {
        return servicioEmulado();
    };


}
