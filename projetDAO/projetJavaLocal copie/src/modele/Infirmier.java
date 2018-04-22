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
public class Infirmier extends Employe {
    
    /**
     * les attributs
     */ 
    private int numero;
    private String code_service;
    private String rotation; // 0 - JOUR & 1 - NUIT
    private int salaire;
    

    /**
     * CONSTRUCTEUR
     */
    public Infirmier(){};
    
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
    public Infirmier(int numero,String code_service, String rotation,  int salaire )
    {
        this.numero = numero;
        this.salaire = salaire;
        this.rotation = rotation;
        this.code_service = code_service;
    }

    
    /**
     * METHODE : getter - lire l'attribut numero
     * @return numero
     */
    public int getNumero()
    {
        return numero;
    }
    
    
    /**
     * METHODE : getter - lire l'attribut salaire
     * @return salaire
     */
    public int getSalaire()
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
     * METHODE : getter - lire l'attribut code_service
     * @return code_service
     */
    public String getCodeService()
    {
        return code_service;
    }
   
    
     /**
     * METHODE : setter - modifier l'attribut numero
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * METHODE : setter - modifier l'attribut salaire
     * @param salaire 
     */
    public void setSalaire(int salaire) {
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
     * METHODE : setter - modifier l'attribut code_service
     * @param code_service 
     */
    public void setCodeService(String code_service) {
        this.code_service = code_service;
    }

            
}
