/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Graphique extends JFrame implements ActionListener {
    
    // CREATION D'UN PANEL CONNEXION
    
    JPanel hop_connexion,po,option;
    
    JButton okay;
    JTextField bdd;
    JTextField login;
    JTextField mdp;
    
    private ArrayList<JButton> button;
    public ArrayList<String> renvoi= new ArrayList<>();
   

    public Graphique() {
        
        
        // FENETRE
                this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL-ECE PARIS");
                this.setSize(1000,1000);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setLayout(new BorderLayout());
                this.setResizable(true);
                this.setVisible(true);
        //////////////////////////////CONNEXION/////////////////////////////////////////
                po= new JPanel();
                
                hop_connexion = new JPanel();
                hop_connexion.setPreferredSize(new Dimension(500,700));
                hop_connexion.setLayout(new GridLayout(0,1));
                hop_connexion.setBorder(BorderFactory.createTitledBorder("Connection au centre")); 
                        
                bdd= new JTextField("");
                bdd.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                login=new JTextField("");
                //login.setHorizontalAlignment(BorderLayout.CENTER);
                mdp=new JTextField("");
                mdp.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                okay= new JButton("Valider");
                okay.addActionListener((ActionListener) this);
                
                hop_connexion.add(new JLabel("Nom de la base de données",JLabel.CENTER));
                hop_connexion.add(bdd);
                hop_connexion.add(new JLabel("Un login",JLabel.CENTER));
                hop_connexion.add(login);
                hop_connexion.add(new JLabel("Un mot de passe",JLabel.CENTER));
                hop_connexion.add(mdp);
                hop_connexion.add(okay);
                okay.setBackground(Color.GREEN);
                
            /////////////////////// OPTIONS ///////////////////////////////////
                
            option= new JPanel();
            option.setPreferredSize(new Dimension(500,700));
            option.setLayout(new GridLayout(0,1));
            option.setBorder(BorderFactory.createTitledBorder("Que souhaitez vous faire?"));
            
            button=new ArrayList<>();
        button.add(new JButton("CONSULTER"));
        button.add(new JButton("RECHERCHE"));
        button.add(new JButton("SUPPRIMER"));
        button.add(new JButton("AJOUTER"));
        button.add(new JButton("METTRE A JOUR"));
        button.add(new JButton("REPORTING"));
        
        for (JButton jButton : button) {
            //option.add(jButton);
            jButton.addActionListener((ActionListener) this);
        }
                
                
                //// AJOUT A LA FENETRE
                po.add(hop_connexion);
                this.add(po, BorderLayout.CENTER);
                
        
    }
     
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source==okay){
            System.out.println("vue.Graphique.actionPerformed()");
            // Récupération des entrées de Connection
            String a=new String(bdd.getText());
            String l=new String(login.getText());;
            String m= new String(mdp.getText());;
            // Mise dans une liste envoie au controleur
            renvoi.add(a);
            renvoi.add(l);
            renvoi.add(m);
            
            this.removeAll();
            this.add(option);
            
    
   
        }
        
          
    }
    
    
    
    
}
