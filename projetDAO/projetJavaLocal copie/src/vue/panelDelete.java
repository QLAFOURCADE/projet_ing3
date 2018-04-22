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

public class panelDelete extends JPanel {
    
    CardLayout cl = new CardLayout();
    JPanel content = new JPanel();
  
    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"CARD_1", "CARD_2", "CARD_3","CARD_4","CARD_5", "CARD_6", "CARD_7"};
    int indice = 0;
    
    
    
    
    public panelDelete() {
      //On définit le layout à utiliser sur le content pane
    this.setLayout(new GridLayout(3,2));
    
    
    //On crée trois conteneurs de couleur différente
    //Chambre
    panelDeleteChambre card1 = new panelDeleteChambre();
    card1.setBackground(Color.blue);	
    //Malade
    panelDeleteMalade card2 = new panelDeleteMalade();
    card2.setBackground(Color.red);	
    //Infirmier
    panelDeleteInfirmier card3 = new panelDeleteInfirmier();
    card3.setBackground(Color.green);
    //Docteur
    panelDeleteDocteur card4 = new panelDeleteDocteur();
    card4.setBackground(Color.yellow);
    //Service
    panelDeleteService card5 = new panelDeleteService();
    card5.setBackground(Color.pink);
    //Soigne
    panelDeleteSoigne card6 = new panelDeleteSoigne();
    card6.setBackground(Color.orange);
    //Hospitalisation
    panelDeleteHospitalisation card7 = new panelDeleteHospitalisation();
    card7.setBackground(Color.cyan);
    
    JPanel boutonPane = new JPanel();
    
    // REMPLISSAGE DU BOUTONPANE
    JButton bouton_chambre = new JButton("Chambre");
    JButton bouton_malade = new JButton("Malade");
    JButton bouton_infirmier = new JButton("Infirmier");
    JButton bouton_docteur = new JButton("Docteur");
    JButton bouton_service = new JButton("Service");
    JButton bouton_soigne = new JButton("Soigne");
    JButton bouton_hospitalisation = new JButton("Hospitalisation");
    
    //On ajoute le bouton au content pane de la JFrame 
    boutonPane.add(bouton_chambre); 
    boutonPane.add(bouton_malade); 
    boutonPane.add(bouton_infirmier); 
    boutonPane.add(bouton_docteur); 
    boutonPane.add(bouton_service);
    boutonPane.add(bouton_soigne); 
    boutonPane.add(bouton_hospitalisation); 
    
    
    //Définition de l'action du bouton chambre
    bouton_chambre.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
        //changePanel(card1);
        cl.show(content, listContent[0]);
      }
    });
    
    //Définition de l'action du bouton malade
    bouton_malade.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[1]);
      }
    });
    
      
    //Définition de l'action du bouton infirmier
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
    
     //Définition de l'action du bouton soigne
    bouton_soigne.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[5]);
      
      }
    });
    
    //Définition de l'action du bouton hospitalisation
    bouton_hospitalisation.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[6]);
      
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
    content.add(card6, listContent[5]);
    content.add(card7, listContent[6]);

    add(boutonPane, BorderLayout.CENTER);
    add(content, BorderLayout.SOUTH);
    this.setVisible(true);
   
}
    
}

