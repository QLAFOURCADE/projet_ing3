/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Malade;
import java.util.Scanner;
import modele.Employe;

/**
 *
 * @author Pierre-Louis
 */
public class MaladeDAO extends DAO<Malade> {
  
    public MaladeDAO(Connection conn) 
        {
            super(conn);
        }

 //Créer un malade
 public boolean create(Malade obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO malade VALUES ('"+ obj.getNumero() + "','" + obj.getNom() + "','" + obj.getPrenom()+"','" + obj.getAdresse()+"','" + obj.getTel()+"','" + obj.getMutuelle()+"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  
  public boolean delete(Malade obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `malade` WHERE `numero` = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  
  //Modifier un infirmier
  
   public boolean update(Malade obj) {
        try{
         
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE malade SET nom='" +obj.getNom()+"', prenom ='"+obj.getPrenom()+"', adresse ='"+obj.getAdresse()+ "', tel ='"+obj.getTel()+ "', mutuelle ='"+obj.getMutuelle()+ "' WHERE CONCAT (`malade`.`numero`)  = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  //Trouver un infirmier a partir de son numero
  @Override
  public Malade find(int numero) {
    Malade malade = new Malade();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM malade WHERE numero = " + numero);
      if(result.first())
          malade = new Malade(
          numero,
          result.getString("nom"),
          result.getString("prenom"),
          result.getString("Adresse"),
          result.getString("tel"),
          result.getString("mutuelle")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return malade;
  }

   
}