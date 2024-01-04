package com.example.caso.servicesinterfaces;

import com.example.caso.entities.Motivo_Parada;

import java.util.List;

public interface MotivosServiceInterfaces {
    public void insert(Motivo_Parada motivoParada);
    public void delete(int Id_motivo);
    public List<Motivo_Parada> list();
}
