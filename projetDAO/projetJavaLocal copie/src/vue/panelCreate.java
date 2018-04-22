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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class panelCreate extends JPanel {
    
    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();
  
    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"CARD_1", "CARD_2", "CARD_3","CARD_4"};
    int indice = 0;
    
    
    
    
    public panelCreate() {
      //On définit le layout à utiliser sur le content pane
    this.setLayout(new GridLayout(3,2));
    
    
    //On crée trois conteneurs de couleur différente
    //Find
    panelCreateChambre card1 = new panelCreateChambre();
    card1.setBackground(Color.blue);	
    //Update
    panelCreateMalade card2 = new panelCreateMalade();
    card2.setBackground(Color.red);	
    //Create
    panelCreateInfirmier card3 = new panelCreateInfirmier();
    card3.setBackground(Color.green);
    //Delete
    panelCreateDocteur card4 = new panelCreateDocteur();
    card4.setBackground(Color.yellow);
    
    JPanel boutonPane = new JPanel();
    
    // REMPLISSAGE DU BOUTONPANE
    JButton bouton_chambre = new JButton("chambre");
    JButton bouton_malade = new JButton("malade");
    JButton bouton_infirmier = new JButton("infirmier");
    JButton bouton_docteur = new JButton("docteur");
    
    //On ajoute le bouton au content pane de la JFrame 
    boutonPane.add(bouton_chambre); 
    boutonPane.add(bouton_malade); 
    boutonPane.add(bouton_infirmier); 
    boutonPane.add(bouton_docteur); 
    
    //Définition de l'action du bouton find
    bouton_chambre.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
        //changePanel(card1);
        cl.show(content, listContent[0]);
      }
    });
    
    //Définition de l'action du bouton Update
    bouton_malade.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[1]);
      }
    });
    
      
    //Définition de l'action du bouton Update
    bouton_infirmier.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[2]);
      }
    });
    
    
     //Définition de l'action du bouton malade
    bouton_docteur.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[3]);
      
      }
    });
    
    //On définit le layout
    content.setLayout(cl);
    //boutonPane.setLayout(new BorderLayout());
    
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(card1, listContent[0]);
    content.add(card2, listContent[1]);
    content.add(card3, listContent[2]);
    content.add(card4, listContent[3]);

    add(boutonPane, BorderLayout.CENTER);
    add(content, BorderLayout.SOUTH);
    this.setVisible(true);
   
}
    
}

