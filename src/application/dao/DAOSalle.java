package application.dao; /***********************************************************************
 * Module:  application.dao.DAOSalle.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOSalle
 ***********************************************************************/

import application.interfaces.IDAOHandler;

import java.util.List;

/** @pdOid 48949297-0e27-4222-ae4f-02358912267c */
public class DAOSalle implements IDAOHandler {


    @Override
    public <T> boolean ajouter(T objet) {
        return false;
    }

    @Override
    public <T> boolean modifier(T objet, String id) {
        return false;
    }

    @Override
    public boolean supprimer(String id) {
        return false;
    }

}