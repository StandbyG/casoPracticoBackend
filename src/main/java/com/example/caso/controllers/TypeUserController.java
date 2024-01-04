package com.example.caso.controllers;

import com.example.caso.dtos.RolesDTO;
import com.example.caso.entities.Roles;
import com.example.caso.servicesinterfaces.ITypeUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/typeusers")
public class TypeUserController {
    @Autowired
    private ITypeUserService tS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody RolesDTO dto){
        ModelMapper m = new ModelMapper();
        Roles t = m.map(dto, Roles.class);
        tS.insert(t);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('WEB')")
    public List<RolesDTO> listar(){
        return tS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }

}
