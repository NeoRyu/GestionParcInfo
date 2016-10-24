package application.DAO; /***********************************************************************
 * Module:  application.DAO.DAOConnection.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.DAO.DAOConnection
 ***********************************************************************/

import application.interfaces.IDAOConnection;

import java.util.*;

/** @pdOid e1f67259-29a6-4ad8-8312-7ca59c54385f */
public class DAOConnection implements IDAOConnection {
    @Override
    public boolean connexion() {
        return false;
    }

    @Override
    public boolean fermer() {
        return false;
    }
}