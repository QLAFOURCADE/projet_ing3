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
    private boolean rotation; // FALSE - JOUR & TRUE - NUIT
    private Service s_inf; // un infirmier est associé à un service
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public  Infirmier()
    {
        super();
        salaire = 0;
        rotation = false;
        s_inf = new Service();
    }
    
    public Infirmier(int numero, float salaire, String rotation, String code)
    {
        super();
        this.numero = numero;
        this.salaire = salaire;
        // identifier jour ou nuit la rotation de l'infirmier
        if(rotation == "JOUR")
        {
            this.rotation = false;
        }
        else 
        {
            this.rotation = true;
        }
        // modifier le code 
        //this.s_inf = new Service();
        
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
     * @param _s_inf 
     */
    public Infirmier(int numero, String nom, String prenom, String adresse, String tel, float _salaire, boolean _rotation, String code)
    {
        super(numero, nom, prenom, adresse, tel);
        this.salaire = _salaire;
        this.rotation = _rotation;
      //  this.s_inf = new Service(code);
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
     * 0 = JOUR & 1 = NUIT
     * @return rotation
     */
    public boolean getRotation() {
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
    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }

    /**
     * METHODE : setter - modifier l'attribut service
     * @param s_inf 
     */
    ////////////////////////////////////// A FAIRE !!!!!!!!!!!! ///////////////////////////////

            
}
