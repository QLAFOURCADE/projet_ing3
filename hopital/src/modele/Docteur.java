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
public class Docteur extends Employe{
    
    private String specialite;
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param specialite 
     */
    public Docteur(int numero, String nom, String prenom, String adresse, String tel, String specialite)
    {
        super(numero, nom, prenom, adresse, tel);
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
    
    
    
    
}
