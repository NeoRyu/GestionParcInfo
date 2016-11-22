package application.dao; /***********************************************************************
 * Module:  application.dao.DAOMachine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.dao.DAOMachine
 ***********************************************************************/

import application.beans.Machine;
import application.interfaces.IDAOHandler;
import application.tools.ComposantFactory;
import application.tools.LectureRB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMachine implements IDAOHandler {

    /**
     * Ajout un objet de type machine dans la bdd
     * @param objet une machine
     * @return true si l'insertion est réussi ou false si elle n'a pas réussi
     */
    @Override
    public <T> boolean ajouter(T objet) {
        //Cast du parametre T en machine
        Machine machineAdd = (Machine) objet;
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "insertionMachine"));

            //Ajout des parametres dans le callablestatement avant l'exécution du call
            getMachine(machineAdd, cs);

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
     * Modification d'une machine dans la bdd
     * @param objet une machine
     * @param id de la machine a modifier
     * @return true  si la modification est réussi ou false si elle n'a pas réussi
     */
    @Override
    public <T> boolean modifier(T objet, String id) {
        Machine machineUpdate = (Machine) objet;
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "modificationMachine"));

            //Ajout des parametres dans le callablestatement avant l'exécution du call
            getMachine(machineUpdate, cs);

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
     * Suppression d'une machine dans la bdd
     * @param id    de la machine a supprimer
     * @return true si la suppression est réussi ou false si elle n'a pas réussi
     */
    @Override
    public boolean supprimer(String id) {
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "supressionMachine"));
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
     * Lecture de toutes les machines de la bdd
     * @return une list de machine
     */
    public List<Machine> lecture() {
        //List de T qui contiendra les machines
        List<Machine> machines = new ArrayList<>();
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "lectureMachines"));

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = cs.executeQuery();

            //Ajout des resultats de la requete dans des objets machine puis ajouts dans la list T
            while (rs.next()) {
                Machine machineTemp = setMachine(rs);
                machines.add(machineTemp);
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

    /**
     * Donne les données aux CallableStatement
     * @param machine a ajouter ou modifier
     * @param cs CallableStatement qui recupére les odnnées
     * @throws SQLException
     */
    private void getMachine(Machine machine, CallableStatement cs) throws SQLException {
        cs.setInt(1, 1);
        cs.setString(2, machine.getIdUnique());
        cs.setString(3, machine.getIdAfpa());
        cs.setString(4, machine.getDateAchat());
        cs.setInt(5, machine.getDureeGarantie());
        cs.setString(6, machine.getType());
        cs.setString(7, machine.getAdresseIP());
        cs.setBoolean(8, machine.isPret());
        cs.setInt(9, 1);
    }


    /**
     * Récupère les données du Resultset
     * @param rs resultat de la requete
     * @return machine
     * @throws SQLException
     */
    private Machine setMachine(ResultSet rs) throws SQLException {
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
        machineTemp.setComposant(new ArrayList<>());
        return machineTemp;
    }

    /**
     * Compte le nombre de ligne dans la bdd par rapport a une adresse IP
     * @param adresseIP adresseIP a verifier
     * @return le nombre d'adresse
     */
    public int machineIP(String adresseIP){
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "countAdresseIP"));
            cs.setString(1, adresseIP);

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = cs.executeQuery();

            rs.first();

            //Nombre de machine avec cette adresse ip
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }
}