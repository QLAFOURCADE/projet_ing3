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
     * CONSTRUCTEUR PAR DEFAUT 
     */
    public Docteur()
    {
        super();
        specialite = "";
    }
    
    /**
     * CONSTRUCTEUR : par defaut pour la partie mere sauf le numéro du docteur
     * + specialite connu : car les deux éléments données par BDD dans table Docteur 
     * @param specialite 
     * @param numero
     */
    public Docteur(int numero, String specialite)
    {
        super();
        this.numero = numero;
        this.specialite = specialite;
    }
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

    /**
     * METHODE : pour afficher les attributs d'un ou des docteurs
     * @return 
     */
    @Override
    public String toString() {
        String s = " numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + "; adresse=" + adresse + "; tel=" + tel;
        return "Docteur{" + s + " specialite=" + specialite + '}';
    }
    
    
    
    
}
