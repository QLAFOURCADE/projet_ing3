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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import static javax.swing.Box.createVerticalBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private ArrayList<JButton> list_bouton_employee;
    private ArrayList<JButton> list_bouton_malade;
    private ArrayList<JButton> list_bouton_infirmier;
    private ArrayList<JButton> list_bouton_chambre;
   
    private JButton Ajout;
    private JButton Ajout1;
    
    // Les panels
    private JPanel gestion;
    private JPanel grille;
    private JPanel affichage;
    // Les Formulaires
    private JPanel formulaire;
    private JPanel formulaire1;
    // POUR AJOUT EMPLOYEE
     private ArrayList<JTextField>jemployee;
     private ArrayList<JLabel> lemployee;
    // POUR AJOUT MALADE
     private ArrayList<JTextField>jmalade;
     private ArrayList<JLabel> lmalade;

    
    
    private JPanel card;
    private CardLayout cl;
    public Menu(){
        
        
        
        this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL");
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        
////////////////////////////////////////////////////////////////////////////////
//                              PANEL GRILLE                                  //
////////////////////////////////////////////////////////////////////////////////
        
        // instantion des boutons
        grille = new JPanel(new GridLayout(0, 1));
        grille.setBackground(Color.RED);
        
        list_button=new ArrayList<>();
        list_button.add(new JButton("Docteur"));
        list_button.add(new JButton("Employée"));
        list_button.add(new JButton("Malade"));
        list_button.add(new JButton("Infirmier"));
        list_button.add(new JButton("Chambre"));
        
        // instancier les boutons du docteurs
        list_bouton_docteur= new ArrayList<>();
        list_bouton_docteur.add(new JButton("numero"));
        list_bouton_docteur.add(new JButton("nom"));
        list_bouton_docteur.add(new JButton("prenom"));
        list_bouton_docteur.add(new JButton("adresse"));
        list_bouton_docteur.add(new JButton("tel"));
        list_bouton_docteur.add(new JButton("specialite"));
        list_bouton_docteur.add(new JButton ("Recherche") );
        
        // instancier les boutons employee
        list_bouton_employee= new ArrayList<>();
        list_bouton_employee.add(new JButton("numero"));
        list_bouton_employee.add(new JButton("nom"));
        list_bouton_employee.add(new JButton("prenom"));
        list_bouton_employee.add(new JButton("adresse"));
        list_bouton_employee.add(new JButton("tel"));
        list_bouton_employee.add(new JButton ("Recherche") );
        
        // instancier les boutons malade
        list_bouton_malade= new ArrayList<>();
        list_bouton_malade.add(new JButton("numero"));
        list_bouton_malade.add(new JButton("nom"));
        list_bouton_malade.add(new JButton("prenom"));
        list_bouton_malade.add(new JButton("adresse"));
        list_bouton_malade.add(new JButton("tel"));
        list_bouton_malade.add(new JButton("mutuelle"));
        list_bouton_malade.add(new JButton ("Recherche") );
        
        // instancier les boutons infirmier
        list_bouton_infirmier= new ArrayList<>();
        list_bouton_infirmier.add(new JButton("salaire"));
        list_bouton_infirmier.add(new JButton("rotation"));
        list_bouton_infirmier.add(new JButton("service"));
        list_bouton_infirmier.add(new JButton ("Recherche") );
        
        // instancier les boutons chambre
       list_bouton_chambre= new ArrayList<>();
       list_bouton_chambre.add(new JButton("numero de chambre"));
       list_bouton_chambre.add(new JButton("nombre de lits"));
       list_bouton_chambre.add(new JButton ("Recherche") );
        
        
        
        
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
        
        // remplissage du panel(1) correspondant aux employees
        
        for (int i = 0; i < 10; i++) {
            list_Panel.get(1).add(new JLabel("eeee"));
            // Ajout des boutons dans le panel 0 correspondant à docteur
            list_Panel.get(1).add(list_bouton_employee.get(0));
            list_Panel.get(1).add(list_bouton_employee.get(1));
            list_Panel.get(1).add(list_bouton_employee.get(2));
            list_Panel.get(1).add(list_bouton_employee.get(3));
            list_Panel.get(1).add(list_bouton_employee.get(4));
            list_Panel.get(1).add(list_bouton_employee.get(5));
            
            // Ajout des fonctions Recherche et trier dans les boutons

        }
        
        // remplissage du panel (2) correspondant malade
        
         for (int i = 0; i < 10; i++) {
            list_Panel.get(2).add(new JLabel("eeee"));
            // Ajout des boutons dans le panel 0 correspondant à docteur
            list_Panel.get(2).add(list_bouton_malade.get(0));
            list_Panel.get(2).add(list_bouton_malade.get(1));
            list_Panel.get(2).add(list_bouton_malade.get(2));
            list_Panel.get(2).add(list_bouton_malade.get(3));
            list_Panel.get(2).add(list_bouton_malade.get(4));
            list_Panel.get(2).add(list_bouton_malade.get(5));
            list_Panel.get(2).add(list_bouton_malade.get(6));
            // Ajout des fonctions Recherche et trier dans les boutons

        }
        
        // remplissage du panel (3) correspondant infirmier
         for (int i = 0; i < 10; i++) {
            list_Panel.get(3).add(new JLabel("eeee"));
            // Ajout des boutons dans le panel 0 correspondant à docteur
            list_Panel.get(3).add(list_bouton_infirmier.get(0));
            list_Panel.get(3).add(list_bouton_infirmier.get(1));
            list_Panel.get(3).add(list_bouton_infirmier.get(2));
            list_Panel.get(3).add(list_bouton_infirmier.get(3));
           
            
            // Ajout des fonctions Recherche et trier dans les boutons

        }
         
        // remplissage de Panel(4) correspondant à chambre
        
         for (int i = 0; i < 10; i++) {
            list_Panel.get(4).add(new JLabel("eeee"));
            // Ajout des boutons dans le panel 0 correspondant à docteur
            list_Panel.get(4).add(list_bouton_chambre.get(0));
            list_Panel.get(4).add(list_bouton_chambre.get(1));
            list_Panel.get(4).add(list_bouton_chambre.get(2));
           
            
            // Ajout des fonctions Recherche et trier dans les boutons

        }
        
////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////
//                                PANEL GESTION                               //
////////////////////////////////////////////////////////////////////////////////
       
        // Initialisation du Panel gestion contenant les boutons Ajout
        gestion = new JPanel(new GridLayout(0, 1));
        Ajout= new JButton("Ajout employee");
        Ajout1= new JButton("Ajout malade");
        gestion.setBackground(Color.BLUE);
        // Ajout du bouton "Ajout" dans le Panel Gestion
        gestion.add(Ajout);
        gestion.add(Ajout1);
        Ajout.addActionListener((ActionListener)this);
        Ajout1.addActionListener((ActionListener)this);
        
        // Initialisation du Panel Formulaire de Ajout employee
        formulaire= new JPanel();
        formulaire.setBorder(BorderFactory.createTitledBorder("Ajouter un employée")); 
        
        // Initialisation du Panel Formulaire de Ajout malade
        formulaire1= new JPanel();
        formulaire1.setBorder(BorderFactory.createTitledBorder("Ajouter un malade")); 
        
        
        // CREATION DU FORMULAIRE AJOUT EMPLOYEE
        
        //nom.setPreferredSize(new Dimension(150, 30));
        jemployee=new ArrayList<>();
        jemployee.add(new JTextField("Rentrez votre valeur"));
        jemployee.add(new JTextField("Rentrez votre valeur"));
        jemployee.add(new JTextField("Rentrez votre valeur"));
        jemployee.add(new JTextField("Rentrez votre valeur"));
        jemployee.add(new JTextField("Rentrez votre valeur"));
        
        
        lemployee=new ArrayList<>();
        lemployee.add(new JLabel("Un numero"));
        lemployee.add(new JLabel("Un nom"));
        lemployee.add(new JLabel("Un prenom"));
        lemployee.add(new JLabel("Une adresse"));
        lemployee.add(new JLabel("Un télépone"));
        
        
        for(int i=0; i<5; i++){
        formulaire.add(lemployee.get(i));
        formulaire.add(jemployee.get(i));
        }
        
        
      // CREATION DU FORMULAIRE AJOUT MALADE
      
        jmalade=new ArrayList<>();
        jmalade.add(new JTextField("Rentrez votre valeur"));
        jmalade.add(new JTextField("Rentrez votre valeur"));
        jmalade.add(new JTextField("Rentrez votre valeur"));
        jmalade.add(new JTextField("Rentrez votre valeur"));
        jmalade.add(new JTextField("Rentrez votre valeur"));
        
        
        lmalade=new ArrayList<>();
        lmalade.add(new JLabel("Un numero"));
        lmalade.add(new JLabel("Un nom"));
        lmalade.add(new JLabel("Un prenom"));
        lmalade.add(new JLabel("Une adresse"));
        lmalade.add(new JLabel("Un télépone"));
        lmalade.add(new JLabel("Une mutuelle"));
        
        for(int i=0; i<5; i++){
        formulaire1.add(lmalade.get(i));
        formulaire1.add(jmalade.get(i));
        }
        
        
        
        
        
        
        
        
        affichage= new JPanel();
        affichage = new JPanel(new GridLayout(0, 1));
        affichage.setBackground(Color.GREEN);

//// AJOUT A LA FENETRE
        this.add(grille, BorderLayout.EAST);
        this.add(gestion, BorderLayout.WEST);
        this.add(formulaire, BorderLayout.NORTH);
        this.add(formulaire1,BorderLayout.SOUTH);
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
        if(Ajout.contains((Point) e.getSource())){
        Ajout.setVisible(Ajout.equals(e.getSource()));}
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}
    
        
        
    


