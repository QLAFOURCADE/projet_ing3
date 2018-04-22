/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tiphaine Plusquellec
 */
public class panelConnection extends JPanel {
    
      
    
    
    
    public panelConnection(){
        
       JLabel b= new JLabel("Veuillez rentrer le nom de la Base de donnée");
       JTextField bdd= new JTextField("");
       JLabel l= new JLabel("Veuillez rentrer le login");
       JTextField login= new JTextField("");
       JLabel m= new JLabel("Veuillez rentrer le mot de passe");
       JTextField mdp= new JTextField("");
       JPanel p1= new JPanel();      
       JPanel c = new JPanel();
       c.setLayout(new GridLayout(0,1));

       c.add(b);
       c.add(bdd);
       c.add(l);
       c.add(login);
       c.add(m);
       c.add(mdp);
       
       JButton valider= new JButton("Valider");
       valider.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        
    }
    
      

    
      
       
       
   
       
       
       
       
    
}
