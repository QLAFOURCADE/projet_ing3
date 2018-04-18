/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Pierre-Louis
 */
public class Chambre {
    
    /**
     * les attributs
     */
    private int num_ch;
    private int nb_lits;
    private int surveillant;
    private String code_service;
    
    
    //Constructeur 
    public Chambre(){};
    
    
    /**
     * CONSTRUCTEUR SURCHARGER
     * @param num_ch
     * @param nb_lits 
     */
    public Chambre(int num_ch, int nb_lits)
    {
        this.num_ch = num_ch;
        this.nb_lits = nb_lits;
    }

    /**
     * METHODE : lire l'attribut numero de la chambre
     * @return num_ch
     */
    public int getNum_ch() {
        return num_ch;
    }

    /**
     * METHODE : lire l'attribut nombre de lits
     * @return nb_lits
     */
    public int getNb_lits() {
        return nb_lits;
    }

    /**
     * METHODE : modifier l'attribut numero de la chambre
     * @param num_ch 
     */
    public void setNum_ch(int num_ch) {
        this.num_ch = num_ch;
    }

    /**
     * METHODE : modifier l'attribut nombre de lits
     * @param nb_lits 
     */
    public void setNb_lits(int nb_lits) {
        this.nb_lits = nb_lits;
    }
    
    
}
