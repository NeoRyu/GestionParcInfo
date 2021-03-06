package application.interfaces; /***********************************************************************
 * Module:  application.interfaces.IDAOHandler.java
 * Author:  RENAUD
 * Purpose: Defines the Interface application.interfaces.IDAOHandler
 ***********************************************************************/

import application.dao.DAOConnection;

import java.util.List;

public interface IDAOHandler {
    DAOConnection conn = new DAOConnection();

    <T> boolean ajouter(T objet, String query);

    boolean supprimer(String query, String id);

     <T> boolean modifier(T objet, String query, String id);

    <T> T lecture(String query, String id);

    <T> List<T> lecture(String query);


}