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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class panelUpdate extends JPanel {
    
    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();
  
    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"CARD_1", "CARD_2", "CARD_3","CARD_4"};
    int indice = 0;
    
    
    
    
    public panelUpdate() {
      //On définit le layout à utiliser sur le content pane
    this.setLayout(new GridLayout(3,2));
    
    
    //On crée trois conteneurs de couleur différente
    //Find
    panelUpdateChambre card1 = new panelUpdateChambre();
    card1.setBorder(BorderFactory.createTitledBorder("Mise à jour d'une Chambre"));
    //Update
    panelUpdateMalade card2 = new panelUpdateMalade();
    card2.setBorder(BorderFactory.createTitledBorder("Mise à jour d'un Malade")) ;
    panelUpdateInfirmier card3 = new panelUpdateInfirmier();
    card3.setBorder(BorderFactory.createTitledBorder("Mise à jour d'un Infirmier"));
    //Delete
    panelUpdateDocteur card4 = new panelUpdateDocteur();
    card4.setBorder(BorderFactory.createTitledBorder("Mise à jour d'un Docteur"));
    
    JPanel boutonPane = new JPanel();
    JPanel s=new JPanel();
    s.setLayout(new GridLayout(0,1));
    s.setPreferredSize(new Dimension(150,150));
    
    // REMPLISSAGE DU BOUTONPANE
    JButton bouton_chambre = new JButton("Chambre");
    //boutonPane.add(bouton_chambre,GridLayout.CENTER);
    JButton bouton_malade = new JButton("Malade");
    JButton bouton_infirmier = new JButton("Infirmier");
    JButton bouton_docteur = new JButton("Docteur");
    
    //On ajoute le bouton au content pane de la JFrame 
    s.add(bouton_chambre); 
    s.add(bouton_malade); 
    s.add(bouton_infirmier); 
    s.add(bouton_docteur); 
    
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

    boutonPane.add(s,BorderLayout.CENTER);
    add(boutonPane, BorderLayout.CENTER);
    add(content, BorderLayout.SOUTH);
    this.setVisible(true);
   
}
    
}

