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
import java.util.*;

/**
 *
 * @author Quiterie
 */
public class Hopital {
    
    /**
     * attributs de la classes
     * peut rajouter connexion ece à distance ????
     * protected : accés possible que pour les methodes dans classes + heritage
     */
    protected Connexion c_local;
    private ArrayList<Docteur> doc = new ArrayList<>(); 
    private ArrayList<Infirmier> inf = new ArrayList<>();
    private ArrayList<Service> s = new ArrayList<>();
    private ArrayList<Malade> m = new ArrayList<>();
    private ArrayList<Chambre> c = new ArrayList<>();
    private ArrayList<Employe> emp = new ArrayList<>();
    
    
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
    //////////////////////////// MALADE ////////////////////////////////////////////
    /**
     * METHODE : pour remplir la liste de malade present dans hopital
     * @throws SQLException 
     */
    public void remplir_malade() throws SQLException
    {
        //System.out.println("dans remplir");
        String table = "malade";
        ArrayList<String> bdd = c_local.remplirChampsRequete("Select* from "+table);
        //System.out.println("recupere table BDD ");
        for(String list : bdd)
        {
            int t0;
            // recuperer ligne après ligne le contenu de l'arraylist : list correspond à une ligne 
            // diviser en fonction des attributs
            String t[] = new String[7];
            t = list.split(",");
            
            /**for(int i=0; i<7; i++)
            {
                System.out.println("element "+i+" = "+ t[i]);
            }
            */
            
            // convertir en int le numero du malade
            t0 = Integer.parseInt(t[0]);
            String t3 = t[3]+ ","+ t[4];
            // constructeur malade : int numero, String nom, String prenom, String adresse, String tel, String mutuelle
            Malade m_tamp = new Malade(t0, t[1], t[2], t3, t[5], t[6]);
            /////System.out.println("malade crée");
            // ajouter le malade créer dans la liste contenant tous les malades
            /////System.out.println("j'ajoute un malade"+list);
            this.m.add(m_tamp);
        }
    }
    
