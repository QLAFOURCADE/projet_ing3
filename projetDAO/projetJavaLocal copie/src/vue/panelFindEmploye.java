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
import DAO.EmployeDAO;
import modele.Employe;
import controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author Pierre-Louis
 */
public class panelFindEmploye extends JPanel {
    
    //Scroll
    private JTextArea afficher = new JTextArea();
    private JScrollPane scroll = new JScrollPane(afficher);
 
    
    public panelFindEmploye(){
        
        //Scroll
        scroll.setBounds(5, 5, 100, 100);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Layout
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        
       //Aller cherche toutes les chambres
       for(int i=1; i<200; i++)
             {
               
             DAO<Employe> employeDao= new EmployeDAO(Connexion.getInstance());
             Employe employe= employeDao.find(i);
             if(employe.getNumero()!=0)
             {
                 
                 afficher.append("Numéro de l'employe : "+employe.getNumero()+" -- Nom : "+ employe.getNom() + " -- Prénom : " + employe.getPrenom()+" -- Tel : "+employe.getTel()+" -- Adresse : "+employe.getAdresse()+"\n****************************************************"+"\n");
          
             }
             }
       
       //Ajouter le contenu
       this.add(scroll);
      
      
               
    }
}
