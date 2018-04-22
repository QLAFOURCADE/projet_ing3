/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Chambre;
import java.util.Scanner;
/**
 *
 * @author Pierre-Louis
 */
public class ChambreDAO extends DAO<Chambre> {
  public ChambreDAO(Connection conn) {
    super(conn);
  }


 @Override
 public boolean create(Chambre obj) {
        try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO chambre VALUES ('"+ obj.getCodeService() + "','" + obj.getNum_ch() + "','" + obj.getIdSurveillant()+"','" + obj.getNb_lits() +"')" );
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }

  @Override
  public boolean delete(Chambre obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `chambre` WHERE `chambre`.`code_service` = \'"+obj.getCodeService()+"\' AND CONCAT(`chambre`.`no_chambre`) = \'"+obj.getNum_ch()+"\'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  @Override
   public boolean update(Chambre obj) {
                        try{
           
             System.out.println("Vous avez choisis de modifier une chambre ");               
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE `chambre` SET `nb_lits` = '"+obj.getNb_lits()+"', surveillant ='"+obj.getIdSurveillant() + "' WHERE `chambre`.`code_service` = '"+obj.getCodeService()+"' AND CONCAT(`chambre`.`no_chambre`) = '"+obj.getNum_ch()+"'");            
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  //Trouver une chambre à partir de son ID
  @Override
  public Chambre find(int num_ch) {
    Chambre chambre = new Chambre();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM chambre WHERE no_chambre = " + num_ch);
      if(result.first())
        chambre = new Chambre(
          result.getString("code_service"),
          num_ch,
          result.getInt("surveillant"),
          result.getInt("nb_lits")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return chambre;
  }

    @Override
    public Chambre find2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}