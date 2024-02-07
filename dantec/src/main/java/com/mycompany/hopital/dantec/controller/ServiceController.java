package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.Service;
import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.ServiceMedecin;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import java.util.List;
import java.util.Scanner;

public class ServiceController {

  private ServiceMedecin serviceMedecin;

  public ServiceController(){
      serviceMedecin=new ServiceMedecin();
  }

  public void enregistrerNouveauService(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir le service du medecin");
      String nom = scanner.nextLine();
      Service service = new Service();
      service.setNom(nom);
      serviceMedecin.createService(service);

  }

    public void afficheDetailsService(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir l'identifiant du service dont vous voulez afficher les informations");
        int identifiant = scanner.nextInt();
        Service service = serviceMedecin.getService(identifiant);

        if(service!=null){
            System.out.println("Spécialité: "+service.getNom());
        }else{
            System.out.println("Cette spécialité n'existe pas !");
        }

    }

    public void listeDeToutesLesServices(){


        List<Service> services= serviceMedecin.getListeService();
        for (Service service: services){
            System.out.println(service);
        }
    }



}
