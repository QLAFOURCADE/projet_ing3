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
public class Hospitalisation {
    
    /**
     * les attributs
     */
    private int no_malade;
    private String code_service;
    private int no_chambre;
    private int lit;
  
    
    /**
     * CONSTRUCTEUR PAR DEFAUT 
     */
    public Hospitalisation(){};
    

    /**
     * CONSTRUCTEUR SURCHARGE
     * @param no_malade
     * @param code_service
     * @param no_chambre
     * @param lit 
     */
     public Hospitalisation(int no_malade, String code_service, int no_chambre, int lit){
        this.no_malade = no_malade;
        this.no_chambre = no_chambre;
        this.lit = lit;
        this.code_service=code_service;
           
    }


     /**
      * METHODE : lire l'attribut numero du malade
      * @return 
      */
    public int getNo_Malade() {
        return no_malade;
    }

    
    /**
     * METHODE : lire l'attribut numero de la chambre
     * @return 
     */
    public int getNo_Chambre() {
        return no_chambre;
    }
    
    
    /**
     * METHODE : lire l'attribut code du service 
     * @return 
     */
    public String getCodeService()
    {
        return code_service;
    }
    
    
    /**
     * METHODE : lire l'attribut du nombre de lit
     * @return 
     */
    public int getLit()
    {
        return lit;
    }
    

    /**
     * METHODE : modifier l'attribut numero de la chambre
     * @param no_chambre 
     */
    public void setNo_Chambre(int no_chambre) {
        this.no_chambre = no_chambre;
    }

    
    /**
     * METHODE : modifier l'attribut nombre du lit 
     * @param lit 
     */
    public void setLit(int lit) {
        this.lit = lit;
    }
    

    /**
     * METHODE : modifier l'attribut code du service 
     * @param codeService 
     */
    public void setCodeService(String codeService)
    {
        this.code_service=codeService;
    }
    
    
    /**
     * METHODE : modifier l'attribut numero du malade
     * @param no_malade 
     */
    public void setNo_Malade(int no_malade)
    {
        this.no_malade=no_malade;
    }
    
    /**
     * METHODE pour la console
     * @return 
     */
    //Tostring
     @Override
    public String toString() {
        return "";
    }   
    
    
    
}
