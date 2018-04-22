/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * @author Pierre-Louis, Tiphaine, Quiterie
 */

//Librairies
import java.sql.*;

public class Connexion{

  private static String url = "jdbc:mysql://127.0.0.1:8889/hopital";
  private static String user = "root";
  private static String passwd = "root";
  private static Connection connect;
   
  public static Connection getInstance(){
    if(connect == null){
      try {
        connect = DriverManager.getConnection(url, user, passwd);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }      
    return connect;
  }
  
  public void Verif_Connexion(String nom_bdd, String login, String mdp) throws SQLException
  {
      String url_bis = "jdbc:mysql://localhost/" + nom_bdd;
      //String url_bis = "jdbc:mysql://127.0.0.1:8889/" + nom_bdd;
      String user_bis = login;
      String passwd_bis = mdp;
      
      //création d'une connexion JDBC à la base 
      connect = DriverManager.getConnection(url_bis, user_bis, passwd_bis);
      
  }
}