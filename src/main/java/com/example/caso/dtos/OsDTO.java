package com.example.caso.dtos;

import com.example.caso.entities.Useror;

public class OsDTO {

    private int Id_Os;

    private String Estate;

    private String typeOfJob;

    private Useror grmpUser;

    public int getId() {
        return Id_Os;
    }

    public void setId(int id) {
        Id_Os = id;
    }

    public String getEstate() {
        return Estate;
    }

    public void setEstate(String estate) {
        Estate = estate;
    }

    public String getTypeOfJob() {
        return typeOfJob;
    }

    public void setTypeOfJob(String typeOfJob) {
        this.typeOfJob = typeOfJob;
    }

    public Useror getGrmpUser() {
        return grmpUser;
    }

    public void setGrmpUser(Useror grmpUser) {
        this.grmpUser = grmpUser;
    }
}
