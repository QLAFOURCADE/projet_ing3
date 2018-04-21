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
public class Reporting {
    
    public static Connexion c;
    
    /**
     * CONSTRUCTEUR 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Reporting() throws SQLException, ClassNotFoundException
    {
        Reporting.c = new Connexion("hopital", "root", "");
    }
}
