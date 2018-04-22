/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.GridLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Imports pour requete
import DAO.DAO;
import DAO.SoigneDAO;
import modele.Soigne;
import controleur.Connexion;
/**
 *
 * @author Pierre-Louis
 */
public class panelCreateSoigne extends JPanel {
    
    
    public JTextField tno_docteur, tno_malade;
    public JLabel no_docteur, no_malade;
    public JButton ok_ajouter;
    public int rno_docteur, rno_malade;
    
    public panelCreateSoigne(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        tno_docteur = new JTextField(10);
        tno_docteur.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tno_malade = new JTextField(10);
        tno_malade.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
      // initialisation des JTextField
        no_docteur = new JLabel("Numéro du docteur: ");
        
        no_malade = new JLabel("Numéro malade : ");
            
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(no_docteur);
      fieldsPane.add(tno_docteur);
      fieldsPane.add(no_malade);
      fieldsPane.add(tno_malade);
      
      fieldsPane.setLayout(new GridLayout(2,4));
      
      this.add(fieldsPane);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Ajouter");
      this.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rno_malade = Integer.parseInt(tno_malade.getText());
        rno_docteur = Integer.parseInt(tno_docteur.getText());
      
        
        DAO<Soigne> soigneDao = new SoigneDAO(Connexion.getInstance());
        Soigne s = new Soigne(rno_docteur, rno_malade);
        soigneDao.create(s);  
      }
    });
               
    }
}
