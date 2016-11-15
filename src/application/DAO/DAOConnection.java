package application.dao; /***********************************************************************
 * Module:  application.dao.DAOConnection.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOConnection
 ***********************************************************************/

import application.interfaces.IDAOConnection;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @pdOid e1f67259-29a6-4ad8-8312-7ca59c54385f
 */
public class DAOConnection implements IDAOConnection {

    Connection conn = null;

    @Override
    public Connection connexion() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(ADRESSE,USER,MDP);

            return conn;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean fermer() {
        try {
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}