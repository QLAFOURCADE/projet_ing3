/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author Pierre-Louis
 */
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
import DAO.InfirmierDAO;
import modele.Infirmier;
import controleur.Connexion;
/**
 *
 * @author Pierre-Louis
 */
public class panelDeleteInfirmier extends JPanel {
    
    
    public JTextField tNumero;
    public JLabel numero;
    public JButton ok_ajouter;
    public int rnumero;
    
    public panelDeleteInfirmier(){
        
      // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        tNumero = new JTextField(10);
        tNumero.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        
      // initialisation des JTextField
        numero = new JLabel("Numero de l'infirmier: ");
     
     
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(numero);
      fieldsPane.add(tNumero);
      
      
      fieldsPane.setLayout(new GridLayout(1,2));
      
      this.add(fieldsPane);
      
      
      //bouton Supprimer
      JButton supprimer = new JButton("Supprimer");
      this.add(supprimer);
      
       //Définition de l'action du bouton ajouter
      supprimer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rnumero = Integer.parseInt(tNumero.getText());
        
        
          //Supprimer l'infirmier
        DAO<Infirmier> infirmierDao = new InfirmierDAO(Connexion.getInstance());
        Infirmier d = new Infirmier(rnumero, "", "", 0);
        infirmierDao.delete(d);  
        
        //Supprimer l'employé correspondant
        DAO<Employe> employeDao = new EmployeDAO(Connexion.getInstance());
        Employe e = new Employe(rnumero, "", "", "", "");
        employeDao.delete(e);
        
      
        
        
        
    
      }
    });
               
    }
}
