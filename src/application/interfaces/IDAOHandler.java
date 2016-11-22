package application.interfaces; /***********************************************************************
 * Module:  application.interfaces.IDAOHandler.java
 * Author:  RENAUD
 * Purpose: Defines the Interface application.interfaces.IDAOHandler
 ***********************************************************************/

import java.util.List;

import application.dao.DAOConnection;
import application.tools.LectureRB;

public interface IDAOHandler {
    DAOConnection conn = new DAOConnection();
    LectureRB lrb = new LectureRB();

    <T> boolean ajouter(T objet);

    <T> boolean modifier(T objet, String id);

    boolean supprimer(String id);

}