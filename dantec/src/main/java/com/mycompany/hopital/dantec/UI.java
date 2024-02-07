package com.mycompany.hopital.dantec;

import com.mycompany.hopital.dantec.controller.*;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Specialite;

import java.util.Scanner;

public class UI {


    public static void main(String ...args) {

      ServiceController controller = new ServiceController();
      controller.listeDeToutesLesServices();
       /* Scanner scanner = new Scanner(System.in);
        boolean doExist=false;
         specialiteController = new SpecialiteController();
         serviceController = new ServiceController();
         patientController = new PatientController();
         medecinController= new MedecinController();
        menu();
        do {

            System.out.println("Faites votre choix");
            int choix = scanner.nextInt();
            switch (choix){

                case 1:
                        specialiteController.enregistrerNouveauSpecialite();
                 break;

                case 2:
                        serviceController.enregistrerNouveauService();
                 break;

                case 3:
                         patientController.enregistrerNouveauPatient();
                 break;

                case 4:   medecinController.enregistrerNouveauMedecin();
                break;

                case 5:
                        specialiteController.afficheDetailsSpecialite();
                 break;
                case 6:
                         serviceController.afficheDetailsService();

                 break;
                case 7:
                      patientController.afficheDetailsPatient();
                 break;

                case 8: medecinController.afficheDetailsMedecin();
                break;

                case 9:
                    doExist=true;
                 break;

            }

        }while (doExist==false);

    }
    public static void menu(){
        System.out.println("Menu gestion hopital");
        System.out.println("1:Ajouter une nouvelle specialite ");
        System.out.println("2:Ajouter un nouveau service");
        System.out.println("3:Ajout un nouveau patient");
        System.out.println("4:Ajouter un nouveua médecin");
        System.out.println("5:Afficher Information spécialité");
        System.out.println("6:Afficher Information service");
        System.out.println("7:Afficher les informations du patient");
        System.out.println("8:Afficher les informations du médecin");
        System.out.println("9:quitter");
    }*/
    }
}
