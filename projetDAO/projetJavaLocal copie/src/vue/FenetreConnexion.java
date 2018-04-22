/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Quiterie, Pierre-Louis, Tiphaine
 */
public class FenetreConnexion extends JFrame implements ActionListener {
    
        /// elements pour menu principal 
    public JPanel hop_connexion,po,option,p1, ajout;
    public JButton okay;
    public JTextField bdd, login, mdp;
    
    
    public FenetreConnexion()
    {
        
        // FENETRE
                this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL-ECE PARIS");
                this.setSize(1000,1000);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setLayout(new BorderLayout());
                
                
        // initialisation des butons du menu principal 
        okay= new JButton("Valider");
        okay.addActionListener(this);
        
        
         //////////////////////////////CONNEXION/////////////////////////////////////////
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
        
        this.setVisible(true);
        
    }
    
@Override
        public void actionPerformed(ActionEvent event){
            Object source = event.getSource();
            if (source == this.okay)
            {
                try {
                    // Récupération des entrées de Connection
                String a= bdd.getText();
                String l= login.getText();
                String m= mdp.getText();
                System.out.println(a+l+m);
                Connexion c = new Connexion();
                c.Verif_Connexion(a, l, m);
                this.setVisible(false);
                Fenetre fen = new Fenetre(); 
                }
                catch (Exception e) {
                     JOptionPane.showMessageDialog(null,"Mauvaise entrée!");
                }
            }
      }
}
