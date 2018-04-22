/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modele.*;
import java.sql.*;

/**
 *  INTERFACE DAO : classe totalement abstraite
 *              le but : automatiser les fontions insert/update/delete
 * @author Pierre-Louis, Quiterie et Tiphaine
 */
public abstract class DAO <T> {
    /**
     * attributs de l'interface 
     */
  protected Connection connect = null;
  
  /**
   * CONSTRUCTEUR
   * @param conn 
   */
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
}