package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.MedecinService;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import java.util.List;
import java.util.Scanner;

public class MedecinController {

  private MedecinService medecinService;

  public MedecinController(){
      medecinService=new MedecinService();
  }

  public void enregistrerNouveauMedecin(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Quel est la naissance du medecin");
      short naissance = scanner.nextShort();
      scanner.nextLine();
      System.out.println("Quel est le matricule du medecin");
      String mat = scanner.nextLine();
      System.out.println("Quel est le nom du medecin");
      String nom = scanner.nextLine();
      System.out.println("Quel est le prenom du medecin");
      String prenom = scanner.nextLine();
      System.out.println("Saisir l'identifiant du service du médecin : ");
      int serviceId = scanner.nextInt();

      Medecin medecin = new Medecin();
      medecin.setDateNaissance(naissance);
      medecin.setMatricule(mat);
      medecin.setNom(nom);
      medecin.setPrenom(prenom);

      Service service = new Service();
      service.setId(serviceId);
      medecin.setService(service);
      medecinService.createMedecin(medecin);


  }

  public void afficheDetailsMedecin(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant du médecin dont vous voulez afficher les informations");
      Long identifiant = scanner.nextLong();
      Medecin medecin = medecinService.getMedecin(identifiant);

      if(medecin!=null){
          System.out.println("Matricule: "+medecin.getMatricule());
          System.out.println("NOM :"+medecin.getNom()+" "+medecin.getPrenom());
          System.out.println("Service: "+medecin.getService());
      }else{
          System.out.println("Cette spécialité n'existe pas !");
      }

  }

    public void supprimerMedecin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir l'identifiant du médecin à supprimer");
        Long identifiant = scanner.nextLong();
        medecinService.deleteMedecin(identifiant);

    }


    public void listeDeToutesLesMedecins(){


        List<Medecin> medecins= medecinService.getListeMedecin();
        for (Medecin medecin: medecins){
            System.out.println(medecin);
        }
    }
    public void listeDeToutesLesMedecinsParMat(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le matricule du médecin ");
        String mat = scanner.nextLine();

        List<Medecin> medecins= medecinService.getListeMedecinParMat(mat);
        for (Medecin medecin: medecins){
            System.out.println(medecin);
        }
    }


}
