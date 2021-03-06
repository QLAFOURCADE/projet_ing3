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
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
/**
 *
 * @author Pierre-Louis
 */
public class panelCreateInfirmier extends JPanel {
    
    
    public JTextField tNumero, tNom, tPrenom, tAdresse, tTel, tCode_service, tRotation, tSalaire;
    public JLabel numero, nom, prenom, adresse, tel, code_service, rotation, salaire;
    public JButton ok_ajouter;
    public String rnom, rprenom, radresse, rtel, rcode_service, rrotation;
    public int rnumero, rsalaire;
    
    public panelCreateInfirmier(){
        
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
        tCode_service = new JTextField(10);
        tCode_service.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tRotation = new JTextField(10);
        tRotation.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tSalaire = new JTextField(10);
        tSalaire.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
      // initialisation des JTextField
        numero = new JLabel("Numero : ");
        nom = new JLabel("Nom : ");
        prenom = new JLabel("Prenom : ");
        adresse = new JLabel("Adresse : ");
        tel = new JLabel("Tel : ");
        code_service = new JLabel("Code service : ");
        rotation = new JLabel("Rotation : ");
        salaire = new JLabel("Salaire : ");
        
     
     
      JPanel fieldsPane = new JPanel();
      JPanel fieldsPane1 = new JPanel();
      fieldsPane1.setPreferredSize(new Dimension(580,300));
      fieldsPane1.setBorder(BorderFactory.createTitledBorder("Creation d'un Infirmier"));
      
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
      
      fieldsPane.add(code_service);
      fieldsPane.add(tCode_service);
      
      fieldsPane.add(rotation);
      fieldsPane.add(tRotation);
      
      fieldsPane.add(salaire);
      fieldsPane.add(tSalaire);
      
      
      fieldsPane.setLayout(new GridLayout(8,2));
      fieldsPane1.add(fieldsPane, BorderLayout.CENTER);
      this.add(fieldsPane1);
      
      
      //bouton jouter
      JButton ajouter = new JButton("Ajouter");
      fieldsPane1.add(ajouter);
      
       //Définition de l'action du bouton ajouter
      ajouter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
          
        rnumero = Integer.parseInt(tNumero.getText());
        rnom = tNom.getText();
        rprenom = tPrenom.getText();
        radresse = tAdresse.getText();
        rtel = tTel.getText();
        rcode_service = tCode_service.getText();
        rrotation = tRotation.getText();
        rsalaire = Integer.parseInt(tSalaire.getText());
        
        
        //Inserer un nouvel Employé
        DAO<Employe> employeDao = new EmployeDAO(Connexion.getInstance());
        Employe e = new Employe(rnumero, rnom, rprenom, radresse, rtel);
        employeDao.create(e);
        
      
        
        //Inserer un nouveau Docteur
        DAO<Infirmier> infirmierDao = new InfirmierDAO(Connexion.getInstance());
        Infirmier d = new Infirmier(rnumero, rcode_service, rrotation, rsalaire);
        infirmierDao.create(d);  
        
    
      }
    });
               
    }
}
