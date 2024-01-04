package com.example.caso.controllers;

import com.example.caso.dtos.OsDTO;
import com.example.caso.entities.OS;
import com.example.caso.servicesinterfaces.OsServiceInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
