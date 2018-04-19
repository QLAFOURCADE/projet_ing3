/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.sun.org.apache.xerces.internal.xs.StringList;
import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import vue.*;
import java.util.Scanner;
import modele.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author Quiterie
 * on sait aider du TP3 Labyrinthe : prendre exemple pour le systeme MVC et faire la connexion local
 */
public class TestHopital implements ActionListener {
    
    private static Hopital hopital;
    private static Console hop_cons;
    private static Graphique hop_g;
    
   // public static List<String> r = new ArrayList<>();
    
    
    public TestHopital()
    {
        hop_g.okay.addActionListener(this);
        for (JButton jButton : hop_g.button) {
            //option.add(jButton);
            jButton.addActionListener(this);
        }
    }
    
    
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
     * METHODE : permet de remplir toutes les arralyLists --> copie de la BDD dans le programme
     * @throws SQLException 
     */
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
     * METHODE : effectuer une action quand on appuie sur un bouton
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source==hop_g.okay){
            // Récupération des entrées de Connection
            String a= hop_g.bdd.getText();
            String l= hop_g.login.getText();
            String m= hop_g.mdp.getText();
            // Mise dans une liste envoie au controleur
            
            this.Control(a, l, m);
        }
    }
    

    /**
     * METHODE : vérifier et créer une connexion avec la bdd
     * @param a
     * @param b
     * @param c 
     */
    public void Control(String a, String b, String c){
        try {
            this.hopital = new Hopital(a, b, c);
            hop_g.suite = 1;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Mauvaise entrée!");
        }
        
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
        hop_g = new Graphique();
        hop_cons = new Console();
        
        TestHopital test_h;
        //test_h = new TestHopital(nom_base, login, pass);
            /// pour la copie de la bdd dans la classe 
        test_h = new TestHopital("hopital", "root", "");
        
        test_h.hop_g.setVisible(true);
        test_h.remplirClasses();
       
        //hopital.affichage_uneliste(hop_cons.menu());

    }
    
}
