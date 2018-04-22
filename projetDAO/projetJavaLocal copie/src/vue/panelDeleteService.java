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
import DAO.ServiceDAO;
import modele.Service;
import controleur.Connexion;
/**
 *
 * @author Pierre-Louis
 */
public class panelDeleteService extends JPanel {
    
    
    public JTextField tcode;
    public JLabel code;
    public JButton ok_ajouter;
    public String rcode;
    
    public panelDeleteService(){
        
      // ajouter des boites de texte pour que l'utilisateur supprime un service
        tcode = new JTextField(10);
        tcode.setHorizontalAlignment((int) CENTER_ALIGNMENT);
       
        
      // initialisation des JTextField
        code = new JLabel("Code Service : ");
        
     
     
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(code);
      fieldsPane.add(tcode);
 
      
      fieldsPane.setLayout(new GridLayout(1,4));
      
      this.add(fieldsPane);
      
      
      //bouton Supprimer
      JButton ajouter = new JButton("Supprimer");
      this.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rcode = tcode.getText();
       
        DAO<Service> serviceDao = new ServiceDAO(Connexion.getInstance());
        Service s = new Service(rcode, "", "", "");
        serviceDao.delete(s);
       
      
      }
    });
               
    }
}
