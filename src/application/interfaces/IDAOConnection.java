package application.interfaces; /***********************************************************************
 * Module:  application.interfaces.IDAOConnection.java
 * Author:  RENAUD
 * Purpose: Defines the Interface application.interfaces.IDAOConnection
 ***********************************************************************/


import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOConnection {

   final String ADRESSE= "jdbc:mysql://192.168.1.152:3306/itparkmanager";
   final String USER = "itparkmanager";
   final String MDP = "itparkmanager";
   final String DRIVER = "com.mysql.jdbc.Driver";

   Connection connexion();

   boolean fermer() throws SQLException;

}