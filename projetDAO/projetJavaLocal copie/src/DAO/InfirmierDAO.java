/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Infirmier;
import java.util.Scanner;
import modele.Employe;

/**
 *
 * @author Pierre-Louis
 */
public class InfirmierDAO extends DAO<Infirmier> {
  
    public InfirmierDAO(Connection conn) 
        {
            super(conn);
        }


 //Créer un infirmier
 public boolean create(Infirmier obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO infirmier VALUES ('"+ obj.getNumero() + "','" + obj.getCodeService() + "','" + obj.getRotation()+"','" + obj.getSalaire()+"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  
  public boolean delete(Infirmier obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `infirmier` WHERE `numero` = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  
  //Modifier un infirmier
  
   public boolean update(Infirmier obj) {
        try{
         
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE infirmier SET code_service='" +obj.getCodeService()+"', rotation ='"+obj.getRotation()+"', salaire ='"+obj.getSalaire()+"' WHERE numero = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  //Trouver un infirmier a partir de son numero
  @Override
  public Infirmier find(int numero) {
    Infirmier infirmier = new Infirmier();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM infirmier WHERE numero = " + numero);
      if(result.first())
          infirmier = new Infirmier(
          numero,
          result.getString("code_service"),
          result.getString("rotation"),
          result.getInt("salaire")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return infirmier;
  }

   
}