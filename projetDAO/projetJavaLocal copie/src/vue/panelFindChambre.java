/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
 
 
import java.awt.BorderLayout;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modele.*;
import DAO.DAO;
import DAO.ChambreDAO;
import controleur.Connexion;
 
 
/**
 *
 * @author Andrej
 */
public class panelFindChambre extends JFrame implements ActionListener{
   
    private JPanel pan = new JPanel();
    private JTextArea affd= new JTextArea();
    private JButton retour = new JButton("Retour");
    private JScrollPane scroll = new JScrollPane(affd);
   
   
   
    public panelFindChambre()
    {
        //pan.setLayout(new GridLayout(2,8));
        scroll.setBounds(5, 5, 100, 100);
        this.setTitle("Option Ajouter");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
       
         
       
        pan.setBackground(Color.WHITE);
        pan.setLayout(new BorderLayout());
       
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(pan);
       
       
             for(int i=1; i<200; i++)
             {
               
             DAO<Chambre> chambreDao= new ChambreDAO(Connexion.getInstance());
             Chambre chambre= chambreDao.find(i);
             if(chambre.getNum_ch()!=0)
             {
                 
                 affd.append(chambre.getCodeService()+" "+ Integer.toString(chambre.getNum_ch()) +" " + Integer.toString(chambre.getIdSurveillant())+" "+Integer.toString(chambre.getNb_lits())+
                         "\n****************************************************"+"\n");
                 
                 
               
                 
                 
             }
             }
 
       
        pan.add(scroll);
        retour.addActionListener(this);
       
     
        this.getContentPane().add(retour, BorderLayout.SOUTH);
     
       
        this.setContentPane(pan);
        this.setVisible(true);
             
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
