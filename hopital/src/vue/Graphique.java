/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.TestHopital;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;*/
import javax.swing.*;
/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;*/

/**
 *
 * @author Quiterie
 */
public class Graphique extends JFrame {
    
    // CREATION D'UN PANEL CONNEXION
    
    /// elements pour menu principal 
    public JPanel hop_connexion,po,option,p1, ajout;
    public JButton okay;
    public JTextField bdd, login, mdp;
    
    /// elements sup pour menu options 
    public JButton consulter, recherche, supprimer, ajouter, maj, reporting;
    
    /// elements sup pour ajouter quelqu'un 
    public JTabbedPane onglets_ajouter;
    public JPanel onglet_1, onglet_2, onglet_3;
                /// DOCTEUR
    public JLabel nom, prenom, adresse, tel, spe;
    public JTextField n, p, a, t, s;
    public JButton ok_ajouter, retour_m_choix;
                /// INFIRMIER
    public JLabel nom_2, prenom_2, adresse_2, tel_2, salaire, rotation, service_c;
    public JTextField n_2, p_2, a_2, t_2,sal;
    public JButton ok_ajouter_2, retour_m_choix_2;
    public CheckboxGroup c_serv, rot;
    public Checkbox c_serv_1, c_serv_2, c_serv_3, rot_1, rot_2;
                /// MALADE
    public JLabel nom_3, prenom_3, adresse_3, tel_3, mut;
    public JTextField n_3, p_3, a_3, t_3, m;
    public JButton ok_ajouter_3, retour_m_choix_3;
    
    
    
    //public JPanel p2, ajout_2;
    
    public JPanel aff_consult;
    
    public Choice table = new Choice();
    
    
    /**
     * CONSTRUCTEUR de la classe
     */
    public Graphique() {
        
        // FENETRE
                this.setTitle("ESPACE ADMINISTRATIF DE L'HOPITAL-ECE PARIS");
                this.setSize(1000,1000);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setLayout(new BorderLayout());
               // this.setResizable(true);
               // this.setVisible(true);
       
        // initialisation des butons du menu principal 
        okay= new JButton("Valider");
        
        // initialiser les boutons avec un noms pour tous : menu options 
        consulter = new JButton("CONSULTER");
        recherche = new JButton("RECHERCHE");
        supprimer = new JButton("SUPPRIMER");
        ajouter = new JButton("AJOUTER");
        maj = new JButton("METTRE A JOUR");
        reporting = new JButton("REPORTING");
        
        // initialiser les boutons avec textes pour page ajouter
        ok_ajouter = new JButton("VALIDER");
        retour_m_choix = new JButton("RETOUR");
        ok_ajouter_2 = new JButton("VALIDER");
        retour_m_choix_2 =  new JButton("RETOUR");
        ok_ajouter_3 = new JButton("VALIDER");
        retour_m_choix_3 =  new JButton("RETOUR");
       
    }
    
    /**
     * METHODE : afficher le premier panel : le menu de connexion 
     */
    public void connexion()
    {
         //////////////////////////////CONNEXION/////////////////////////////////////////
        po= new JPanel();
        p1= new JPanel();
                
        hop_connexion = new JPanel();
        hop_connexion.setPreferredSize(new Dimension(500,700));
        hop_connexion.setLayout(new GridLayout(0,1));
        hop_connexion.setBorder(BorderFactory.createTitledBorder("Connection au centre")); 
                        
        bdd= new JTextField("");
        bdd.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        login=new JTextField("");
        login.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                //login.setHorizontalAlignment(BorderLayout.CENTER);
        mdp=new JTextField("");
        mdp.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        // okay.addActionListener((ActionListener) this);
                
        hop_connexion.add(new JLabel("Nom de la base de données",JLabel.CENTER));
        hop_connexion.add(bdd);
        hop_connexion.add(new JLabel("Un login",JLabel.CENTER));
        hop_connexion.add(login);
        hop_connexion.add(new JLabel("Un mot de passe",JLabel.CENTER));
        hop_connexion.add(mdp);
        hop_connexion.add(okay);
        okay.setBackground(Color.GREEN);
        
               
        po.add(hop_connexion);
        //this.add(po, BorderLayout.CENTER);
        setContentPane(po);
    }
    
