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
 * @author Pierre-Louis, Quiterie et Tiphaine
 */
public class ServiceDAO extends DAO<Service> {
  
    /**
     * CONSTRUCTEUR
     * @param conn 
     */
    public ServiceDAO(Connection conn) 
        {
            super(conn);
        }


    /**
     * METHODE : Créer un service
     * @param obj
     * @return 
     */
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


 /**
  * METHODE : Supprimer un service
  * @param obj
  * @return 
  */
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
   
  
 
  /**
   * METHODE : Modifier un service
   * @param obj
   * @return 
   */
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
   

  /**
   * METHODE : Trouver un infirmier a partir de son numero
   * @param code
   * @return 
   */
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

  /**
   * 
   * @param id
   * @return 
   */
    @Override
    public Service find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}