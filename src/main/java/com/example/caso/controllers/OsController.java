package com.example.caso.controllers;

import com.example.caso.dtos.OsDTO;
import com.example.caso.entities.OS;
import com.example.caso.servicesinterfaces.OsServiceInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/meza/Os")
public class OsController {
    @Autowired
    private OsServiceInterfaces grmpeS;

    @PostMapping
    public void registrar(@RequestBody OsDTO grmpDto) {
        ModelMapper grmpM = new ModelMapper();
        OS grmpE = grmpM.map(grmpDto, OS.class);
        grmpeS.insert(grmpE);
    }

    @GetMapping("/lista")
    public List<OsDTO> listar(){
        return grmpeS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,OsDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/update")
    public void modificar(@RequestBody OsDTO dto){
        ModelMapper m = new ModelMapper();
        OS os =m.map(dto,OS.class);
        grmpeS.insert(os);
    }
}
