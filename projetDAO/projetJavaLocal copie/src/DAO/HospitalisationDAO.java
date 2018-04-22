/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Hospitalisation;
/**
 *
 * @author Pierre-Louis, Quiterie et Tiphaine
 */
public class HospitalisationDAO extends DAO<Hospitalisation> {
    
    /**
     * CONSTRUCTEUR
     * @param conn 
     */
  public HospitalisationDAO(Connection conn) {
    super(conn);
  }


  /**
   * METHODE : Créer une hospitalisation
   * @param obj
   * @return 
   */
 @Override
 public boolean create(Hospitalisation obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO hospitalisation VALUES ('"+ obj.getNo_Malade() + "','" + obj.getCodeService() + "','" + obj.getNo_Chambre()+"','" + obj.getLit() +"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  /**
   * METHODE : Supprimer une hospitalisation
   * @param obj
   * @return 
   */
  @Override
  public boolean delete(Hospitalisation obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `hospitalisation` WHERE `numero` = '" + obj.getNo_Malade()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  
  /**
   * METHODE : Update une hospitalisation
   * @param obj
   * @return 
   */
  @Override
   public boolean update(Hospitalisation obj) {
                        try{
           
             System.out.println("Vous avez choisis de modifier une hospitalisation ");               
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `hospitalisation` SET `code_service` = '"+obj.getCodeService()+"', no_chambre ='"+obj.getNo_Chambre() + "', lit ='"+obj.getLit() + "' WHERE CONCAT(`hospitalisation`.`no_malade`) = '" + obj.getNo_Malade()+ "'");           
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  /**
   * METHODE : Trouver une hospitalisation à partir du numero du malade
   * @param num_malade
   * @return 
   */
  @Override
  public Hospitalisation find(int num_malade) {
    Hospitalisation hospitalisation = new Hospitalisation();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM hospitalisation WHERE no_malade = " + num_malade);
      if(result.first())
        hospitalisation = new Hospitalisation( 
          num_malade,
          result.getString("code_service"),
          result.getInt("no_chambre"),
          result.getInt("lit")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return hospitalisation;
  }
 
}