    /**
     * METHODE : afficher les options à l'utilisateur
     *              possible qu'après une bonne entrée des éléments de la connexion
     */
    public void panel_deux()
    {
        /////////////////////////// OPTIONS ///////////////////////////////////
                
        // initialiser le panel qui contient les boutons de choix 
        option= new JPanel();
        option.setPreferredSize(new Dimension(500,700));
        option.setLayout(new GridLayout(0,1));
        option.setBorder(BorderFactory.createTitledBorder("Que souhaitez vous faire?"));
       
        // ajouter les boutons au panel
        option.add(consulter);
        option.add(recherche);
        option.add(supprimer);
        option.add(ajouter);
        option.add(maj);
        option.add(reporting);
        
        
        // supprimer l'ancien panel + le mettre à jour avec nouveau élément 
        po.removeAll();
        po.repaint();
        po.add(option, BorderLayout.CENTER);
        po.revalidate();
        //setContentPane(po);

    }
        
    //////////////////////// TAB CONSULTER //////////////////////////////////
 
                
   /**
    * METHODE : afficher la page ajouter 
    *           on crée les panels et ajoute les boutons
    */
   public void panel_ajout()
   {
       ////////////////////// AJOUT A LA FENETRE ////////////////////////////////
      
        // pour mettre une dimension au texte
        Font font = new Font("Arial", Font.BOLD, 16);
        
        // creation d'onglets 
        onglets_ajouter = new JTabbedPane();
        
        // faire des onglets : un panel pour chaque
        onglet_1 = new JPanel();
        onglet_1.setLayout(null);
        onglet_2 = new JPanel();
        onglet_2.setLayout(null);
        onglet_3 = new JPanel();
        onglet_3.setLayout(null);
        
        
        // mettre des bordures au onglets
        onglet_1.setBorder(BorderFactory.createTitledBorder("Ajouter un Docteur"));
        onglet_2.setBorder(BorderFactory.createTitledBorder("Ajouter un Infirmier"));
        onglet_3.setBorder(BorderFactory.createTitledBorder("Ajouter un Malade"));
        
        // dimension des panels juste du 1
        onglet_1.setPreferredSize(new Dimension(900,900));
      
        // ajouter des boites de texte pour que l'utilisateur ajoute quelqu'un
        n = new JTextField("");
        n.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        p = new JTextField("");
        p.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        a = new JTextField("");
        a.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        t = new JTextField("");
        t.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        s = new JTextField("");
        s.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        // initialisation des JTextField
        nom = new JLabel("Nom : ");
        nom.setFont(font);
        prenom = new JLabel("Prenom : ");
        prenom.setFont(font);
        adresse = new JLabel("Adresse : ");
        adresse.setFont(font);
        tel = new JLabel("Téléphone : ");
        tel.setFont(font);
        spe = new JLabel("Spécialité : ");
        spe.setFont(font);
        
        // les buttons : valider + retour
        ok_ajouter.setBackground(Color.GREEN);
        ok_ajouter.setBounds(650, 550, 100, 50);
        retour_m_choix.setBackground(Color.gray);
        retour_m_choix.setBounds(700, 40, 100, 50);
        
        // positionner les elements au bont endroit
        nom.setBounds(100,145,150,20);
        n.setBounds(200,140,150,30);
        prenom.setBounds(500,145,150,20);
        p.setBounds(600,140,150,30);
        adresse.setBounds(100,254,150,20);
        a.setBounds(200,240,600,50);
        tel.setBounds(100,398,150,20);
        t.setBounds(200,380,150,50);
        spe.setBounds(100,503,150,20);
        s.setBounds(200,500,150,30);
        
        // ajout des elements du formulaire dans le panel de l'onglet1 : DOCTEUR
        onglet_1.add(nom);
        onglet_1.add(n);
        onglet_1.add(prenom);
        onglet_1.add(p);
        onglet_1.add(adresse);
        onglet_1.add(a);
        onglet_1.add(tel);
        onglet_1.add(t);
        onglet_1.add(spe);
        onglet_1.add(s);
       
        // les buttons de la page : valider + retour 
        onglet_1.add(ok_ajouter);
        onglet_1.add(retour_m_choix);
        
        
        // ajout des elements du formulaire dans le panel de l'onglet 2 : INFIRMIER 
                    // on re_effetue les même opérations mais pour l'onglet 2
        // ajouter des boites de texte pour que l'utilisateur ajoute quelqu'un
        n_2 = new JTextField("");
        n_2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        p_2 = new JTextField("");
        p_2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        a_2 = new JTextField("");
        a_2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        t_2 = new JTextField("");
        t_2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        sal = new JTextField("");
        sal.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        // des checkbox pour choisir la rotation et le service 
        c_serv = new CheckboxGroup();
        rot = new CheckboxGroup();
        
        c_serv_1 = new Checkbox("REA",c_serv,false);
        c_serv_2 = new Checkbox("CAR",c_serv,false);
        c_serv_3 = new Checkbox("CHG",c_serv,false);
        rot_1 = new Checkbox("NUIT",rot,false);
        rot_2 = new Checkbox("JOUR",rot,false);
        // initialisation des JTextField
        nom_2 = new JLabel("Nom : ");
        nom_2.setFont(font);
        prenom_2 = new JLabel("Prenom : ");
        prenom_2.setFont(font);
        adresse_2 = new JLabel("Adresse : ");
        adresse_2.setFont(font);
        tel_2 = new JLabel("Téléphone : ");
        tel_2.setFont(font);
        salaire = new JLabel("Salaire : ");
        salaire.setFont(font);
        rotation = new JLabel("Rotation : ");
        rotation.setFont(font);
        service_c = new JLabel("Code du service : ");
        service_c.setFont(font);
        
        
        // les buttons : valider + retour
        ok_ajouter_2.setBackground(Color.GREEN);
        ok_ajouter_2.setBounds(650, 550, 100, 50);
        retour_m_choix_2.setBackground(Color.gray);
        retour_m_choix_2.setBounds(700, 40, 100, 50);
        
        // positionner les elements au bont endroit
        nom_2.setBounds(100,145,150,20);
        n_2.setBounds(200,140,150,30);
        prenom_2.setBounds(500,145,150,20);
        p_2.setBounds(600,140,150,30);
        adresse_2.setBounds(100,254,150,20);
        a_2.setBounds(200,240,600,50);
        tel_2.setBounds(100,398,150,20);
        t_2.setBounds(200,380,150,50);
        sal.setBounds(100,550,150,20);
        salaire.setBounds(200,550,150,30);
        rotation.setBounds(100,500,150,30);
        rot_1.setBounds(400,400,150,30);
        rot_2.setBounds(450,400,150,30);
        service_c.setBounds(100,600,150,30);
        c_serv_1.setBounds(200,600,150,30);
        c_serv_2.setBounds(250,600,150,30);
        c_serv_3.setBounds(300,600,150,30);
        
        // ajout des elements du formulaire dans le panel de l'onglet 2 : INFIRMIER
        onglet_2.add(nom_2);
        onglet_2.add(n_2);
        onglet_2.add(prenom_2);
        onglet_2.add(p_2);
        onglet_2.add(adresse_2);
        onglet_2.add(a_2);
        onglet_2.add(tel_2);
        onglet_2.add(t_2);
        onglet_2.add(salaire);
        onglet_2.add(sal);
        onglet_2.add(rotation);
        onglet_2.add(rot_1);
        onglet_2.add(rot_2);
        onglet_2.add(service_c);
        onglet_2.add(c_serv_1);
        onglet_2.add(c_serv_2);
        onglet_2.add(c_serv_3);
        
        
                /// MALADE
  /**  public JLabel nom_3, prenom_3, adresse_3, tel_3, mut;
    public JTextField n_3, p_3, a_3, t_3, m;
        r = new JTextField("");
        r.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        rot = new JLabel("Nom : ");
        rot.setFont(font);
    //    , tel, spe, rot, salaire, c_serv;
  // r,sal, serv;*/
    
        // mettre les differents panels de ces onglets dans le JTabbedPane
        onglets_ajouter.addTab("Docteur",onglet_1);
        onglets_ajouter.addTab("Infirmier",onglet_2);
        onglets_ajouter.addTab("Malade",onglet_3);
       
        
        
        po.removeAll();
        po.repaint();
        po.add(onglets_ajouter);
        //po.add(ajout_2);
        po.revalidate();
        setContentPane(po);
   }
  
          
}

