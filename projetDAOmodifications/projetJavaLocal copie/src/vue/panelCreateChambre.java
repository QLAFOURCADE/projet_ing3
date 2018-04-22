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
import java.awt.Dimension;
import javax.swing.BorderFactory;
/**
 *
 * @author Pierre-Louis
 */
public class panelCreateChambre extends JPanel {
    
    
    public JTextField c_s, no_c, surv, nb_l;
    public JLabel code_service, no_chambre, surveillant, nb_lits;
    public JButton ok_ajouter, retour_m_choix;
    public String rcode_service;
    public int rno_chambre, rsurveillant, rnb_lits;
    
    public panelCreateChambre(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        c_s = new JTextField(10);
        c_s.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        no_c = new JTextField(10);
        no_c.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        surv = new JTextField(10);
        surv.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        nb_l = new JTextField(10);
        nb_l.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
      // initialisation des JTextField
        code_service = new JLabel("Code service : ");
        
        no_chambre = new JLabel("Numero chambre : ");
        
        surveillant = new JLabel("Surveillant : ");
        
        nb_lits = new JLabel("Nombre de lits : ");
        
     
     
      JPanel fieldsPane = new JPanel();
      JPanel fieldsPane1= new JPanel();
      //fieldsPane1.setLayout(new GridLayout(2,0));
      fieldsPane1.setBorder(BorderFactory.createTitledBorder("Creation d'une chambre"));
      fieldsPane1.setPreferredSize(new Dimension(580, 400));
      
      
      
      //Ajouter tous les éléments
      fieldsPane.add(code_service);
      fieldsPane.add(c_s);
      fieldsPane.add(no_chambre);
      fieldsPane.add(no_c);
      fieldsPane.add(surveillant);
      fieldsPane.add(surv);
      fieldsPane.add(nb_lits);
      fieldsPane.add(nb_l);
      
      fieldsPane.setLayout(new GridLayout(7,2));
      fieldsPane1.add(fieldsPane, BorderLayout.CENTER);
      
      
      this.add(fieldsPane1);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Ajouter");
      fieldsPane1.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rcode_service = c_s.getText();
        rno_chambre = Integer.parseInt(no_c.getText());
        rsurveillant = Integer.parseInt(surv.getText());
        rnb_lits = Integer.parseInt (nb_l.getText());
        
        DAO<Chambre> chambreDao = new ChambreDAO(Connexion.getInstance());
        Chambre c = new Chambre(rcode_service, rno_chambre, rsurveillant, rnb_lits);
        chambreDao.create(c);
        System.out.println("La chambre suivante a été ajouté à la BDD " + c.toString());
      
      }
    });
               
    }
}
