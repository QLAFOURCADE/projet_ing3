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
public class Docteur extends Employe{
    
    private String specialite;

    public Docteur(int numero, String nom, String prenom, String adresse, String tel) {
        super(numero, nom, prenom, adresse, tel);
    }
    
    
}
