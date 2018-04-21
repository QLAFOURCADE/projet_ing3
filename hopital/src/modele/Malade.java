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
     *  CONSTRUCTEUR PAR DEFAUT 
     */
    public Malade()
    {
        numero = 0;
        nom = "";
        prenom = "";
        adresse = "";
        tel = "";
        mutuelle = "";
    }
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param mutuelle 
     */
    public Malade(int numero, String nom, String prenom, String adresse, String tel, String mutuelle)
    {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.mutuelle = mutuelle;
    }
    
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

    /**
     * METHODE : afficher élément d'un malade 
     * @return string
     */
    @Override
    public String toString() {
        return "Malade{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", mutuelle=" + mutuelle + '}';
    }
    
    /**
     * METHODE : pour comparer appliquer a la classe Malade
     * @param object
     * @return 
     */
     @Override
    public boolean equals(Object object) {

        if (object instanceof Malade) {
            Malade mal = (Malade) object;
            if ((mal.numero == numero) && (nom.equals(mal.nom)) && (prenom.equals(mal.prenom)) && (adresse.equals(mal.adresse)) && (tel.equals(mal.tel)) /* && autres condition*/) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    public String[] insert_malade(String cle, String nom, String prenom, String adresse, String tel, String mutuelle)
    {
        // table = malade ; vu qu'on est dans la classe Malade
        // la cle est le numéro du malade !
                // arraylist avec attributs employé à envoyer pour classe methode classe mère
        // Insert une donné dans la base de donnée
            // Docteur : INSERT INTO malade VALUES ('numero', 'nom', 'prenom', 'adresse', 'tel', 'mutuelle')
        String querry = "INSERT INTO malade VALUES ('" + cle + "', '" + nom + "', '" + prenom+ "', '"+  adresse + "', '"+ tel + "', '"+ mutuelle + "')";
        String querry2 = "";
        
        String q [] = {querry, querry2};
        return q;
    }
    
    
}
