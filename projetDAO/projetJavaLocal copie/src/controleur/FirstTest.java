/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import modele.*;
import DAO.*;

/**
 *
 * @author Pierre-Louis
 */
public class FirstTest { 
  public static void main(String[] args) {
     
    /*
    //Testons des chambres
    DAO<Chambre> chambreDao = new ChambreDAO(Connexion.getInstance());
    for(int i = 101; i < 105; i++){
      Chambre chambre = chambreDao.find(i);
      System.out.println("Chambre N°" + chambre.getNum_ch() + "  - " + chambre.getNb_lits()+ "  - " + chambre.getCodeService());
    }
      
    System.out.println("\n********************************\n");
    */
    
    /*
     //Testons des docteurs
    DAO<Docteur> docteurDao = new DocteurDAO(Connexion.getInstance());
    for(int i = 88; i < 90; i++){
      Docteur docteur = docteurDao.find(i);
      System.out.println("Docteur N°" + docteur.getNumero() + "  - " + docteur.getSpecialite());
    }
      
    System.out.println("\n********************************\n");
    */
   /*
   //Inserer une nouvelle chambre
   DAO<Chambre> chambreDao2 = new ChambreDAO(Connexion.getInstance());
        String a="REA";
        Chambre c = new Chambre(a, 12, 22, 2);
        chambreDao2.create(c);
        System.out.println("La chambre suivante a été ajouté à la BDD " + c.toString());
   
   */
   
   /*
   //Supprimer une chambre
   DAO<Chambre> chambreDao2 = new ChambreDAO(Connexion.getInstance());
        String a="REA";
        Chambre c = new Chambre(a, 12, 22, 2);
        chambreDao2.delete(c);
        System.out.println("La chambre suivante a été supprimée de la BDD " + c.toString());
    */
    
    /*
    //Inserer un nouveau docteur
   DAO<Docteur> docteurDao2 = new DocteurDAO(Connexion.getInstance());
        String b="Ornitologue";
        Docteur d = new Docteur(18, b);
        docteurDao2.create(d);    
    */
    
     
    /*
    //Testons des Employés 53 et 54
    DAO<Employe> employeDao = new EmployeDAO(Connexion.getInstance());
    for(int i = 53; i < 55; i++){
      Employe employe = employeDao.find(i);
      System.out.println("Employe N°" + employe.getNumero() + "  -  Nom : " + employe.getNom() + "  -  Prenom : " + employe.getPrenom());
    }
      
    System.out.println("\n********************************\n");
    */
    
    
    /*
     //Testons des Infirmiers 10 et 131
      DAO<Infirmier> infirmierDao = new InfirmierDAO(Connexion.getInstance());
    for(int i = 130; i < 132; i++){
      Infirmier infirmier = infirmierDao.find(i);
      System.out.println("Infirmier N°" + infirmier.getNumero() + "  -  Code Service : " + infirmier.getCodeService() + "  -  Rotation : " + infirmier.getRotation());
    }
      
    System.out.println("\n********************************\n");
    */
    
    
     //Testons des Malades 13 et 14
      DAO<Malade> maladeDao = new MaladeDAO(Connexion.getInstance());
    for(int i = 13; i < 15; i++){
      Malade malade = maladeDao.find(i);
      System.out.println("Malade N°" + malade.getNumero() + "  -  Nom : " + malade.getNom() + "  -  Prenom : " + malade.getPrenom());
    }
      
    System.out.println("\n********************************\n");
    
    
    
    
}
}