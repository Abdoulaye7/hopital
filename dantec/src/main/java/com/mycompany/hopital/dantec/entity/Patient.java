package com.mycompany.hopital.dantec.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code_patient",unique = true,nullable = false,length = 6)
    private String code;
    @Column(name = "nom",nullable = false)
    private String nom ;
    private  String prenom;
    @Column(name = "naissance",length = 6,nullable = false)
    private Short dateNaissance;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Short getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Short dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
