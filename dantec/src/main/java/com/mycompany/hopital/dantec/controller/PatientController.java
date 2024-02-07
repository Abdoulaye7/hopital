package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.PatientService;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import java.util.Scanner;

public class PatientController {

  private PatientService patientService;

  public PatientController(){
      patientService=new PatientService();
  }

  public void enregistrerNouveauPatient(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir le code du patient");
      String code = scanner.nextLine();
      System.out.println("Saisir la naissance du patient");
      short naissance = scanner.nextShort();
      scanner.nextLine();
      System.out.println("Saisir le nom du patient");
      String nom = scanner.nextLine();
      System.out.println("Saisir le prenom du patient");
      String prenom = scanner.nextLine();


      Patient patient = new Patient();
      patient.setCode(code);
      patient.setDateNaissance(naissance);
      patient.setNom(nom);
      patient.setPrenom(prenom);
      patientService.createPatient(patient);


  }

  public void afficheDetailsPatient(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant du patient dont vous voulez afficher les informations");
      int identifiant = scanner.nextInt();
      Patient patient = patientService.getPatient(identifiant);

      if(patient!=null){
          /*System.out.println("Code: "+patient.getCode());
          System.out.println("Nom: "+patient.getNom());*/
          System.out.println(patient);
      }else{
          System.out.println("Cet patient n'existe pas !");
      }

  }


}
