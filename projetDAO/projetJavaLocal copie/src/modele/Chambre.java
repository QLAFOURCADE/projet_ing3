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
public class Chambre {
    
    /**
     * les attributs
     */
    private int num_ch;
    private int nb_lits;
    private int surveillant;
    private String code_service;
    
    
    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
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
     * METHODE : Constructeur surchargé 4 param
     * @param code_service
     * @param num_ch
     * @param surveillant
     * @param nb_lits 
     */
     public Chambre(String code_service, int num_ch, int surveillant, int nb_lits){
        this.num_ch = num_ch;
        this.nb_lits = nb_lits;
        this.surveillant = surveillant;
        this.code_service=code_service;
           
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
    
     
    
    /**
     * METHODE : lire l'attribut code du service
     * @return 
     */
    public String getCodeService()
    {
        return code_service;
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
     * METHODE : lire l'attribut ID du surveillant
     * @return 
     */
    public int getIdSurveillant()
    {
        return surveillant;
    }
    
    
    /**
     * METHODE : modifier l'attribut ID du surveillant 
     * @param idSurveillant 
     */
    public void setIdSurveillant(int idSurveillant)
    {
        this.surveillant=idSurveillant;
    }
    
    
    /**
     * METHODE : pour ecrire les éléments de cette classe - toString
     * @return 
     */
     @Override
    public String toString() {
        return "\n"+ "Numero de chambre : " + num_ch + "\n" + "Nombre de lits : " + nb_lits + "\n" + "Surveillant : " + surveillant + "\n" + 
                "Code Service : " + code_service + "\n";
    }   
    
    
    
}
