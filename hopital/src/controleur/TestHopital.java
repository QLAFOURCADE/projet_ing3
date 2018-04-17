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
        Menu m= new Menu();

        /**
         * demande de rentrer les informations CONSOLE
         * recuperer les données tapées au clavier 
         */
        
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
        test_h = new TestHopital(nom_base, login, pass);
        //test_h = new TestHopital("hopital", "root", "");
    }
    
}
