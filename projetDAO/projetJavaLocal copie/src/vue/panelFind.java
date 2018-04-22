/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author Pierre-Louis
 */
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class panelFind extends JPanel {
    
    
    public panelFind() {
    //On définit le layout à utiliser sur le content pane
    this.setLayout(new GridLayout(3,2));
    
    
    
    // REMPLISSAGE DU BOUTONPANE
    JButton bouton_chambre = new JButton("chambre");
    JButton bouton_malade = new JButton("malade");
    JButton bouton_infirmier = new JButton("infirmier");
    JButton bouton_docteur = new JButton("docteur");
    
    //On ajoute le bouton au content pane de la JFrame 
    add(bouton_chambre); 
    add(bouton_malade); 
    add(bouton_infirmier); 
    add(bouton_docteur); 
    
     //Définition de l'action du bouton find
    bouton_malade.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
      
       
        
      }
    });
   
}
    
}
