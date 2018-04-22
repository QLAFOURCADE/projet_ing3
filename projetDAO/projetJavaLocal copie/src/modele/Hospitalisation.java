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
public class Hospitalisation {
    
    /**
     * les attributs
     */
    private int no_malade;
    private String code_service;
    private int no_chambre;
    private int lit;
  
    
    //Constructeur 
    public Hospitalisation(){};
    
    
    //Constructeur surchargé 4 param
     public Hospitalisation(int no_malade, String code_service, int no_chambre, int lit){
        this.no_malade = no_malade;
        this.no_chambre = no_chambre;
        this.lit = lit;
        this.code_service=code_service;
           
    }


    //Get Numero Malade
    public int getNo_Malade() {
        return no_malade;
    }

    //Get Numero Chambre
    public int getNo_Chambre() {
        return no_chambre;
    }
    
    //Get Service
    public String getCodeService()
    {
        return code_service;
    }
    
    //Get Lit
    public int getLit()
    {
        return lit;
    }
    

    //Set Numero de Chambre
    public void setNo_Chambre(int no_chambre) {
        this.no_chambre = no_chambre;
    }

    //Set Lit
    public void setLit(int lit) {
        this.lit = lit;
    }
    

    
    //Set Service
    public void setCodeService(String codeService)
    {
        this.code_service=codeService;
    }
    
   
    //Set Numero malade
    public void setNo_Malade(int no_malade)
    {
        this.no_malade=no_malade;
    }
    
    //Tostring
     @Override
    public String toString() {
        return "";
    }   
    
    
    
}
