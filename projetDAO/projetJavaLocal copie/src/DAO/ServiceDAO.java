/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Service;

/**
 *
 * @author Pierre-Louis
 */
public class ServiceDAO extends DAO<Service> {
  
    public ServiceDAO(Connection conn) 
        {
            super(conn);
        }

 //Créer un service
 public boolean create(Service obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO service VALUES ('"+ obj.getCode() + "','" + obj.getNom() + "','" + obj.getBatiment()+"','" + obj.getDirecteur()+"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  //Supprimer un service
  public boolean delete(Service obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `service` WHERE `code` = '" + obj.getCode()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  
  //Modifier un service
  
   public boolean update(Service obj) {
        try{
         
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE service SET nom='" +obj.getNom()+"', batiment ='"+obj.getBatiment()+"', directeur ='"+obj.getDirecteur()+"' WHERE CONCAT (`service`.`code`)  = '" + obj.getCode()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  //Trouver un infirmier a partir de son numero
  
  public Service find(String code) {
    Service service = new Service();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM service WHERE code = " + code);
      if(result.first())
          service = new Service(
          code,
          result.getString("nom"),
          result.getString("batiment"),
          result.getString("directeur")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return service;
  }

    @Override
    public Service find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}