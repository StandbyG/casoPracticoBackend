package com.example.caso.serviceimplements;

import com.example.caso.entities.OS;
import com.example.caso.repositories.OsRepository;
import com.example.caso.servicesinterfaces.OsServiceInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OsServiceImplements implements OsServiceInterfaces {
    @Autowired
    private OsRepository grmpeR;
    @Override
    public void insert(OS OS) {
        grmpeR.save(OS);
    }

    @Override
    public List<OS> list() {
        return grmpeR.findAll();
    }


}
