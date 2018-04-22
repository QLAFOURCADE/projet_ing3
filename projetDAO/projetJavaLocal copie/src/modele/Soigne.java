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
public class Soigne {
    
    /**
     * les attributs
     */
    private int no_docteur, no_malade;
    
  
    /**
     * CONSTRUCTEUR
     */
    public Soigne(){};
    
    
    /**
     * CONSTRUCTEUR PAR DEFAUT 
     * @param no_docteur
     * @param no_malade 
     */
     public Soigne(int no_docteur, int no_malade){
        this.no_malade = no_malade;
        this.no_docteur = no_docteur;
           
    }

     
     /**
      * METHODES : getter - lire l'attribut numero du malade
      * @return 
      */
    public int getNo_Malade() {
        return no_malade;
    }

    
    /**
     * METHODES : getter - lire l'attribut numero du docteur 
     * @return 
     */
    public int getNo_Docteur() {
        return no_docteur;
    }
    
    
    /**
     * METHODES : setter - modifier l'attribut numero malade
     * @param no_malade 
     */
    public void setNo_Malade(int no_malade) {
        this.no_malade = no_malade;
    }

    
    /**
     * METHODES : setter - modifier l'attribut docteur 
     * @param no_docteur 
     */
    public void setDocteur(int no_docteur) {
        this.no_docteur = no_docteur;
    }
    
    
    /**
     * METHODE pour console ( pas grand utile ici )
     * @return 
     */
     @Override
    public String toString() {
        return "";
    }   
    
    
    
}
