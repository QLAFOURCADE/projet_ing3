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
 * @author Pierre-Louis, Quiterie et Tiphaine
 */
public class EmployeDAO extends DAO<Employe> {
  
    /**
     * CONSTRUCTEUR
     * @param conn 
     */
    public EmployeDAO(Connection conn) 
        {
            super(conn);
        }

 /**
  * METHODE : créee un employe 
  * @param obj
  * @return 
  */
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

 /**
  * METHODE : supprimer un employe 
  * @param obj
  * @return 
  */
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
   
  
  /**
   * METHODE : Modifier un employé
   * @param obj
   * @return 
   */
  @Override
   public boolean update(Employe obj) {
        try{
         
            int result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE employe SET nom='" +obj.getNom()+"', prenom ='"+obj.getPrenom()+"', adresse ='"+obj.getAdresse()+"', tel ='"+obj.getTel()+"' WHERE CONCAT(`employe`.`numero`) = '" + obj.getNumero()+ "'");
                        
        }
        catch (SQLException e) {
            e.printStackTrace();
            }
    return false;
    }
   
 
   /**
    * METHODE : Trouver un employe a partir de son numero
    * @param numero
    * @return 
    */
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