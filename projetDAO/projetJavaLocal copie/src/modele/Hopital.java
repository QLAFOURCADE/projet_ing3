/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.Connexion;
import controleur.Connexion2;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public Connexion2 c_local;
    public ArrayList<Docteur> doc = new ArrayList<>(); 
    public ArrayList<Infirmier> inf = new ArrayList<>();
    private ArrayList<Service> s = new ArrayList<>();
    public ArrayList<Malade> m = new ArrayList<>();
    private ArrayList<Chambre> c = new ArrayList<>();
    public ArrayList<Employe> emp = new ArrayList<>();
    
    
        /**
     * Constructeur de la classe
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Hopital() throws SQLException, ClassNotFoundException
    {
        /// String nameDatabase, String loginDatabase, String passwordDatabase
        c_local = new Connexion2("hopital", "root", "");
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
            // constructeur chambre : String code_service, int num_ch, int surveillant, int nb_lits
            Chambre c_tamp = new Chambre(t[0],t1,t2,t3);
            
            // ajouter la chambre créer dans la liste
            this.c.add(c_tamp);
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
            
            // compléter la liste des chambres présente dans la classe service : 
                ///// le but avoir la liste des chambres que pour le service en question 
            // constructeur service : String code,String  nom, String batiment,String  directeur
            Service s_tamp = new Service(t[0], t[1], t[2], t[3]);
            // ajoute le service avec toutes les données dans la liste de l'hopital
            this.s.add(s_tamp);
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
            double t3 = Double.parseDouble(t[3]);
            // constructeur infirmier : int numero,String code_service, String rotation,  double salaire 
            Infirmier i_tamp = new Infirmier(t0,t[1],t[2],t3);
            
            // ajouter l'employe créer dans la liste
            this.inf.add(i_tamp);
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
     * supprimer toute les arraylists de l'hopital
     */
    public void supprimer()
    {
        this.c.clear();
        this.doc.clear();
        this.emp.clear();
        this.inf.clear();
        this.m.clear();
        this.s.clear();
    }

    public void remplir() throws SQLException
    {
        /**
         * remplissage des arraylists présente dans la classe hopital
         */
        // remplir et afficher la liste de malade
        this.remplir_malade();
        this.remplir_employe();
        this.remplir_docteur();
        // obliger de faire deux fois service pour avoir toutes les attributs des objets remplis
        //hopital.remplir_service();
        this.remplir_infirmier();
        this.remplir_chambre();
        this.remplir_service();
    }

}
  
