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
    private JButton bg;
    private JButton bg1;
    private JButton bg2;
    private JButton bg3;
    private JButton bg4;
    private JButton bg5;
    private JButton bg6;
    private JButton bg7;
    
    private JPanel gestion;
    private JPanel grille;
    private JPanel affichage;
    private JButton Recherche;
    private JButton Ajout_Suppr;

    public Menu() {
        this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL");
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        bg= new JButton("Docteur");
        bg1= new JButton("Infirmier");
        bg2= new JButton("Service");
        bg3= new JButton("Employee");
        bg4= new JButton("Hospitalisation");
        bg5= new JButton("Soigne");
        bg6= new JButton("Chambre");
        Recherche = new JButton("Recherche");
        Ajout_Suppr= new JButton("Ajout_Suppr");
        
        
        gestion = new JPanel(new GridLayout(0, 1));
        gestion.setBackground(Color.BLUE);
        gestion.add(Recherche);
        gestion.add(Ajout_Suppr);
        
        grille = new JPanel(new GridLayout(0, 1));
        grille.setBackground(Color.RED);
        grille.add(bg);
        grille.add(bg1);
        grille.add(bg2);
        grille.add(bg3);
        grille.add(bg4);
        grille.add(bg5);
        grille.add(bg6);
        affichage = new JPanel(new GridLayout(0, 1));
        affichage.setBackground(Color.GREEN);

        this.add(affichage, BorderLayout.EAST);
        this.add(grille, BorderLayout.CENTER);
        this.add(gestion, BorderLayout.WEST);

        // Disposition des boutons en grille
        //this.setLayout(new GridLayout(3, 2));
        //GridLayout gl = new GridLayout();
        //gl.setColumns(2);
        //gl.setRows(3);
        //this.setLayout(gl);
        /*Box b1 = new createVerticalBox();
        b1.add(new JButton("Recherche"));
        b1.add(new JButton("Ajouter/Supprimer"));

        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(bouton, BorderLayout.CENTER);
        this.getContentPane().add(bouton1, BorderLayout.SOUTH);*/
        this.pack();
        this.setVisible(true);
    }

}
