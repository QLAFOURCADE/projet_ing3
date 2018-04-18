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
                ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `chambre` WHERE `no_chambre` = '" + obj.getNum_ch()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
  @Override
   public boolean update(Chambre obj) {
                        try{
            String a1="";
             int b1=0;
             int c1=0;
             Scanner sc = new Scanner(System.in);
             System.out.println("Vous avez choisis de modifier un element ");
             a1=sc.next();
             b1=sc.nextInt();
             c1=sc.nextInt();                
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE chambre SET code_service ='" +a1+"', surveillant ='"+b1+"', nb_lits ='"+c1+"' WHERE no_chambre = '" + obj.getNum_ch()+ "'");
                        
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
          num_ch,
          result.getInt("nb_lits")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return chambre;
  }

   
}