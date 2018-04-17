/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Quiterie
 */
public class Malade {
    
    /**
     * attributs 
     */
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mutuelle; 

    
    /**
     * METHODES : getter - lire l'attribut numero
     * @return numero
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * METHODES : getter - lire l'attribut nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * METHODES : getter - lire l'attribut prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * METHODES : getter - lire l'attribut adresse
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * METHODES : getter - lire l'attribut telephone
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * METHODES : getter - lire l'attribut mutuelle
     * @return 
     */
    public String getMutuelle() {
        return mutuelle;
    }

    /**
     * METHODES : setter - modifier l'attribut numero du malade
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * METHODES : setter - modifier l'attribut nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * METHODES : setter - modifier l'attribut prenom
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * METHODES : setter - modifier l'attribut adresse
     * @param adresse 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * METHODES : setter - modifier l'attribut telephone
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * METHODES : setter - modifier l'attribut mutuelle
     * @param mutuelle 
     */
    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }
    
    
    
    
}
