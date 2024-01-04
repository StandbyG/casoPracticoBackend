package com.example.caso.servicesinterfaces;

import com.example.caso.entities.OS;

import java.util.List;

public interface OsServiceInterfaces {
    public void insert(OS OS);
    public List<OS>list();

    public void update(int os);
}
