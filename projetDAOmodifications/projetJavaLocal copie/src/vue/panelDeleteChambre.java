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
import DAO.ChambreDAO;
import modele.Chambre;
import controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.blue;
import java.awt.Dimension;
import javax.swing.BorderFactory;
/**
 *
 * @author Pierre-Louis
 */
public class panelDeleteChambre extends JPanel {
    
    
    public JTextField c_s, no_c;
    public JLabel code_service, no_chambre;
    public JButton ok_ajouter;
    public String rcode_service;
    public int rno_chambre;
    
    public panelDeleteChambre(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        c_s = new JTextField(10);
        c_s.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        no_c = new JTextField(10);
        no_c.setHorizontalAlignment((int) CENTER_ALIGNMENT);
       
        
      // initialisation des JTextField
        code_service = new JLabel("Code service : ");
        
        no_chambre = new JLabel("Numero chambre : ");
        
      
        
     
     
      JPanel fieldsPane = new JPanel();
      JPanel fieldsPane1 = new JPanel();
      
      
      
      
      
      
      fieldsPane1.setBorder(BorderFactory.createTitledBorder("Suppression d'une chambre"));
      
      fieldsPane1.setPreferredSize(new Dimension(580, 400));
      
      //Ajouter tous les éléments
      fieldsPane.add(code_service);
      fieldsPane.add(c_s);
      fieldsPane.add(no_chambre);
      fieldsPane.add(no_c);
      
      
      //bouton Supprimer
      JButton supprimer = new JButton("Supprimer");
      fieldsPane.add(supprimer);
      fieldsPane1.add(fieldsPane, BorderLayout.CENTER);
      
      
      fieldsPane.setLayout(new GridLayout(1,2));
      
      this.add(fieldsPane1);
      
      
      
      
       //Définition de l'action du bouton ajouter
      supprimer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rcode_service = c_s.getText();
        rno_chambre = Integer.parseInt(no_c.getText());
     
        
        DAO<Chambre> chambreDao = new ChambreDAO(Connexion.getInstance());
        Chambre c = new Chambre(rcode_service, rno_chambre, 1, 1);
        chambreDao.delete(c);
      
      }
    });
               
    }
}
