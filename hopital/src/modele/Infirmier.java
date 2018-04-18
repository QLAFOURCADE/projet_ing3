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
public class Infirmier extends Employe {
    
    /**
     * les attributs
     */ 
    private float salaire;
    private String rotation; // JOUR & NUIT
    protected Service s_inf; // un infirmier est associé à un service
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public  Infirmier()
    {
        super();
        salaire = 0;
        rotation = "";
        s_inf = new Service();
    }
    
    /**
     * CONSTRUCTEUR
     * @param numero
     * @param salaire
     * @param rotation
     * @param code 
     */
    public Infirmier(int numero, float salaire, String rotation, String code)
    {
        super();
        this.numero = numero;
        this.salaire = salaire;
        // identifier jour ou nuit la rotation de l'infirmier
        this.rotation = rotation;
        // modifier le code 
        this.s_inf = new Service();
        s_inf.setCode(code);
        
    }
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param numero
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param _salaire
     * @param _rotation
     * @param code
     */
    public Infirmier(int numero, String nom, String prenom, String adresse, String tel, float _salaire, String _rotation, String code)
    {
        super(numero, nom, prenom, adresse, tel);
        this.salaire = _salaire;
        this.rotation = _rotation;
        this.s_inf = new Service();
    }

    /**
     * METHODE : getter - lire l'attribut salaire
     * @return salaire
     */
    public float getSalaire()
    {
        return salaire;
    }
    
    /**
     * METHODE : getter - lire l'attribut rotation
     * @return rotation
     */
    public String getRotation() {
        return rotation;
    }

    /**
     * METHODE : getter - lire l'attribut service
     * @return service
     */
    /////////////////////////////////// A FAIRE !!!!!!!!!!!! ///////////////////////////////


    /**
     * METHODE : setter - modifier l'attribut salaire
     * @param salaire 
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    /**
     * METHODE : setter - modifier l'attribut rotation
     * @param rotation 
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    /**
     * METHODE : pour afficher les attributs d'un ou des infimiers
     * @return 
     */
    @Override
    public String toString() {
        String s = "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel;
        return "Infirmier{" +s+ ", salaire=" + salaire + ", rotation=" + rotation + ", ASSOCIE AU SERVICE :" + s_inf.getCode() + '}';
    }


    /**
     * METHODE : setter - modifier l'attribut service
     * @param s_inf 
     */
    ////////////////////////////////////// A FAIRE !!!!!!!!!!!! ///////////////////////////////

    
            
}
