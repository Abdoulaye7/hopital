package com.mycompany.hopital.dantec.controller;

import com.mycompany.hopital.dantec.entity.*;
import com.mycompany.hopital.dantec.service.ConsultationService;
import com.mycompany.hopital.dantec.service.UserService;

import java.util.Scanner;

public class UserController {

  private UserService userService;

  public UserController(){
      userService=new UserService();
  }

  public void enregistrerNouveauUtilisateur(){
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'email l'utilisateur ?");
        String email = scanner.nextLine();
        User existingUser = userService.getUserByEmail(email);

        if (existingUser != null) {
            System.out.println("Un utilisateur avec cet email existe déjà.");
        } else {

            System.out.println("Quel est le mot de passe de l'utilisateur ?");
            String password = scanner.nextLine();

            User user = new User();
            user.setUsername(email);
            user.setPassword(password);

           // Role adminRole = userService.getRoleByName("admin");

            userService.createUser(user);
            //userService.assignRole(user, adminRole);
            System.out.println("Utilisateur créé avec succès !");
          }

        } catch(Exception e){
            System.out.println("Erreur lors de la création de l'utilisateur : " + e.getMessage());
        }


  }

  public void afficheDetailsUser(){

      Scanner scanner = new Scanner(System.in);
      System.out.println("Saisir l'identifiant de l'utilisateur dont vous voulez afficher les informations");
      Long identifiant = scanner.nextLong();
      User user  =userService.getUser(identifiant);

      if(user!=null){
          System.out.println(user.getUsername()+" "+user.getPassword());
      }else{
          System.out.println("Cet utilisateur n'existe pas !");
      }

  }


}
