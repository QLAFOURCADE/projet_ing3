/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
/*********************************************************************************************************************************************
 * **************************************************************************************************************************************
 *                                      PROJET ING 3 2018 - PROMO 2020
 *                                  Gestion informatique d'un centre hospitalier
 ***************************************************************************************************************************************************                                  
 ************************************************************************************************************************************************
 *                                      NOS AIDES POUR LE PROJET
 * http://sql.sh/cours/insert-into
 * toutes les pages de openclassrooms sur le java : https://openclassrooms.com/courses/apprenez-a-programmer-en-java/
 * tous les documents d'aide sur campus projet et cours java : http://campus.ece.fr/course/view.php?id=1911
 * plusieurs chapitres sur le graphisme sur ce site : https://www.jmdoudoux.fr/java/dej/indexavecframes.htm
 * les aide dans JBDC de M.Segado 
 */
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    
    /**
     * CONSTRUCTEUR : de la classe
     *              on implémente ici l'action des boutons 
     */
    public TestHopital()
    {
        // JButtons de menu principal 
        hop_g.okay.addActionListener(this);
        
        // JButtons du menu options
        hop_g.consulter.addActionListener(this);
        hop_g.recherche.addActionListener(this);
        hop_g.supprimer.addActionListener(this);
        hop_g.ajouter.addActionListener(this);
        hop_g.maj.addActionListener(this);
        hop_g.reporting.addActionListener(this);
        
        // JButtons de la page ajouter
        hop_g.ok_ajouter.addActionListener(this);
        hop_g.retour_m_choix.addActionListener(this);
 
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
        
        // pour le bouton valider du menu connexion 
        if(source==hop_g.okay){
            // Récupération des entrées de Connection
            String a= hop_g.bdd.getText();
            String l= hop_g.login.getText();
            String m= hop_g.mdp.getText();
            try {
                // mettre à jour la "copie" de la bdd présente dans notre programme 
                this.remplirClasses();
            } catch (SQLException ex){}
            this.Control(a, l, m);
        }
        
        // pour les boutons du menu des options 
        if (source == hop_g.consulter)
        {
            System.out.println("Consulter les tables ");
        }
        if (source == hop_g.recherche)
        {
            System.out.println("Effectuer une recherche");
        }
        if (source == hop_g.supprimer)
        {
            System.out.println("Supprimer quelqu'un");
            
        }
        if (source == hop_g.ajouter)
        {
            System.out.println("Ajouter quelqu'un");
            TestHopital.hop_g.panel_ajout();
        }
        if (source == hop_g.maj)
        {
            System.out.println("Effectuer une modification");
        }
        if (source == hop_g.reporting)
        {
            System.out.println("Consulter des statistiques");
        }
        
       
        // pour les buttons de la page ajouter
        if(source == hop_g.ok_ajouter)
        {
            // récuperer les données entrées par utilisateur
            String nom = hop_g.n.getText();
            String prenom = hop_g.p.getText();
            String adresse = hop_g.a.getText();
            String tel = hop_g.t.getText();
            String table;
            String[] att_sup = new String[3];
            // obtenir un numero pour malade et les employé aléatoires
                    // large choix pour multiplier les chances de pas avoir un chiffre déjà existant dans la bdd
            int rand = (int) (2500+(Math.random()*(2000000000-2500)));
            // changer ce chiffre en string pour l'envoyer à la méthode
            String cle = Integer.toString(rand);
            // savoir dans quel onglet l'utilisateur est :
             ////System.out.println(hop_g.onglets_ajouter.getSelectedIndex());
            // effectuer des initialisation par rappport à l'onglet où se positionne l'utilisateur
            switch(hop_g.onglets_ajouter.getSelectedIndex())
            {
                case 0 :
                    table = "docteur";
                    att_sup[0] = hop_g.s.getText();
                    String spe = att_sup[0];
                    if((nom.equals(""))||(prenom.equals(""))||(adresse.equals(""))||(tel.equals(""))||(spe.equals("")))
                    {
                        JOptionPane.showMessageDialog(null,"Veuillez renseigner tous les éléments du formulaire !");
                    }
                    // ajouter quelqu'un dans la bdd
                    // TestHopital.insert(this.hopital, this.hopital.co_local, table, cle, nom, prenom, adresse, tel, att_sup) 
                    break;
                case 1 :
                    table = "infirmier";
                     //rotation = att_sup[0] ; salaire = att_sup[1] ; code_serv = att_sup[2];
                    // att_sup[0] = hop_g;
                    // att_sup[0] = hop_g;
                    // att_sup[0] = hop_g;
                    break;
                case 2 :
                    table = "malade";
                    // att_sup[0] = hop_g;
                    break;
            }
            // ajouter quelqu'un dans la bdd
           // TestHopital.insert(Hopital h, Connexion co, table, cle, nom, prenom, adresse, tel, String[] att_sup) throws SQLException, ClassNotFoundException
    
        }
        if(source == hop_g.retour_m_choix)
        {
            // retour a la page d'avant : menu des choix 
            TestHopital.hop_g.panel_deux();
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
            TestHopital.hopital = new Hopital(a, b, c);
            TestHopital.hop_g.panel_deux();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Mauvaise entrée!");
        }
        
    }
    
    /**
     * METHODE : pour effectuer les requetes créer dans modele 
     * @param h
     * @param co
     * @param d
     * @param table
     * @param cle
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param att_sup 
     * @throws java.sql.SQLException 
     * @throws java.lang.ClassNotFoundException 
     */
    public void insert(Hopital h, Connexion co, String table, String cle, String nom, String prenom, String adresse, String tel, String[] att_sup) throws SQLException, ClassNotFoundException
    {
        MAJ eff;
        eff = new MAJ();
        
        if ("docteur".equals(table))
        {
            int cle_bis = Integer.parseInt(cle);
            String specialite = att_sup[0];
            Docteur d_tamp = new Docteur(cle_bis, nom, prenom, adresse, tel, specialite);
            //Docteur d_tamp = new Docteur(500, "Herve", "Albert", "80 rue leon, 75015 Paris", "05 56 05 52 63", "Cardiologue");
            System.out.println(h.emp.contains(d_tamp));
            if(!h.emp.contains(d_tamp))
            {
                System.out.println("Docteur existe pas ");
                try {
                            // appeler MAJ
                            String[] querry;
                            querry = eff.insert_general(table,cle, nom, prenom, adresse, tel, att_sup);
                            // ajout du docteur ou infirmier
                            String l_1 = querry[0];
                            co.executeUpdate(l_1);
                            // ajout de ce docteur ou infirmier dans employe
                            String l_2 = querry[1];
                            co.executeUpdate(l_2);
                            System.out.print("ok");
                            // mettre a jour les arraylist
                            this.remplirClasses();
                    }
                catch(SQLException e)
                    { System.out.println("Impossible d'ajouter : problème SQL");}
            }
            else
            {
                System.out.println("Déja existant pas possible d'ajouter");
            }
        }
        
        if ("infirmier".equals(table))
        {
            int cle_bis = Integer.parseInt(cle);
            String rotation = att_sup[0];
            String salaire = att_sup[1];
            double salaire_bis;
            salaire_bis = Double.parseDouble(salaire);
            String code_serv = att_sup[2];
            /// Constructeur Infirmier : int numero, String nom, String prenom, String adresse, String tel, double _salaire, String _rotation, String code
            Infirmier i_tamp = new Infirmier(cle_bis, nom, prenom, adresse, tel, salaire_bis, rotation, code_serv);
            //Docteur d_tamp = new Docteur(500, "Herve", "Albert", "80 rue leon, 75015 Paris", "05 56 05 52 63", "Cardiologue");
            System.out.println(h.inf.contains(i_tamp));
            if(!h.emp.contains(i_tamp))
            {
                System.out.println("Infirmier existe pas ");
                try {
                            // appeler MAJ
                            String[] querry;
                            querry = eff.insert_general(table,cle, nom, prenom, adresse, tel, att_sup);
                            // ajout du docteur ou infirmier
                            String l_1 = querry[0];
                            co.executeUpdate(l_1);
                            // ajout de ce docteur ou infirmier dans employe
                            String l_2 = querry[1];
                            co.executeUpdate(l_2);
                            // mettre a jour les arraylist
                            this.remplirClasses();
                    }
                catch(SQLException e)
                    { System.out.println("Impossible d'ajouter : problème SQL");}
            }
            else
            {
                System.out.println("Déja existant pas possible d'ajouter");
            }
        }
        
        if ("malade".equals(table))
        {
            int cle_bis = Integer.parseInt(cle);
            String mutuelle = att_sup[0];
            Malade m_tamp = new Malade(cle_bis, nom, prenom, adresse, tel, mutuelle);
            //Docteur d_tamp = new Docteur(500, "Herve", "Albert", "80 rue leon, 75015 Paris", "05 56 05 52 63", "Cardiologue");
            System.out.println(h.m.contains(m_tamp));
            if(!h.m.contains(m_tamp))
            {
                System.out.println("Malade existe pas ");
                try {
                            // appeler MAJ
                            String[] querry;
                            querry = eff.insert_general(table,cle, nom, prenom, adresse, tel, att_sup);
                            // ajout du malade
                            String l_1 = querry[0];
                            co.executeUpdate(l_1);
                            // mettre a jour les arraylist
                            this.remplirClasses();
                    }
                catch(SQLException e)
                    { System.out.println("Impossible d'ajouter : problème SQL");}
            }
            else
            {
                System.out.println("Déja existant pas possible d'ajouter");
            }
        }

    }
    

    /**
     * @param args the command line arguments
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here

        hop_g = new Graphique();
        hop_cons = new Console();
        
        // pour console 
        TestHopital test_2 = new TestHopital("hopital", "root", "");
        
        //test_h = new TestHopital(nom_base, login, pass);
            /// pour la copie de la bdd dans la classe 
        
        test_2.remplirClasses();
        
        // pour graphique 
        TestHopital test_h = new TestHopital();
        
        
       // test_2.hopital.affichage_uneliste('2');
        //180 Nalbandian David 46 Rue Courteissade, 78310 Maurepas 01 94 53 22 54 
        /////////////////////////// MARCHE PAS EXISTE DEJA ! et mets encore false 
        ///////////////////////////// + quand on mets infirmier au lieu de docteur dois aussi dire que ca marche pas ! encore false au lieu de true
     /*   String cle = "1800";
        String table = "docteur";
        String nom = "Lafourcade";
        String prenom = "Maylis";
        String adresse = "46 Rue Courbet, 78310 Limoge";
        String tel = "02 94 60 22 55";
        // rotation , salaire , code_service
        String[] att_sup = {"NUIT", "1200.5", "CAR"};
            /// Hopital h, Connexion co, String table, String cle, String nom, String prenom, String adresse, String tel, String[] att_sup
        test_2.insert(test_2.hopital, test_2.hopital.c_local, table, cle, nom, prenom, adresse, tel, att_sup);
        // envoyer les variables String pour effectuer une insertion : ESSAYE_CONSOLE
        /*test_2.hopital.supprimer();
        test_2.remplirClasses();
        test_2.hopital.affichage_uneliste('2');*/

        /**
         * initialisation 
         */
       
        test_h.hop_g.connexion();
        test_h.hop_g.setVisible(true);
        
        
        //hopital.affichage_uneliste(hop_cons.menu());

}


}
