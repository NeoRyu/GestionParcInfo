package application.dao; /***********************************************************************
 * Module:  application.dao.DAOMachine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOMachine
 ***********************************************************************/

import application.beans.Machine;
import application.interfaces.IDAOHandler;
import application.tools.Verif;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMachine implements IDAOHandler {

    /**
     * Ajout un objet de type machine dans la bdd
     * @param objet une machine
     * @param query le nom de la procédure stockée
     * @return true si l'insertion est réussi ou false si elle n'a pas réussi
     */
    @Override
    public <T> boolean ajouter(T objet, String query) {
        //Cast du parametre T en machine
        Machine machineAdd = (Machine) objet;
        try {
            //Verification si le bean est juste TODO déplacé ?
            Verif.verifier(machineAdd);

            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(query);

            //Ajout des parametres dans le callablestatement avant l'exécution du call
            cs.setInt(1, 1);
            cs.setString(2, machineAdd.getIdUnique());
            cs.setString(3, machineAdd.getIdAfpa());
            cs.setString(4, machineAdd.getDateAchat());
            cs.setInt(5, machineAdd.getDureeGarantie());
            cs.setString(6, machineAdd.getType());
            cs.setString(7, machineAdd.getAdresseIP());
            cs.setBoolean(8, machineAdd.isPret());
            cs.setInt(9, 1);

            //Call de l'ajout d'une machine
            cs.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Suppression d'une machine dans la bdd
     * @param query le nom de la procédure stockée
     * @param id de la machine a supprimer
     * @return true si la suppression est réussi ou false si elle n'a pas réussi
     */
    @Override
    public boolean supprimer(String query, String id) {
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(query);
            //ID de la machine a supprimer
            cs.setString(1, id);

            //Call de la suppression d'une machine
            cs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Modification d'une machine dans la bdd
     * @param objet une machine
     * @param query nom de la procédure stockée
     * @param id de la machine a modifier
     * @return true  si la modification est réussi ou false si elle n'a pas réussi
     */
    @Override
    public <T> boolean modifier(T objet, String query, String id) {
        Machine machineUpdate = (Machine) objet;
        try {
            //Verification si le bean est juste TODO déplacé ?
            Verif.verifier(machineUpdate);

            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(query);

            //Ajout des parametres dans le callablestatement avant l'exécution du call
            cs.setInt(1, 1);
            cs.setString(2, machineUpdate.getIdUnique());
            cs.setString(3, machineUpdate.getIdAfpa());
            cs.setString(4, machineUpdate.getDateAchat());
            cs.setInt(5, machineUpdate.getDureeGarantie());
            cs.setString(6, machineUpdate.getType());
            cs.setString(7, machineUpdate.getAdresseIP());
            cs.setBoolean(8, machineUpdate.isPret());
            cs.setInt(9, 1);

            //ID de la machine a modifier
            cs.setString(10, id);

            //Call de la modification d'une machine
            cs.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Lecture d'une machine dans la bdd
     * @param query nom de la procédure stockée
     * @param id de la machine
     * @return une machine
     */
    @Override
    public <T> T lecture(String query, String id) {
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(query);
            //ID de la machine a lire
            cs.setInt(1, Integer.parseInt(id));

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = cs.executeQuery();


            rs.first();

            //Remplissage de l'objet machine
            Machine machineTemp = new Machine();
            machineTemp.setId(rs.getInt(1));
            machineTemp.setIdLocal(rs.getInt(2));
            machineTemp.setIdUnique(rs.getString(3));
            machineTemp.setIdAfpa(rs.getString(4));
            machineTemp.setDateAchat(rs.getString(5));
            machineTemp.setDureeGarantie(rs.getInt(6));
            machineTemp.setType(rs.getString(7));
            machineTemp.setAdresseIP(rs.getString(8));
            machineTemp.setPret(rs.getBoolean(9));
            machineTemp.setLocalOrigine(rs.getInt(10));

            //Cast de la machine en T
            return (T) machineTemp;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Lecture de toutes les machines de la bdd
     * @param query nom de la procédure stockée
     * @return une list de machine
     */
    @Override
    public <T> List<T> lecture(String query) {
        //List de T qui contiendra les machines
        List<T> machines = new ArrayList<>();
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(query);

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = cs.executeQuery();

            //Ajout des resultats de la requete dans des objets machine puis ajouts dans la list T
            while (rs.next()) {
                Machine machineTemp = new Machine();
                machineTemp.setId(rs.getInt(1));
                machineTemp.setIdLocal(rs.getInt(2));
                machineTemp.setIdUnique(rs.getString(3));
                machineTemp.setIdAfpa(rs.getString(4));
                machineTemp.setDateAchat(rs.getString(5));
                machineTemp.setDureeGarantie(rs.getInt(6));
                machineTemp.setType(rs.getString(7));
                machineTemp.setAdresseIP(rs.getString(8));
                machineTemp.setPret(rs.getBoolean(9));
                machineTemp.setLocalOrigine(rs.getInt(10));
                machines.add((T) machineTemp);
            }
            return machines;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

}