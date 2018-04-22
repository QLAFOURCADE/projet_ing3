/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.GridLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Imports pour requete
import DAO.DAO;
import DAO.ServiceDAO;
import modele.Service;
import controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author Pierre-Louis
 */
public class panelFindService extends JPanel {
    
    //Scroll
    private JTextArea afficher = new JTextArea();
    private JScrollPane scroll = new JScrollPane(afficher);
    public String nomService[] = {"REA", "CAR", "CAC" , "CHG"};
 
    
    public panelFindService(){
        
        //Scroll
        scroll.setBounds(5, 5, 100, 100);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Layout
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        
       //Aller cherche toutes les chambres
       for(int i=0; i<10; i++)
             {
               
             DAO<Service> serviceDao= new ServiceDAO(Connexion.getInstance());
             Service service= serviceDao.find2(nomService[i]);
             if(service.getCode()!="")
             {
                 
                 afficher.append("Code service : "+service.getCode()+" -- Nom : "+ service.getNom() + " -- Batiment : " + service.getBatiment()+" -- Directeur : "+service.getDirecteur()+"\n****************************************************"+"\n");
          
             }
             }
       
       //Ajouter le contenu
       this.add(scroll);
      
      
               
    }
}
