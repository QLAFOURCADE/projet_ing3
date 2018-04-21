/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Quiterie
 */
public class MAJ {
    
    private static Connexion co;
    
    /**
     * CONSTRUCTEUR
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public MAJ() throws SQLException, ClassNotFoundException
    {
        MAJ.co = new Connexion("hopital", "root", "");        
    }
    
    /**
     *  METHODE : réaliser les requetes avec les attributs récupérés 
     * @param table
     * @param cle
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param att_sup
     * @return 
     */
    public String[] insert_general(String table, String cle, String nom, String prenom, String adresse, String tel, String[] att_sup)
    {
        String[] requete = {""};
        if ("docteur".equals(table))
        {
            Docteur d_tamp = new Docteur();
            String att_spe = att_sup[0];
            requete = d_tamp.insert_doc(cle, nom, prenom, adresse, tel, att_spe);
            return requete;
        }
        if ("infirmier".equals(table))
        {
            Infirmier i_tamp = new Infirmier();
            String rotation = att_sup[0];
            String salaire = att_sup[1];
            String code_serv = att_sup[2];
            requete = i_tamp.insert_inf(cle, nom, prenom, adresse, tel, rotation, salaire, code_serv);
            return requete;
        }
        if("malade".equals(table))
        {
            Malade m_tamp = new Malade();
            String mutuelle = att_sup[0];
            requete = m_tamp.insert_malade(cle, nom, prenom, adresse, tel, mutuelle);
            return requete;
        }
        return requete;
    }
    
}
