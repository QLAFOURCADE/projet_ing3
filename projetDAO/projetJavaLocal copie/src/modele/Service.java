/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Quiterie, Pierre-Louis, Tiphaine
 */
public class Service {
    
    /**
     * les attributs 
     */
    private String code;
    private String nom;
    private String batiment;
    private String directeur; 
    
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Service(){};
    
    /**
     * CONSTRUCTEUR 
     * @param code
     * @param nom
     * @param batiment
     * @param directeur 
     */
    public Service(String code,String  nom, String batiment,String  directeur)
    {
        this.code = code;
        this.nom = nom;
        this.batiment = batiment;
        this.directeur = directeur;
    }
    
    //Getters
    /**
     * METHODES : getter - lire l'attribut code
     * @return 
     */
    public String getCode() {
        return code;
    }
    
    /**
     * METHODES : getter - lire l'attribut nom
     * @return 
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * METHODES : getter - lire l'attribut le batiment 
     * @return 
     */
    public String getBatiment() {
        return batiment;
    }
    
    /**
     * METHODES : getter - lire l'attribut du directeur 
     * @return 
     */
    public String getDirecteur() {
        return directeur;
    }
    
    //Setters
    /**
     * METHODES : setter - modifier l'attribut code 
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * METHODES : setter - modifier l'attribut nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * METHODES : setter - modifier l'attribut batiment
     * @param batiment 
     */
    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }
    
    /**
     * METHODES : setter - modifier l'attribut directeur
     * @param directeur 
     */
    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }
    
    
    
    
    
}
