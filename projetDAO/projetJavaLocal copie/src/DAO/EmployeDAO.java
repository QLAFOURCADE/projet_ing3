/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Employe;
import java.util.Scanner;

/**
 *
 * @author Pierre-Louis
 */
public class EmployeDAO extends DAO<Employe> {
  
    public EmployeDAO(Connection conn) 
        {
            super(conn);
        }


 @Override
 public boolean create(Employe obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO employe VALUES ('"+ obj.getNumero() + "','" + obj.getNom() + "','" + obj.getPrenom()+"','" + obj.getAdresse() + "','" + obj.getTel() +"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  @Override
  public boolean delete(Employe obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `employe` WHERE `numero` = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  
  //Modifier un employé
  @Override
   public boolean update(Employe obj) {
        try{
         
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE employe SET nom='" +obj.getNom()+"', prenom ='"+obj.getPrenom()+"', adresse ='"+obj.getAdresse()+"', tel ='"+obj.getTel()+"' WHERE numero = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  //Trouver un employe a partir de son numero
  @Override
  public Employe find(int numero) {
    Employe employe = new Employe();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM employe WHERE numero = " + numero);
      if(result.first())
          employe = new Employe(
          numero,
          result.getString("nom"),
          result.getString("prenom"),
          result.getString("adresse"),
          result.getString("tel")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return employe;
  }

   
}