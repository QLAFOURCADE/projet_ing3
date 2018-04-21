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
public class Employe {
    
    /**
     * les attributs
     * le numero est mis en protected pour que les classes filles puissent l'utiliser 
     *      utile pour faire le lien et remplir les arraylist comme la BDD
     */
    protected int numero;
    protected String nom; // nom de l'employe
    protected String prenom; // prenom 
    protected String adresse; // adresse postale
    protected String tel; // telephone
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public Employe()
    {
        numero = 0;
        nom = "";
        prenom = "";
        adresse = "";
        tel = "";
    }
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
     * METHODE : afficher les renseignements de l'employé
     * @return 
     */
    @Override
    public String toString() {
        return "Employe{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + '}';
    }
    
    
    public String insert_employe(String cle, String nom, String prenom, String adresse, String tel)
    {
        // table = docteur ; vu qu'on est dans la classe Docteur
        // la cle est le numéro de l'employe le meme que le docteur !
                // arraylist avec attributs employé à envoyer pour classe methode classe mère
        // Insert une donné dans la base de donnée
                  // Employe : INSERT INTO employe VALUES ('numero', 'nom', 'prenom', 'adresse', 'tel')
        String querry = "INSERT INTO employe VALUES ('" + cle + "', '" + nom +"', '" + prenom + "', '" + adresse+ "', '" + tel +"')";
        
        return querry;
    }
    
    @Override
    public boolean equals(Object object) {

        if (object instanceof Employe) {
            Employe emp = (Employe) object;
           // System.out.println(emp.numero +"//"+numero);
            if ((nom.equals(emp.nom)) && (prenom.equals(emp.prenom)) && (adresse.equals(emp.adresse)) && (tel.equals(emp.tel)) /* && autres condition*/) {
                System.out.println(emp.numero +"//"+numero);
                if (numero == emp.numero)
                {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }
}
