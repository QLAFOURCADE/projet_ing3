/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

  CardLayout cl = new CardLayout();
  JPanel content = new JPanel();
  
  //Liste des noms de nos conteneurs pour la pile de cartes
  String[] listContent = {"CARD_1", "CARD_2", "CARD_3","CARD_4"};
  int indice = 0;

  public Fenetre(){
      
    this.setTitle("Gestion Hopital");
    this.setSize(600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
		
    //On crée trois conteneurs de couleur différente
    //Find
    panelFind card1 = new panelFind();
    card1.setBackground(Color.blue);	
    //Update
    panelUpdate card2 = new panelUpdate();
    card2.setBackground(Color.red);	
    //Create
    panelCreate card3 = new panelCreate();
    card3.setBackground(Color.green);
    //Delete
    panelDelete card4 = new panelDelete();
    card4.setBackground(Color.yellow);

    JPanel boutonPane = new JPanel();
    
    // REMPLISSAGE DU BOUTONPANE
    JButton bouton_find = new JButton("Find");
    JButton bouton_update = new JButton("Update");
    JButton bouton_create = new JButton("Create");
    JButton bouton_delete = new JButton("Delete");
            
    
    //Définition de l'action du bouton find
    bouton_find.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
        //changePanel(card1);
        cl.show(content, listContent[0]);
      }
    });
    
    //Définition de l'action du bouton Update
    bouton_update.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[1]);
      }
    });
    
    //Définition de l'action du bouton Create
    bouton_create.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[2]);
      }
    });
    
    //Définition de l'action du bouton Delete
    bouton_delete.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        //Via cette instruction, on passe au prochain conteneur de la pile
         cl.show(content, listContent[3]);
      }
    });
	
		
    //Retour	
    boutonPane.add(bouton_find);
    boutonPane.add(bouton_update);
    boutonPane.add(bouton_create);
    boutonPane.add(bouton_delete);

    //On définit le layout
    content.setLayout(cl);
    //boutonPane.setLayout(new BorderLayout());
    
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(card1, listContent[0]);
    content.add(card2, listContent[1]);
    content.add(card3, listContent[2]);
    content.add(card4, listContent[3]);

    this.getContentPane().add(boutonPane, BorderLayout.NORTH);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
  }	

}