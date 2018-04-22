/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Soigne;
/**
 *
 * @author Pierre-Louis, Quiterie et Tiphaine
 */
public class SoigneDAO extends DAO<Soigne> {
    
    /**
     * CONSTRUCTEUR
     * @param conn 
     */
  public SoigneDAO(Connection conn) {
    super(conn);
  }


  /**
   * METHODE : Créer dans soigne
   * @param obj
   * @return 
   */
 @Override
 public boolean create(Soigne obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO soigne VALUES ('"+ obj.getNo_Docteur() + "','" + obj.getNo_Malade() +"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  
 /**
  * METHODE : Supprimer dans soigne
  * @param obj
  * @return 
  */
  @Override
  public boolean delete(Soigne obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `soigne` WHERE `soigne`.`no_docteur` = \'"+obj.getNo_Docteur()+"\' AND CONCAT(`soigne`.`no_malade`) = \'"+obj.getNo_Malade()+"\'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  /**
   * METHODE : Trouver une hospitalisation à partir du numero du docteur
   * @param no_docteur
   * @return 
   */
  @Override
  public Soigne find(int no_docteur) {
    Soigne soigne = new Soigne();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM soigne WHERE no_docteur = " + no_docteur);
      if(result.first())
        soigne = new Soigne( 
          no_docteur,
          result.getInt("no_malade")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return soigne;
  }

  /**
   * 
   * @param obj
   * @return 
   */
    @Override
    public boolean update(Soigne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
}