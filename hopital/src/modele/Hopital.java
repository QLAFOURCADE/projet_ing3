/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.*;
import vue.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quiterie
 */
public class Hopital {
    
    /**
     * attributs de la classes
     * peut rajouter connexion ece à distance ????
     * mettre peut etre toute les classes des tables ????
     */
    private Connexion c_local;
    
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
}
