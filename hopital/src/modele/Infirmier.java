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
    private boolean rotation; // 0 - JOUR & 1 - NUIT
    private Service s_inf; // un infirmier est associé à un service
    
    /**
     * CONSTRUCTEUR SURCHARGE
     * @param _salaire
     * @param _rotation
     * @param _s_inf 
     */
    public Infirmier(float _salaire, boolean _rotation, Service _s_inf)
    {
        this.salaire = _salaire;
        this.rotation = _rotation;
        this.s_inf = _s_inf;
    }

    /**
     * METHODE : setter - lire l'attribut salaire
     * @return salaire
     */
    public float getSalaire()
    {
        return salaire;
    }
    
    /**
     * METHODE : setter - lire l'attribut rotation
     * 0 = JOUR & 1 = NUIT
     * @return 
     */
    public boolean getRotation() {
        return rotation;
    }

    /**
     * METHODE : setter - lire l'attribut service
     * @return service
     */
    public Service getService_inf() {
        return s_inf;
    }

    /**
     * METHODE : getter - modifier l'attribut salaire
     * @param salaire 
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    /**
     * METHODE : getter - modifier l'attribut rotation
     * @param rotation 
     */
    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }

    /**
     * METHODE : getter - modifier l'attribut service
     * @param s_inf 
     */
    public void setS_inf(Service s_inf) {
        this.s_inf = s_inf;
    }

            
}
