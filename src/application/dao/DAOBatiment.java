package application.dao; /***********************************************************************
 * Module:  application.dao.DAOBatiment.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOBatiment
 ***********************************************************************/

import application.interfaces.IDAOHandler;

/** @pdOid 5deba7bc-222a-4be2-aa5d-20689d4fd332 */
public class DAOBatiment implements IDAOHandler {

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