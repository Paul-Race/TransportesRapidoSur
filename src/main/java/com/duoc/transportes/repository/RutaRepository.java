package com.duoc.transportes.repository;

import com.duoc.transportes.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {
    List<Ruta> findByRepartidorId(Integer repartidorId);
}