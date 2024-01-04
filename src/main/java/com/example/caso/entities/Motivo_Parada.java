package com.example.caso.entities;

import javax.persistence.*;

@Entity
@Table(name = "Motivo_Parada")
public class Motivo_Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_motivo;

    @Column(name = "description",nullable = false,length = 100)
    private String description;
    @Column(name = "type",nullable = false,length = 20)
    private String type;
    @ManyToOne()
    @JoinColumn(name = "Id_Os")
    private OS Os;

    public Motivo_Parada() {
    }

    public Motivo_Parada(int Id_motivo, String description, String type, OS os) {
        Id_motivo = Id_motivo;
        this.description = description;
        this.type = type;
        Os = os;
    }

    public int getId() {
        return Id_motivo;
    }

    public void setId(int id) {
        Id_motivo = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OS getOs() {
        return Os;
    }

    public void setOs(OS os) {
        Os = os;
    }
}
