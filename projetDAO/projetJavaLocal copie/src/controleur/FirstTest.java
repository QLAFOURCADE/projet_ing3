/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import modele.*;
//import DAO.DAO;
//import DAO.ChambreDAO;
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
      System.out.println("Chambre N°" + chambre.getNum_ch() + "  - " + chambre.getNb_lits());
    }
      
    System.out.println("\n********************************\n");
    */ 
     //Testons des docteurs
    DAO<Docteur> docteurDao = new DocteurDAO(Connexion.getInstance());
    for(int i = 88; i < 90; i++){
      Docteur docteur = docteurDao.find(i);
      System.out.println("Docteur N°" + docteur.getNumero() + "  - " + docteur.getSpecialite());
    }
      
    System.out.println("\n********************************\n");
    
    
   //Inserer une nouvelle chambre
   DAO<Chambre> chambreDao = new ChambreDAO(Connexion.getInstance());
        String a="REA";
        Chambre c = new Chambre(a, 110, 22, 2);
        chambreDao.create(c);
    
}
}