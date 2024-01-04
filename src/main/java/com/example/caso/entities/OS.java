package com.example.caso.entities;

import javax.persistence.*;

@Entity
@Table(name = "OS")
public class OS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Os;
    @Column(name = "Estate",nullable = false,length = 20)
    private String Estate;
    @Column(name = "typeOfJob",nullable = false,length = 20)
    private String typeOfJob;
    @OneToOne()
    @JoinColumn(name = "Id")
    private Useror grmpUser;

    public OS() {
    }

    public OS(int Id_Os, String estate, String typeOfJob, Useror grmpUser) {
        Id_Os = Id_Os;
        Estate = estate;
        this.typeOfJob = typeOfJob;
        this.grmpUser = grmpUser;
    }

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
