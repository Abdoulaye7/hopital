package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.service.ConsultationService;
import com.mycompany.hopital.dantec.service.MedecinService;

import java.util.Scanner;

public class ConsultationController {

  private ConsultationService consultationService;

  public ConsultationController(){
      consultationService=new ConsultationService();
  }

  public void enregistrerNouvelleConsultation(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Quelle est la date de consultation ?");
      short date = scanner.nextShort();
      scanner.nextLine();
      System.out.println("Quelle est la prescription ?");
      String prescription = scanner.nextLine();
      System.out.println("Quelle est  la remarque");
      String remarque = scanner.nextLine();
      System.out.println("Quel est l'identifiant du patient");
      int patient_id = scanner.nextInt();
      System.out.println("Saisir l'identifiant du service du médecin : ");
      Long medecin_id = scanner.nextLong();

      Consultation consultation = new Consultation();
      consultation.setDate(date);
      consultation.setPrescription(prescription);
      consultation.setRemarque(remarque);

      Patient patient = new Patient();
      patient.setId(patient_id);
      Medecin medecin = new Medecin();
      medecin.setId(medecin_id);
     consultation.setPatient(patient);
     consultation.setMedecin(medecin);
     consultationService.createConsultation(consultation);



  }

  public void afficheDetailsConsultation(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant du patient dont vous voulez afficher les informations");
      Long identifiant = scanner.nextLong();
      Consultation consultation  =consultationService.getConsultation(identifiant);

      if(consultation!=null){
          System.out.println(consultation);
      }else{
          System.out.println("Cette spécialité n'existe pas !");
      }

  }


}
