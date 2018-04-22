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
    String[] listContent = {"CARD_1", "CARD_2", "CARD_3","CARD_4", "CARD_5"};
    int indice = 0;
    
    
    
    
    public panelCreate() {
      //On définit le layout à utiliser sur le content pane
    this.setLayout(new GridLayout(3,2));
    
    
    //On crée trois conteneurs de couleur différente
    //Chambre
    panelCreateChambre card1 = new panelCreateChambre();
    card1.setBackground(Color.blue);	
    //Malade
    panelCreateMalade card2 = new panelCreateMalade();
    card2.setBackground(Color.red);	
    //Infirmier
    panelCreateInfirmier card3 = new panelCreateInfirmier();
    card3.setBackground(Color.green);
    //Docteur
    panelCreateDocteur card4 = new panelCreateDocteur();
    card4.setBackground(Color.yellow);
    //Service
    panelCreateService card5 = new panelCreateService();
    card5.setBackground(Color.pink);
    
    JPanel boutonPane = new JPanel();
    
    // REMPLISSAGE DU BOUTONPANE
    JButton bouton_chambre = new JButton("Chambre");
    JButton bouton_malade = new JButton("Malade");
    JButton bouton_infirmier = new JButton("Infirmier");
    JButton bouton_docteur = new JButton("Docteur");
    JButton bouton_service = new JButton("Service");
    
    //On ajoute le bouton au content pane de la JFrame 
    boutonPane.add(bouton_chambre); 
    boutonPane.add(bouton_malade); 
    boutonPane.add(bouton_infirmier); 
    boutonPane.add(bouton_docteur); 
    boutonPane.add(bouton_service); 
    
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
    
    
     //Définition de l'action du bouton docteur
    bouton_docteur.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[3]);
      
      }
    });
    
     //Définition de l'action du bouton service
    bouton_service.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[4]);
      
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
    content.add(card5, listContent[4]);

    add(boutonPane, BorderLayout.CENTER);
    add(content, BorderLayout.SOUTH);
    this.setVisible(true);
   
}
    
}

