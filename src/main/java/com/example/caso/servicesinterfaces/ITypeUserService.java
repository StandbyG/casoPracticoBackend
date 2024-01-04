package com.example.caso.servicesinterfaces;

import com.example.caso.entities.Roles;

import java.util.List;

public interface ITypeUserService {
    public void insert(Roles roles);

    public List<Roles>list();
    public void delete(int idTypeUser);

    public List<String[]> cantidadUsuarioRol();
}
