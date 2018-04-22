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
import DAO.DocteurDAO;
import modele.Docteur;
import controleur.Connexion;
/**
 *
 * @author Pierre-Louis
 */
public class panelDeleteDocteur extends JPanel {
    
    
    public JTextField tNumero;
    public JLabel numero;
    public JButton ok_ajouter;
    public int rnumero;
    
    public panelDeleteDocteur(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        tNumero = new JTextField(10);
        tNumero.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    
      // initialisation des JTextField
        numero = new JLabel("Numero : ");
        
    
     
     
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(numero);
      fieldsPane.add(tNumero);
   
      
      fieldsPane.setLayout(new GridLayout(1,2));
      
      this.add(fieldsPane);
      
      
      //bouton jouter
      JButton supprimer = new JButton("Supprimer");
      this.add(supprimer);
      
       //Définition de l'action du bouton ajouter
      supprimer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rnumero = Integer.parseInt(tNumero.getText());

        //Supprimer le Docteur
        DAO<Docteur> docteurDao = new DocteurDAO(Connexion.getInstance());
        Docteur d = new Docteur(rnumero,"");
        docteurDao.delete(d);  
          
        //Supprimer l'Employé correspondant
        DAO<Employe> employeDao = new EmployeDAO(Connexion.getInstance());
        Employe e = new Employe(rnumero, "", "", "", "");
        employeDao.delete(e);
         
        
    
      }
    });
               
    }
}
