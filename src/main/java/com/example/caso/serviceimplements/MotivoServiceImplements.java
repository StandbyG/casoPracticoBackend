package com.example.caso.serviceimplements;

import com.example.caso.entities.Motivo_Parada;
import com.example.caso.repositories.MotivoRepository;
import com.example.caso.servicesinterfaces.MotivosServiceInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivoServiceImplements implements MotivosServiceInterfaces {

    @Autowired
    private MotivoRepository motivoRepository;
    @Override
    public void insert(Motivo_Parada motivoParada) {
        motivoRepository.save(motivoParada);
    }

    @Override
    public void delete(int Id_motivo) {
        motivoRepository.deleteById(Id_motivo);
    }

    @Override
    public List<Motivo_Parada> list() {
        return motivoRepository.findAll();
    }
}
