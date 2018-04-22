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
import DAO.HospitalisationDAO;
import modele.Hospitalisation;
import controleur.Connexion;
/**
 *
 * @author Pierre-Louis
 */
public class panelDeleteHospitalisation extends JPanel {
    
    
    public JTextField tno_malade;
    public JLabel no_malade;
    public JButton ok_ajouter;
    public int rno_malade;
    
    public panelDeleteHospitalisation(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une hospitalisation
        tno_malade = new JTextField(10);
        tno_malade.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
      // initialisation des JTextField
        no_malade = new JLabel("Numéro du malade: ");

      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(no_malade);
      fieldsPane.add(tno_malade);

      
      fieldsPane.setLayout(new GridLayout(1,2));
      
      this.add(fieldsPane);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Supprimer");
      this.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rno_malade = Integer.parseInt(tno_malade.getText());
         
        
        DAO<Hospitalisation> hospitalisationDao = new HospitalisationDAO(Connexion.getInstance());
        Hospitalisation h = new Hospitalisation(rno_malade, "",0,0);
        hospitalisationDao.delete(h);  
      }
    });
               
    }
}
