package application.dao;

import application.interfaces.IDAOHandler;

import java.util.List;

/**
 * Created by RENAUD on 08/11/2016.
 */
public class DAOComposant implements IDAOHandler {


    @Override
    public <T> boolean ajouter(T objet, String query) {
        return false;
    }

    @Override
    public boolean supprimer(String query, String id) {
        return false;
    }

    @Override
    public <T> boolean modifier(T objet, String query, String id) {
        return false;
    }


    @Override
    public <T> T lecture(String query, String id) {
        return null;
    }

    @Override
    public <T> List<T> lecture(String query) {
        try {

            List<T> tList = null;
            //tList = (List<T>) composants;

            return tList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            conn.fermer();
        }
    }

}
