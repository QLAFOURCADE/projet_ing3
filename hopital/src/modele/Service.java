/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Quiterie
 */
public class Service {
    
    /**
     * les attributs 
     */
    private String code;
    private String nom_service;
    private char batiment;
    protected Docteur directeur; // chaque service posséde un directeur qui corresponds lui même à un docteur
    protected ArrayList<Chambre> liste_ch = new ArrayList<>(); // liste de chambres qui sont associé à un service 
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Service()
    {
        code = "";
        nom_service = "";
        batiment = 0;
        directeur = new Docteur();
    }
    

    /**
     * CONSTRUCTEUR
     * @param code
     * @param nom_service
     * @param batiment
     * @param num_directeur 
     */
    public Service(String code, String nom_service, char batiment, int num_directeur)
    {
        this.code = code;
        this.nom_service = nom_service;
        this.batiment = batiment;
        this.directeur = new Docteur();
        this.directeur.setNumero(num_directeur);
    }
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param code
     * @param nom_service
     * @param batiment
     * @param num_directeur
     * @param bdd_chambre 
     */
    public Service(String code, String nom_service, char batiment, int num_directeur, Chambre bdd_chambre)
    {
        this.code = code;
        this.nom_service = nom_service;
        this.batiment = batiment;
        this.directeur = new Docteur();
        this.directeur.numero = num_directeur;
        this.liste_ch.add(bdd_chambre);
    }

    /**
     *  METHODES : getter - lire l'attribut code
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     *  METHODES : getter - lire l'attribut nom du service
     * @return nom_service
     */
    public String getNom_service() {
        return nom_service;
    }

    /**
     *  METHODES : getter - lire l'attribut le batiment où se trouve le service
     * @return batiment
     */
    public char getBatiment() {
        return batiment;
    }

    /**
     * METHODE : getter - lire le docteur associé au service
     * @return 
     */
    public Docteur getDirecteur() {    
        return directeur;
    }

    /**
     * METHODES : getter - lire l'attribut liste des chambre pour le service
     */
    ///////////////////////////////////////// A faire !!!!!!!!!!!!! /////////////////////////////////////////
    
    /**
     *  METHODES : setter - modifier l'attribut code du service
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * METHODES : setter - modifier l'attribut nom du service
     * @param nom_service 
     */
    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    /**
     * METHODES : setter - modifier l'attribut batiment où est placé le service
     * @param batiment 
     */
    public void setBatiment(char batiment) {
        this.batiment = batiment;
    }

    /**
     * METHODE : setter - modifier le docteur du service
     * @param directeur 
     */
    public void setDirecteur(Docteur directeur) {
        this.directeur = directeur;
    }

    
    /**
     * METHODES : setter - modifier la liste des chambres associer au service
     */
    ////////////////////////////////////// A FAIRE !!!!!!!!!!!!!!!!!!!!!!! ///////////////////////////////
    
    
    /**
     * METHODE : affichage de toute la table de Service 
     * @return s
     */
    @Override
    public String toString() {
        String s = "\n" + "         " +this.directeur.toString();
        return "Service{" + "code=" + code + ", nom_service=" + nom_service + ", batiment=" + batiment + ", ASSOCIE AU DIRECTEUR : "  + s+'}';
    }

    /**
     * suite de l'affichage des renseignements 
     * @return
     */
    public String toString2()
    {
        String s_b = "";
        for(Chambre e : liste_ch)
        {
            s_b = s_b + "\n" + "       " + e.toString();  
        }
        return s_b;
    }
}
