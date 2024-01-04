package com.example.caso.controllers;

import com.example.caso.dtos.Motivo_ParadaDTO;
import com.example.caso.entities.Motivo_Parada;
import com.example.caso.servicesinterfaces.MotivosServiceInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("meza/motivos")
public class MotivoController {
    @Autowired
    private MotivosServiceInterfaces motivosServiceInterfaces;

    @PostMapping
    public void registrar(@RequestBody Motivo_ParadaDTO dto) {
        ModelMapper m = new ModelMapper();
        Motivo_Parada mp = m.map(dto, Motivo_Parada.class);
        motivosServiceInterfaces.insert(mp);
    }
    @GetMapping
    public List<Motivo_ParadaDTO> listar(){
        return motivosServiceInterfaces.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, Motivo_ParadaDTO.class);
        }).collect(Collectors.toList());
    }

    public void eliminar(@PathVariable ("id") Integer id){
        motivosServiceInterfaces.delete(id);
    }

}
