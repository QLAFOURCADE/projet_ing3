/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.Connexion;
import controleur.*;
import vue.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quiterie
 * abstract
 */
public class Hopital {
    
    /**
     * attributs de la classes
     * peut rajouter connexion ece à distance ????
     * protected : accés possible que pour les methodes dans classes + heritage
     */
    protected Connexion c_local;
    
    /**
     * Constructeur de la classe
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Hopital(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException
    {
        try {
            c_local = new Connexion(nameDatabase, loginDatabase, passwordDatabase);
            System.out.println("vous etes connecté");
        } catch (SQLException e) {
           throw new SQLException();
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();
        }
    }
    
    /**
     * METHODE : pour ajouter dans la BDD
     * @return 
     */
   // public abstract boolean insert();
    
    /**
     * METHODE : pour mettre à jour la BDD
     * @return 
     */
   // public abstract boolean update();
    
    /**
     * METHODE : pour trier dans la BDD; rechercher des inofrmations
     * @return 
     */
   // public abstract boolean select();
    
    /**
     * METHODE : pour supprimer dans la BDD
     * @return 
     */
   // public abstract boolean delete();
}
