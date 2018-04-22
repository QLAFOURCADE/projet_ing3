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
import DAO.MaladeDAO;
import modele.Malade;
import controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;

/**
 *
 * @author Pierre-Louis
 */
public class panelDeleteMalade extends JPanel {
    
    
    public JTextField tNumero;
    public JLabel numero;
    public JButton ok_ajouter;
    public int rnumero;
    
    public panelDeleteMalade(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        tNumero = new JTextField(10);
        tNumero.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        
      // initialisation des JTextField
        numero = new JLabel("Numero du malade : ");
       
        
     
     
      JPanel fieldsPane = new JPanel();
      JPanel fieldsPane1 = new JPanel();
      fieldsPane1.setBorder(BorderFactory.createTitledBorder("Suppression d'un Malade"));
      fieldsPane1.setPreferredSize(new Dimension(580, 400));
      
      
      //Ajouter tous les éléments
      fieldsPane.add(numero);
      fieldsPane.add(tNumero);
      fieldsPane1.add(fieldsPane, BorderLayout.CENTER);
      fieldsPane.setLayout(new GridLayout(1,2));
      
      this.add(fieldsPane1);
      
      
      //bouton jouter
      JButton supprimer = new JButton("Supprimer");
      fieldsPane.add(supprimer);
      
       //Définition de l'action du bouton ajouter
      supprimer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rnumero = Integer.parseInt(tNumero.getText());
   
        
        
        //Inserer un nouveau Malade
        DAO<Malade> maladeDao = new MaladeDAO(Connexion.getInstance());
        Malade m = new Malade(rnumero, "", "", "","", "");
        maladeDao.delete(m);
        
        
    
      }
    });
               
    }
}
