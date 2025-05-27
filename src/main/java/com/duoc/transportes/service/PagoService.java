package com.duoc.transportes.service;

import com.duoc.transportes.model.Pago;
import com.duoc.transportes.repository.PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Aqui va la logica de negocio
@Service
@Transactional
public class PagoService {

    @Autowired
    public PagoRepository pagoRepository;

    //traer todos los pagos
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    };

    //traer un pago
    public Pago findById(Integer id) {
        return pagoRepository.findById(id).orElse(null);
    }

    // Eliminar un pago
    public void delete(Integer id) {
        pagoRepository.deleteById(id);
    }


    //guardar un pago
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

}
