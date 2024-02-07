package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.Specialite;
import com.mycompany.hopital.dantec.service.SpecialiteService;

import java.util.List;
import java.util.Scanner;

public class SpecialiteController {

  private   SpecialiteService specialiteService;

  public  SpecialiteController(){
      specialiteService=new SpecialiteService();
  }

  public void enregistrerNouveauSpecialite(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir le nom de la spécialité du medecin");
      String nom = scanner.nextLine();
      Specialite specialite = new Specialite();
      specialite.setNom(nom);
      specialiteService.createSpecialite(specialite);

  }

  public void afficheDetailsSpecialite(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant de la spécialité dont vous voulez afficher les informations");
      int identifiant = scanner.nextInt();
      Specialite specialite = specialiteService.getSpecialite(identifiant);

      if(specialite!=null){
          System.out.println("Spécialité: "+specialite.getNom());
      }else{
          System.out.println("Cette spécialité n'existe pas !");
      }

  }

  public void supprimerSpecialite(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant de la spécialité à supprimer");
      int identifiant = scanner.nextInt();
       specialiteService.deleteSpecialite(identifiant);

  }
  public  void renommerSpecialite(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant de la spécialité à renommer");
      int identifiant = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Saisir le nom de la nouvelle spécialité ");
      String libelle = scanner.nextLine();
       specialiteService.renomme(identifiant,libelle);

  }

  public void listeDeToutesLesSpecialites(){


    List<Specialite> specialites= specialiteService.getListeSpecialite();
    for (Specialite specialite: specialites){
        System.out.println(specialite);
    }
  }
    public void listeDeToutesLesSpecialitesParId(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir l'identifiant de la spécialité à afficher");
        int identifiant = scanner.nextInt();

        List<Specialite> specialites= specialiteService.getListeSpecialiteParId(identifiant);
        for (Specialite specialite: specialites){
            System.out.println(specialite);
        }
    }


}
