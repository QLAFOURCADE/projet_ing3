/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Pierre-Louis //fait
 */
public class Soigne {
    
    /**
     * les attributs
     */
    private int no_docteur, no_malade;
    
  
    //Constructeur 
    public Soigne(){};
    
    
    //Constructeur surchargé 4 param
     public Soigne(int no_docteur, int no_malade){
        this.no_malade = no_malade;
        this.no_docteur = no_docteur;
           
    }


    //Get Numero Malade
    public int getNo_Malade() {
        return no_malade;
    }

    //Get Numero Docteur
    public int getNo_Docteur() {
        return no_docteur;
    }
    
    //Set Numero Malade
    public void setNo_Malade(int no_malade) {
        this.no_malade = no_malade;
    }

    //Set Lit
    public void setDocteur(int no_docteur) {
        this.no_docteur = no_docteur;
    }
    
    //Tostring
     @Override
    public String toString() {
        return "";
    }   
    
    
    
}
