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
public class Employe {
    
    /**
     * les attributs
     */
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Employe(){};
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel 
     */
    public Employe(int numero, String nom, String prenom, String adresse, String tel)
    {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
    }

    /**
     * METHODE : lire l'attribut numero de l'employe
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * METHODE : lire l'attribut nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * METHODE : lire l'attribut prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * METHODE : lire l'attribut adresse
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * METHODE : lire l'attribut telephone
     * @return telephone
     */
    public String getTel() {
        return tel;
    }

    /**
     * METHODE : modifier l'attribut numero de l'employe
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * METHODE : modifier l'attribut nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * METHODE : modifier l'attribut prenom
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * METHODE : modifier l'attribut adresse
     * @param adresse 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * METHODE : modifier l'attribut telephone
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * METHODE : pour la console
     * @return 
     */
    @Override
    public String toString() {
        return "Employe{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + '}';
    }

}
