/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import modele.Docteur;
/**
 *
 * @author Pierre-Louis
 */
public class DocteurDAO extends DAO<Docteur> {
  public DocteurDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Docteur obj) {
    try{
            //ATTENTION IL FAUT QUE GETNUMERO CORRESPONDE AU NUMERO D'UN EMPLOYE
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO docteur VALUES ('"+ obj.getNumero() + "','" + obj.getSpecialite()+"')");
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
  }


  
  
  //Supprimer un docteur
  public boolean delete(Docteur obj) {
                try{
            
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM `docteur` WHERE `numero` = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
  
  
  //Mettre à jour un Docteur
  public boolean update(Docteur obj) {
    try{
         
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE docteur SET specialite='" +obj.getSpecialite()+"' WHERE CONCAT(`docteur`.`numero`) = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
  }
   
  //Trouver un docteur à partir de son numero
  public Docteur find(int numero) {
     Docteur docteur = new Docteur();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM docteur WHERE numero = " + numero);
      if(result.first())
        docteur = new Docteur(numero, result.getString("specialite"));       
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return docteur;
  }

    @Override
    public Docteur find2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
