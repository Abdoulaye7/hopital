package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.Consultation;
import com.mycompany.hopital.dantec.entity.Medecin;
import com.mycompany.hopital.dantec.entity.Patient;
import com.mycompany.hopital.dantec.entity.Role;
import com.mycompany.hopital.dantec.service.ConsultationService;
import com.mycompany.hopital.dantec.service.RoleService;
import com.mycompany.hopital.dantec.service.UserService;

import java.util.Scanner;

public class RoleController {

  private RoleService roleService;

  public RoleController(){
      this.roleService=new RoleService();
  }

  public void enregistrerNouvelRole(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Nom du role ?");
      String role = scanner.nextLine();
      Role r = new Role();
      r.setName(role);
      roleService.createRole(r);


  }

  public void afficheDetailsRole(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant du role dont vous voulez afficher les informations");
      Long identifiant = scanner.nextLong();
      Role role  =roleService.getRole(identifiant);

      if(role!=null){
          System.out.println(role.getName());
      }else{
          System.out.println("Cet role n'existe pas !");
      }

  }
    public  void recupererRole(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir l'identifiant de le nom du role dont vous voulez afficher les informations");
        String roleName=scanner.nextLine();
        Role r = roleService.getRoleByName(roleName);
        if(r!=null){
            System.out.println(r.getName());
        }

    }


}
