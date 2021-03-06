/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Pierre-Louis //fait
 */
public class Docteur extends Employe{
    
    private String specialite;
    private int numero;
    
    //Constructeur
    public Docteur(){};
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param specialite 
     */
    public Docteur(int numero,  String specialite)
    {
        this.numero = numero;
        this.specialite = specialite;
    }

    /**
     * METHODE : lire l'attribut specialite
     * @return specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * METHODE : modifier l'attribut specialite
     * @param specialite 
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
     /**
     * METHODE : lire l'attribut numero
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * METHODE : modifier l'attribut numero
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    } 
}