    /////////////////////////// CHAMBRE //////////////////////////////////////////////
        public void remplir_chambre() throws SQLException
    {
        //System.out.println("dans remplir");
        String table = "chambre";
        ArrayList<String> bdd = c_local.remplirChampsRequete("Select* from "+table);
        //System.out.println("recupere table BDD ");
        for(String list : bdd)
        {
            // recuperer ligne après ligne le contenu de l'arraylist : list correspond à une ligne 
            // diviser en fonction des attributs
            String t[] = new String[4];
            t = list.split(",");      
            // convertir en int le numero de la chambre
            int t1 = Integer.parseInt(t[1]);
            int t2 = Integer.parseInt(t[2]);
            // problème d'espace dans la chaine de caractère : on doit enlever pour convertir en int
            String t_b = t[3].trim();
            int t3 = Integer.parseInt(t_b);
            // constructeur chambre : int num_ch, int nb_lits, int inf, String code
            Chambre c_tamp = new Chambre(t1,t3,t2,t[0]);
            /////System.out.println("chambre crée");
            // ajouter la chambre créer dans la liste contenant tous les malades
            /////System.out.println("j'ajoute un malade"+list);
         // this.m.add(m_tamp);
        }
    }
    /////////////////////////// SERVICE ///////////////////////////////////////////////
    /**
     * METHODE : pour remplir la liste de service 
     * @throws SQLException 
     */
    public void remplir_service() throws SQLException
    {
        //System.out.println("dans remplir");
        String table = "service";
        ArrayList<String> bdd = c_local.remplirChampsRequete("Select* from "+table);
        //System.out.println("recupere table BDD ");
        for(String list : bdd)
        {
            // recuperer ligne après ligne le contenu de l'arraylist : list correspond à une ligne 
            // diviser en fonction des attributs
            String t[] = new String[4];
            t = list.split(",");
            /**
            for(int i=0; i<4; i++)
            {
                System.out.println("element "+i+" = "+ t[i]);
            }
            */
            // problème d'espace dans la chaine de caractère : on doit enlever pour convertir en int
            String t_b = t[3].trim();
            // convertir en int le code du service
            int t3 = Integer.parseInt(t_b);
            // convertir le string en char pour le batiment
            char t2 = t[2].charAt(0);
            // constructeur service : String code, String nom_service, char batiment, int num_directeur
            Service s_tamp = new Service(t[0], t[1], t2, t3);
            /////System.out.println("service crée");
            // ajouter le malade créer dans la liste contenant tous les malades
            /////System.out.println("j'ajoute un service"+list);
            this.s.add(s_tamp);
        }
    }
    

    
    /**
     * METHODE : affichage arraylist selon le choix de l'utilisateur
     * @param choix_utilisateur 
     */
    public void affichage_uneliste(char choix_utilisateur)
    {
        switch (choix_utilisateur)
        {
            // System.out.println("0 Quitter");
            case '0':
                System.exit(0);
                break;
            //System.out.println("1 Chambre");
            case '1':
                for(Chambre T : this.c)
                {
                    System.out.println(T.toString());
                }
                break;
            //System.out.println("2 Docteur");
            case '2':
                for(Docteur T : this.doc)
                {
                    System.out.println(T.toString());
                }
                break;
            //System.out.println("3 Employe");
            case '3':
                for(Employe T : this.emp)
                {
                    System.out.println(T.toString());
                }
                break;
            //System.out.println("4 Hospitalisation");
            case '4':
                //// A FAIRE !!!!! /////
                System.out.println("4 Hospitalisation");
                break;
            //System.out.println("5 Infirmier");
            case '5':
                for(Infirmier T : this.inf)
                {
                    System.out.println(T.toString());
                }
                break;
            //System.out.println("6 Malade");
            case '6':
                for(Malade T : this.m)
                {
                    System.out.println(T.toString());
                }
                break;
            //System.out.println("7 Service");
            case '7':
                for(Service T : this.s)
                {
                    System.out.println(T.toString());
                }
                break;
            //System.out.println("8 Soigne");
            case '8':
                System.out.println("8 Soigne");
                ///////////// A FAIRE !!! /////////////
            default:
                return;
        }
    }
    
/*** docteur methode  
        table = "docteur";
        bdd = c_local.remplirChampsTable(table);
        Docteur d_tamp;
        for(int j=1; j<bdd.size(); j++)
        {
            int t0;
            // recuperer ligne après ligne le contenu de l'arraylist
            tampon = bdd.get(j);
            // diviser en fonction des attributs
            String t[] = new String[2];
            t = tampon.split(",");
            // convertir en int le numero du docteur
            t0 = Integer.parseInt(t[0]);
            // constructeur docteur : int numero, String specialite 
            d_tamp = new Docteur(t0, t[1]);            
            // ajouter le docteur créer dans la liste contenant tous les docteurs
            this.doc.add(d_tamp);
        }
        
        /**
         *      Arraylist Infirmier
         */
/** infirmier methode
        table = "infirmier";
        bdd = c_local.remplirChampsTable(table);
        Infirmier i_tamp;
        for(int j=1; j<bdd.size(); j++)
        {
            // recuperer ligne après ligne le contenu de l'arraylist
            tampon = bdd.get(j);
            // diviser en fonction des attributs
            String t[] = new String[4];
            t = tampon.split(",");
            // convertir en int le numero de l'infirmier
            int t0 = Integer.parseInt(t[0]);
            // convertir en float le salaire 
            float t3 = Float.parseFloat(t[3]);
            // constructeur infirmier : int numero, float salaire, String rotation = t[2] , String code = t[1]
            i_tamp = new Infirmier(t0,t3,t[2], t[1]);            
            // ajouter le docteur créer dans la liste contenant tous les docteurs
            this.inf.add(i_tamp);
        }
    }
 */

    /**
     * METHODE :
     * @throws SQLException 
     */
    public void identification_emp() throws SQLException
    {
        // arraylist pour avoir tous les employé et identifier qui est docteur et/ou infirmier
        // recupere la table entiere de employé
        ArrayList<String> e_tamp = c_local.remplirChampsTable("employe");
        String tampon;
        // décomposer les éléments de la BDD
        for(int i=0; i<e_tamp.size(); i++)
        {
            // recuperer ligne par ligne le contenu de la liste
            tampon = e_tamp.get(i);
            // diviser chaque ligne en 5 éléments : numero, nom, prenom, adresse, tel
            String t[] = new String[5];
            t = tampon.split(",");
            // variable prends premier élément : le numero de l'employé à comparer
            int t0 = Integer.parseInt(t[0]);
            // boucle for pour parcourir la liste doc; comparer avec employe; mettre ceux avec numero different dans infirmier
            for(int j=0; j<doc.size(); j++)
            {
                if (t0 != doc.get(j).getNumero())
                {
                    // l'employé est un infirmier ! + il faut ajouter les éléments dans l'arraylist infirmier
                    // constructeur infirmier : int numero, String nom, String prenom, String adresse, String tel, float _salaire, boolean _rotation, Service _s_inf
                   // Infirmier i_t = new Infirmier(t0,t[1],t[2],t[3],t[4],t[5]);
                }
            }
            
        }
    }
    
    /**
     * METHODE : pour ajouter dans la BDD
     * @return 
     */
   // public boolean insert();
    
    /**
     * METHODE : pour mettre à jour la BDD
     * @return 
     */
   // public boolean update();
    
    /**
     * METHODE : pour trier dans la BDD; rechercher des inofrmations
     * @return 
     */
   // public boolean select();
    
    /**
     * METHODE : pour supprimer dans la BDD
     * @return 
     */
   // public boolean delete();
}
