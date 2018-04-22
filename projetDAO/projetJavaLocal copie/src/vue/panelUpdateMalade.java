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
import DAO.MaladeDAO;
import modele.Malade;
import controleur.Connexion;

/**
 *
 * @author Pierre-Louis
 */
public class panelUpdateMalade extends JPanel {
    
    
    public JTextField tNumero, tNom, tPrenom, tAdresse, tTel, tMutuelle;
    public JLabel numero, nom, prenom, adresse, tel, mutuelle;
    public JButton ok_ajouter;
    public String rnom, rprenom, radresse, rtel, rmutuelle;
    public int rnumero;
    
    public panelUpdateMalade(){
        
        // ajouter des boites de texte pour que l'utilisateur ajoute une chambre
        tNumero = new JTextField(10);
        tNumero.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tNom = new JTextField(10);
        tNom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tPrenom = new JTextField(10);
        tPrenom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tAdresse = new JTextField(10);
        tAdresse.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tTel = new JTextField(10);
        tTel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tMutuelle = new JTextField(10);
        tMutuelle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        // initialisation des JTextField
        numero = new JLabel("Numero : ");
        nom = new JLabel("Nom : ");
        prenom = new JLabel("Prenom : ");
        adresse = new JLabel("Adresse : ");
        tel = new JLabel("Tel : ");
        mutuelle = new JLabel("Mutuelle : ");
        
     
     
      JPanel fieldsPane = new JPanel();
      
      //Ajouter tous les éléments
      fieldsPane.add(numero);
      fieldsPane.add(tNumero);
      
      fieldsPane.add(nom);
      fieldsPane.add(tNom);
      
      fieldsPane.add(prenom);
      fieldsPane.add(tPrenom);
      
      fieldsPane.add(adresse);
      fieldsPane.add(tAdresse);
      fieldsPane.add(tel);
      fieldsPane.add(tTel);
      fieldsPane.add(mutuelle);
      fieldsPane.add(tMutuelle);
      
      
      
      fieldsPane.setLayout(new GridLayout(6,2));
      
      this.add(fieldsPane);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Mettre à jour");
      this.add(ajouter);
      
       //Définition de l'action du bouton mettre à jour
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rnumero = Integer.parseInt(tNumero.getText());
        rnom = tNom.getText();
        rprenom = tPrenom.getText();
        radresse = tAdresse.getText();
        rtel = tTel.getText();
        rmutuelle = tMutuelle.getText();
        
        
        //Inserer un nouveau Malade
        DAO<Malade> maladeDao = new MaladeDAO(Connexion.getInstance());
        Malade m = new Malade(rnumero, rnom, rprenom, radresse, rtel, rmutuelle);
        maladeDao.update(m);
        
        
    
      }
    });
               
    }
}
