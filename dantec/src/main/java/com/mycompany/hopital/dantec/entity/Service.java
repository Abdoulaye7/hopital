package com.mycompany.hopital.dantec.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "libelle", nullable = false, length = 150)
    private String nom;

    @OneToMany(mappedBy = "service")
    private List<Medecin> medecins = new ArrayList<Medecin>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", libelle='" + nom + '\'' +
                '}';
    }

}
