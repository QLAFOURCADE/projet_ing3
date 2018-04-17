/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionListener;
import javax.swing.Box;
import static javax.swing.Box.createVerticalBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tiphaine Plusquellec
 */
public class Menu extends JFrame {
    
    private JButton bouton = new JButton("ESPACE ADMINISTRATIF DE L'HOPITAL");
    private JButton bouton1 = new JButton("Quitter");
    private JPanel Recherche= new JPanel();
    private JPanel Ajout_Suppr= new JPanel();
    
       
       public Menu(){
                this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL");
                this.setSize(600, 300);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                Recherche.setBackground(Color.BLUE);
                Ajout_Suppr.setBackground(Color.BLUE);
                
                // Disposition des boutons en grille
                //this.setLayout(new GridLayout(3, 2));
                //GridLayout gl = new GridLayout();
                //gl.setColumns(2);
                //gl.setRows(3);
                //this.setLayout(gl);
                
                Box b1= new createVerticalBox();
                b1.add(new JButton("Recherche"));
                b1.add(new JButton ("Ajouter/Supprimer"));
                
                //On ajoute le bouton au content pane de la JFrame
                this.getContentPane().add(bouton, BorderLayout.CENTER);
                this.getContentPane().add(bouton1, BorderLayout.SOUTH);
                
                this.setVisible(true);
  }     
    
    
}
    

