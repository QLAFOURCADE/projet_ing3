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
    /**
     * METHODE : pour remplir la liste des chambres
     * @throws SQLException 
     */   
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
            
            // ajouter la chambre créer dans la liste
            this.c.add(c_tamp);
        }
        for(Chambre ch : this.c)
        {
            for(Infirmier list2 : this.inf)
            {
                if(ch.surveillant.getNumero() == list2.getNumero())
                {
                    ch.surveillant.setNom(list2.getNom());
                    ch.surveillant.setPrenom(list2.getPrenom());
                    ch.surveillant.setAdresse(list2.getAdresse());
                    ch.surveillant.setTel(list2.getTel());
                    ch.surveillant.setRotation(list2.getRotation());
                    ch.surveillant.setSalaire(list2.getSalaire());
                    ch.surveillant.s_inf = list2.s_inf;
                }
            }
        }
    }
    
    /////////////////////////// SERVICE ///////////////////////////////////////////////
    /**
     * METHODE : pour remplir la liste des service 
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
            // problème d'espace dans la chaine de caractère : on doit enlever pour convertir en int
            String t_b = t[3].trim();
            // convertir en int le code du service
            int t3 = Integer.parseInt(t_b);
            // convertir le string en char pour le batiment
            char t2 = t[2].charAt(0);
            // compléter la liste des chambres présente dans la classe service : 
                ///// le but avoir la liste des chambres que pour le service en question 
            // constructeur service : String code, String nom_service, char batiment, int num_directeur
            Service s_tamp = new Service(t[0], t[1], t2, t3);
            // ajoute le service avec toutes les données dans la liste de l'hopital
            this.s.add(s_tamp);
        }
        // modifier les chambres appartenant aux services créer 
        for(Service list : this.s)
        {
            for(Chambre ch : this.c)
            {
                String s1 = new String(ch.getCode());
                String s2 = new String(list.getCode());
                int comp = s1.compareTo(s2);
                if(comp == 0)
                {
                    /// le code de la chambre est le meme que le service :
                        // la chambre appartient à ce service on l'ajoute dans l'arraylist
                    list.liste_ch.add(ch);
                }
            }
            for(Docteur d_list : this.doc)
            {
                if(list.directeur.numero == d_list.getNumero())
                {
                    list.directeur.setNom(d_list.getNom());
                    list.directeur.setPrenom(d_list.getPrenom());
                    list.directeur.setAdresse(d_list.getAdresse());
                    list.directeur.setTel(d_list.getTel());
                    list.directeur.setSpecialite(d_list.getSpecialite());
                }
            }
        }
    }
    
    ////////////////////////// EMPLOYE ///////////////////////////////////////////////
    /**
     * METHODE : pour remplir la liste des employés
     * @throws SQLException 
     */
    public void remplir_employe() throws SQLException
    {
        String table = "employe";
        ArrayList<String> bdd = c_local.remplirChampsRequete("Select* from "+table);
        //System.out.println("recupere table BDD ");
        for(String list : bdd)
        {
            // recuperer ligne après ligne le contenu de l'arraylist : list correspond à une ligne 
            // diviser en fonction des attributs
            String t[] = new String[6];
            t = list.split(",");      
            // convertir en int le numero de l'employe
            int t0 = Integer.parseInt(t[0]);
            // problème car adresse composé d'une virgule
            String t3 = t[3]+ ","+ t[4];
            // constructeur employe : int numero, String nom, String prenom, String adresse, String tel
            Employe e_tamp = new Employe(t0, t[1], t[2], t3, t[5]);
            
            // ajouter l'employe créer dans la liste
            this.emp.add(e_tamp);
        }
    }

    ////////////////////////// DOCTEUR ////////////////////////////////////////////////
    /**
     * METHODE : pour remplir la liste des docteurs, qui sont aussi des employés
     * @throws SQLException 
     */
    public void remplir_docteur() throws SQLException
    {
        String table = "docteur";
        ArrayList<String> bdd = c_local.remplirChampsRequete("Select* from "+table);
        //System.out.println("recupere table BDD ");
        for(String list : bdd)
        {
            // recuperer ligne après ligne le contenu de l'arraylist : list correspond à une ligne 
            // diviser en fonction des attributs
            String t[] = new String[2];
            t = list.split(",");      
            // convertir en int le numero du docteur 
            int t0 = Integer.parseInt(t[0]);
            // constructeur docteur : int numero, String specialite
            Docteur d_tamp = new Docteur(t0, t[1]);
            
            // ajouter l'employe créer dans la liste
            this.doc.add(d_tamp);
        }
        
        // associer les éléments de la table employé celle du docteur
        for(Docteur list : this.doc)
        {
            for(Employe list2 : this.emp)
            {
                if(list.getNumero() == list2.getNumero())
                {
                    list.setNom(list2.getNom());
                    list.setPrenom(list2.getPrenom());
                    list.setAdresse(list2.getAdresse());
                    list.setTel(list2.getTel());
                }
                 
            }
        }
    }
    
    ///////////////////////// INFIRMIER /////////////////////////////////////////////
    /**
     * METHODE : pour remplir la liste des infirmiers qui sont aussi des employes
     *              et qui sont associé à un service 
     * @throws SQLException 
     */
    public void remplir_infirmier() throws SQLException
    {
         String table = "infirmier";
        ArrayList<String> bdd = c_local.remplirChampsRequete("Select* from "+table);
        //System.out.println("recupere table BDD ");
        for(String list : bdd)
        {
            // recuperer ligne après ligne le contenu de l'arraylist : list correspond à une ligne 
            // diviser en fonction des attributs
            String t[] = new String[4];
            t = list.split(",");      
            // convertir en int le numero de l'infirmier
            int t0 = Integer.parseInt(t[0]);
            float t3 = Float.parseFloat(t[3]);
            // constructeur infirmier : int numero, float salaire, String rotation, String code
            Infirmier i_tamp = new Infirmier(t0,t3,t[2],t[1]);
            
            // ajouter l'employe créer dans la liste
            this.inf.add(i_tamp);
        }
        
        // associer les éléments de la table employé à celle des infirmiers
        for(Infirmier list : this.inf)
        {
            for(Employe list2 : this.emp)
            {
                if(list.getNumero() == list2.getNumero())
                {
                    list.setNom(list2.getNom());
                    list.setPrenom(list2.getPrenom());
                    list.setAdresse(list2.getAdresse());
                    list.setTel(list2.getTel());
                }
            }
            // compléter les éléments du service associé à chaque infirmier 
            for(Service list3 : this.s)
            {
                String s1 = new String(list.s_inf.getCode());
                String s2 = new String(list3.getCode());
                int comp = s1.compareTo(s2);
                if(comp == 0)
                {
                    list.s_inf.setNom_service(list3.getNom_service());
                    list.s_inf.setBatiment(list3.getBatiment());
                    list.s_inf.setDirecteur(list3.getDirecteur());
                    list.s_inf.liste_ch = list3.liste_ch;
                }
            }
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
                System.out.println(" A BIENTOT !");
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
                    System.out.println(T.toString2());
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
