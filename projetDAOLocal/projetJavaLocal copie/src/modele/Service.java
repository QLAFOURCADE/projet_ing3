/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Pierre-Louis
 */
public class Service {
    
    /**
     * les attributs 
     */
    private String code;
    private String nom;
    private String batiment;
    private String directeur; 
    
    //Constructeur
    public Service(){};
    
    public Service(String code,String  nom, String batiment,String  directeur)
    {
        this.code = code;
        this.nom = nom;
        this.batiment = batiment;
        this.directeur = directeur;
    }
    
    //Getters
    public String getCode() {
        return code;
    }
    public String getNom() {
        return nom;
    }
    public String getBatiment() {
        return batiment;
    }
    public String getDirecteur() {
        return directeur;
    }
    
    //Setters
    public void setCode(String code) {
        this.code = code;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }
    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }
    
    
    
    
    
}
