/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.TestHopital;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;*/
import javax.swing.*;
/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;*/

/**
 *
 * @author Quiterie
 */
public class Graphique extends JFrame {
    
    // CREATION D'UN PANEL CONNEXION
    
    public JPanel hop_connexion,po,option,p1;
    
    public JButton okay;
    public JTextField bdd;
    public JTextField login;
    public JTextField mdp;
    
    public ArrayList<JButton> button;
   
    public JPanel p2;
    public JPanel aff_consult;
    
    public int suite = 0;

    public Graphique() {
        
        
        // FENETRE
                this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL-ECE PARIS");
                this.setSize(1000,1000);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setLayout(new BorderLayout());
               // this.setResizable(true);
               // this.setVisible(true);
       
        okay= new JButton("Valider");
        button=new ArrayList<>();
    }
    
    /**
     * METHODE : afficher le premier panel : le menu de connexion 
     */
     //////////////////////////////CONNEXION/////////////////////////////////////////
    public void connexion()
    {
        po= new JPanel();
        p1= new JPanel();
                
        hop_connexion = new JPanel();
        hop_connexion.setPreferredSize(new Dimension(500,700));
        hop_connexion.setLayout(new GridLayout(0,1));
        hop_connexion.setBorder(BorderFactory.createTitledBorder("Connection au centre")); 
                        
        bdd= new JTextField("");
        bdd.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        login=new JTextField("");
        login.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                //login.setHorizontalAlignment(BorderLayout.CENTER);
        mdp=new JTextField("");
        mdp.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        // okay.addActionListener((ActionListener) this);
                
        hop_connexion.add(new JLabel("Nom de la base de données",JLabel.CENTER));
        hop_connexion.add(bdd);
        hop_connexion.add(new JLabel("Un login",JLabel.CENTER));
        hop_connexion.add(login);
        hop_connexion.add(new JLabel("Un mot de passe",JLabel.CENTER));
        hop_connexion.add(mdp);
        hop_connexion.add(okay);
        okay.setBackground(Color.GREEN);
        
               
        po.add(hop_connexion);
        //this.add(po, BorderLayout.CENTER);
        setContentPane(po);
    }
    
    /**
     * METHODE : afficher les options à l'utilisateur
     *              possible qu'après une bonne entrée des éléments de la connexion
     */
    public void panel_deux()
    {
        /////////////////////////// OPTIONS ///////////////////////////////////
                
        option= new JPanel();
        option.setPreferredSize(new Dimension(500,700));
        option.setLayout(new GridLayout(0,1));
        option.setBorder(BorderFactory.createTitledBorder("Que souhaitez vous faire?"));
            
        
        button.add(new JButton("CONSULTER"));
        button.add(new JButton("RECHERCHE"));
        button.add(new JButton("SUPPRIMER"));
        button.add(new JButton("AJOUTER"));
        button.add(new JButton("METTRE A JOUR"));
        button.add(new JButton("REPORTING"));
        
        for(int i=0; i<6; i++)
        {
            option.add(button.get(i));
        }
        
        po.removeAll();
        po.repaint();
        po.add(option, BorderLayout.CENTER);
        po.revalidate();
        //setContentPane(po);

    }
        
    //////////////////////// TAB CONSULTER //////////////////////////////////
 
                
   ////////////////////// AJOUT A LA FENETRE ////////////////////////////////
       
  
          
}

