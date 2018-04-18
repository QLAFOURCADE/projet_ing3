/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Chambre;
/**
 *
 * @author Pierre-Louis
 */
public class ChambreDAO extends DAO<Chambre> {
  public ChambreDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Chambre obj) {
    return false;
  }

  public boolean delete(Chambre obj) {
    return false;
  }
   
  public boolean update(Chambre obj) {
    return false;
  }
   
  //Trouver une chambre à partir de son ID
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