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
import DAO.ChambreDAO;
import modele.Chambre;
import controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author Pierre-Louis
 */
public class panelFindChambre extends JPanel {
    
    //Scroll
    private JTextArea afficher = new JTextArea();
    private JScrollPane scroll = new JScrollPane(afficher);
    
   
    
    public panelFindChambre(){
        
        //Scroll
        scroll.setBounds(5, 5, 100, 100);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Layout
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        
       //Aller cherche toutes les chambres
       for(int i=1; i<450; i++)
             {
               
             DAO<Chambre> chambreDao= new ChambreDAO(Connexion.getInstance());
             Chambre chambre= chambreDao.find(i);
             if(chambre.getNum_ch()!=0)
             {
                 
                 afficher.append("Numero chambre : "+chambre.getNum_ch()+" -- Code Service : "+chambre.getCodeService()+ " -- Surveillant : " + Integer.toString(chambre.getIdSurveillant())+" -- Nombre de lits : "+Integer.toString(chambre.getNb_lits())+
                         "\n****************************************************"+"\n");
                 
                 
               
                 
                 
             }
             }
       
       //Ajouter le contenu
       this.add(scroll);
      
      
               
    }
}
