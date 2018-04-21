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
    
    /**
     * METHODE : créer une requete pour l'éffectuer dans controleur après
     * @param cle
     * @param att_empl
     * @param att_spe
     * @return 
     */
    public String[] insert_doc(String cle, String nom, String prenom, String adresse, String tel, String att_spe)
    {
        // table = docteur ; vu qu'on est dans la classe Docteur
        // la cle est le numéro du docteur !
                // arraylist avec attributs employé à envoyer pour classe methode classe mère
        // Insert une donné dans la base de donnée
            // Docteur : INSERT INTO docteur VALUES ('numero', 'specialite')
        String querry = "INSERT INTO docteur VALUES ('" + cle + "', '" +att_spe + "')";
        String querry2;
        
        querry2 = this.insert_employe(cle,nom, prenom, adresse, tel);
        String q [] = {querry, querry2};
        
        return q;
    }
    
}
