/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;
import modele.Chambre;
//import DAO.DAO;
//import DAO.ChambreDAO;
import DAO.*;

/**
 *
 * @author Pierre-Louis
 */
public class FirstTest { 
  public static void main(String[] args) {
    //Testons des élèves
    DAO<Chambre> chambreDao = new ChambreDAO(Connexion.getInstance());
    for(int i = 101; i < 105; i++){
      Chambre chambre = chambreDao.find(i);
      System.out.println("Chambre N°" + chambre.getNum_ch() + "  - " + chambre.getNb_lits());
    }
      
    System.out.println("\n********************************\n");
      
    
}
}