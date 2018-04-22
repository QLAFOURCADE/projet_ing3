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
import DAO.HospitalisationDAO;
import modele.Hospitalisation;
import controleur.Connexion;
/**
 *
 * @author Pierre-Louis
 */
public class panelCreateHospitalisation extends JPanel {
    
    
    public JTextField tno_malade, tcode_service, tno_chambre, tlit;
    public JLabel no_malade, code_service, no_chambre, lit;
    public JButton ok_ajouter;
    public int rno_malade, rno_chambre,rlit;
    public String rcode_service;
    
    public panelCreateHospitalisation(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une hospitalisation
        tno_malade = new JTextField(10);
        tno_malade.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tcode_service = new JTextField(10);
        tcode_service.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tno_chambre = new JTextField(10);
        tno_chambre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tlit = new JTextField(10);
        tlit.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
      // initialisation des JTextField
        no_malade = new JLabel("Numéro du malade: ");
        code_service = new JLabel("Code service : ");
        no_chambre = new JLabel("Numéro de chambre : ");
        lit = new JLabel("Lit n° : ");
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(no_malade);
      fieldsPane.add(tno_malade);
      fieldsPane.add(code_service);
      fieldsPane.add(tcode_service);
      fieldsPane.add(no_chambre);
      fieldsPane.add(tno_chambre);
      fieldsPane.add(lit);
      fieldsPane.add(tlit);
      
      fieldsPane.setLayout(new GridLayout(4,4));
      
      this.add(fieldsPane);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Ajouter");
      this.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rno_malade = Integer.parseInt(tno_malade.getText());
        rcode_service = tcode_service.getText();
        rno_chambre = Integer.parseInt(tno_chambre.getText());
        rlit = Integer.parseInt(tlit.getText());     
        
        DAO<Hospitalisation> hospitalisationDao = new HospitalisationDAO(Connexion.getInstance());
        Hospitalisation h = new Hospitalisation(rno_malade, rcode_service, rno_chambre, rlit);
        hospitalisationDao.create(h);  
      }
    });
               
    }
}
