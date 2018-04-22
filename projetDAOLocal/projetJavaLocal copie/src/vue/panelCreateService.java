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
public class panelCreateService extends JPanel {
    
    
    public JTextField tcode, tnom, tbatiment, tdirecteur;
    public JLabel code, nom, batiment, directeur;
    public JButton ok_ajouter, retour_m_choix;
    public String rcode, rnom, rbatiment, rdirecteur;
    
    public panelCreateService(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        tcode = new JTextField(10);
        tcode.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tnom = new JTextField(10);
        tnom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tbatiment = new JTextField(10);
        tbatiment.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tdirecteur = new JTextField(10);
        tdirecteur.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
      // initialisation des JTextField
        code = new JLabel("Code service : ");
        
        nom = new JLabel("Nom du service : ");
        
        batiment = new JLabel("Batiment du service : ");
        
        directeur = new JLabel("Directeur : ");
        
     
     
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(code);
      fieldsPane.add(tcode);
      fieldsPane.add(nom);
      fieldsPane.add(tnom);
      fieldsPane.add(batiment);
      fieldsPane.add(tbatiment);
      fieldsPane.add(directeur);
      fieldsPane.add(tdirecteur);
      
      
      fieldsPane.setLayout(new GridLayout(2,4));
      
      this.add(fieldsPane);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Ajouter");
      this.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rcode = tcode.getText();
        rnom = tnom.getText();
        rbatiment = tbatiment.getText();
        rdirecteur = tdirecteur.getText();
        
        DAO<Service> serviceDao = new ServiceDAO(Connexion.getInstance());
        Service s = new Service(rcode, rnom, rbatiment, rdirecteur);
        serviceDao.create(s);
       
      
      }
    });
               
    }
}
