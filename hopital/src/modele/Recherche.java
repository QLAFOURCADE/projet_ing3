/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Quiterie
 */
public class Recherche {
    
    public static Connexion c; 
    
    /**
     * CONSTRUCTEUR
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Recherche() throws SQLException, ClassNotFoundException
    {
        Recherche.c = new Connexion("hopital", "root", "");
    }
    
    
            
}
