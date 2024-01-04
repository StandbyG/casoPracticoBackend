package com.example.caso.repositories;

import com.example.caso.entities.Motivo_Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoRepository extends JpaRepository<Motivo_Parada,Integer> {
}
