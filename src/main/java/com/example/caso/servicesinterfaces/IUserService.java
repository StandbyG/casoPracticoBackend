package com.example.caso.servicesinterfaces;


import com.example.caso.entities.Useror;

import java.util.List;

public interface IUserService {
    public void insert(Useror user);
    public List<Useror>list();
    public void delete(int idUser);
    public Useror findByUserName(String userName);
    public Useror findById(int id);
    /*Set<Useror>*/
}
