package com.example.caso.serviceimplements;

import com.example.caso.entities.Roles;
import com.example.caso.repositories.ITypeUserRepository;
import com.example.caso.repositories.IUserRepository;
import com.example.caso.servicesinterfaces.ITypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TypeUserServiceImplement implements ITypeUserService {
    @Autowired
    private ITypeUserRepository tR;

    private IUserRepository uR;
    @Override
    public void insert(Roles roles) {
        tR.save(roles);
    }

    @Override
    public List<Roles> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int idTypeUser) {
        tR.deleteById(idTypeUser);
    }

    @Override
    public List<String[]> cantidadUsuarioRol() {
        return tR.cantidadUsuarioRol();
    }

}
