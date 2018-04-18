/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.*;
import java.util.Scanner;
import modele.*;
import java.sql.*;


/**
 *
 * @author Quiterie
 * on sait aider du TP3 Labyrinthe : prendre exemple pour le systeme MVC et faire la connexion local
 */
public class TestHopital {
    
    private static Hopital hopital;
    private static Console hop_cons;
    
    /**
     * Constructeur de la classe
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public TestHopital(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException
    {
        hopital = new Hopital(nameDatabase, loginDatabase, passwordDatabase);
    }

    public void remplirClasses() throws SQLException
    {
        /**
         * remplissage des arraylists présente dans la classe hopital
         */
        // remplir et afficher la liste de malade
        hopital.remplir_malade();
        hopital.remplir_employe();
        hopital.remplir_docteur();
        // obliger de faire deux fois service pour avoir toutes les attributs des objets remplis
        //hopital.remplir_service();
        hopital.remplir_infirmier();
        hopital.remplir_chambre();
        hopital.remplir_service();
    }
    
    /**
     * @param args the command line arguments
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        
        /**
         * initialisation 
         */
        hop_cons = new Console();

        /**
         * demande de rentrer les informations CONSOLE
         * recuperer les données tapées au clavier 
         */
        /**
        System.out.println("Nom de la base :");
        String nom_base = hop_cons.toString();
        
        System.out.println("Login :");
        String login = hop_cons.toString();
        
        System.out.println("Password :");
        String pass = hop_cons.toString();
        
        /**
         * creation de la connexion après verifiation
         */
        
        TestHopital test_h;
        //test_h = new TestHopital(nom_base, login, pass);
        test_h = new TestHopital("hopital", "root", "");
        
        test_h.remplirClasses();
        hopital.affichage_uneliste(hop_cons.menu());
    }
    
}
