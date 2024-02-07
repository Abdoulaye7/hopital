package com.mycompany.hopital.dantec.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specialite")
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "libelle",nullable = false,length = 150)
    private String nom;

    @ManyToMany(mappedBy = "specialites")
    private Set<Medecin> medecins;


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

    public Set<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(Set<Medecin> medecins) {
        this.medecins = medecins;
    }

    @Override
    public String toString() {
        return "Specialite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +

                '}';
    }
}
