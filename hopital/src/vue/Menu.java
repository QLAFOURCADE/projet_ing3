/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import static javax.swing.Box.createVerticalBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tiphaine Plusquellec
 */
public class Menu extends JFrame implements ActionListener {

        // Les boutons
    private JButton bouton = new JButton("ESPACE ADMINISTRATIF DE L'HOPITAL");
    private JButton bouton1 = new JButton("Quitter");
    private ArrayList<JButton> list_button;
    private ArrayList<JPanel> list_Panel;
    private ArrayList<JButton> list_bouton_docteur;
   
    private JButton Ajout;
    // Les panels
    private JPanel gestion;
    private JPanel grille;
    private JPanel affichage;
    private JPanel formulaire;
    private JPanel card;
    private CardLayout cl;
    public Menu(){
        this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL");
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        // instantion des boutons
        grille = new JPanel(new GridLayout(0, 1));
        list_button=new ArrayList<>();
        list_button.add(new JButton("Docteur"));
        list_button.add(new JButton("Employée"));
        list_button.add(new JButton("Malade"));
        list_button.add(new JButton("Infirmier"));
        list_button.add(new JButton("Chambre"));
        
        // instanier les boutons du docteurs
        list_bouton_docteur= new ArrayList<>();
        list_bouton_docteur.add(new JButton("numero"));
        list_bouton_docteur.add(new JButton("nom"));
        list_bouton_docteur.add(new JButton("prenom"));
        list_bouton_docteur.add(new JButton("adresse"));
        list_bouton_docteur.add(new JButton("tel"));
        list_bouton_docteur.add(new JButton("specialite"));
        list_bouton_docteur.add(new JButton ("Recherche") );
        
        // Remplissage du Panel Grille des boutons et initialisation de la fonction ActionListner
        
        for (JButton jButton : list_button) {
            grille.add(jButton);
            jButton.addActionListener((ActionListener) this);
        }
        
        // Initialisation des Panel de chaque classe
        list_Panel=new ArrayList<>();
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        list_Panel.add(new JPanel(new GridLayout(0,1)));
        cl = new CardLayout();
        card=new JPanel(cl);
        
        for (JPanel jPanel : list_Panel) {
            card.add(jPanel);
        }
        this.add(card);
        
        // remplissage du Panel(0) correspondant à Docteur
        for (int i = 0; i < 10; i++) {
            list_Panel.get(0).add(new JLabel("eeee"));
            // Ajout des boutons dans le panel 0 correspondant à docteur
            list_Panel.get(0).add(list_bouton_docteur.get(0));
            list_Panel.get(0).add(list_bouton_docteur.get(1));
            list_Panel.get(0).add(list_bouton_docteur.get(2));
            list_Panel.get(0).add(list_bouton_docteur.get(3));
            list_Panel.get(0).add(list_bouton_docteur.get(4));
            list_Panel.get(0).add(list_bouton_docteur.get(5));
            list_Panel.get(0).add(list_bouton_docteur.get(6));
            // Ajout des fonctions Recherche et trier dans les boutons

        }
        list_Panel.get(1).setBackground(Color.blue);


       //
        Ajout= new JButton("Ajout");
        
        affichage= new JPanel();
        formulaire= new JPanel();
        
        
        // Premhopiier Panel Menu
        gestion = new JPanel(new GridLayout(0, 1));
        gestion.setBackground(Color.BLUE);
        gestion.add(Ajout);
        
        
        grille.setBackground(Color.RED);
        
        affichage = new JPanel(new GridLayout(0, 1));
        affichage.setBackground(Color.GREEN);

        this.add(grille, BorderLayout.EAST);
        this.add(gestion, BorderLayout.WEST);

        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(list_button.contains(e.getSource())) {
            
        for(int i=0; i< list_Panel.size(); i++){
            
        list_Panel.get(i).setVisible((list_button.get(i).equals(e.getSource())));
        }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}
    
        
        
    


