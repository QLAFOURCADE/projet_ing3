/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

// importation de toute les classes du packages Modele + fonction java.sql utilisé par la classe connexion
import java.sql.*;
import modele.*;
import java.util.Scanner;

/**
 *
 * @author Quiterie
 */
public class Console {
    
    /**
     * attributs de la classe
     */
    Scanner clavier = new Scanner(System.in);
    
    /**
     * Pour créer une variable avec les éléments tapers au clavier 
     * @return h
     */
    @Override
    public String toString()
    {
        String h;
        h = clavier.nextLine();
        return h;
    }
    
    /**
     * menu pour demander sur quelle table effectuer des modifiations + l'afficher
     * @return entree
     */
    public char menu() {

        String entree;
        System.out.println("1 Chambre");
        System.out.println("2 Docteur");
        System.out.println("3 Employe");
        ///////////System.out.println("4 Hospitalisation");
        System.out.println("5 Infirmier");
        System.out.println("6 Malade");
        System.out.println("7 Service");
        ////////////System.out.println("8 Soigne");
        System.out.println("0 Quitter");

        Scanner c = new Scanner(System.in);
        System.out.println("Entrez votre choix :");
        entree = c.next();

        // renvoie le numero choisit : premier caractère des lignes affichées
        return entree.charAt(0);
    }
}
