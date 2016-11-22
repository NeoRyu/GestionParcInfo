package application.dao;

import application.beans.*;
import application.interfaces.IDAOHandler;
import application.tools.ComposantFactory;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENAUD on 08/11/2016.
 */
public class DAOComposant implements IDAOHandler {

    ComposantFactory composantFactory = new ComposantFactory();

    /**
     * Ajout dans la base d'un objet Composant
     * @param objet Composant ou T extends Composant
     * @return true si l'ajout a été effectué
     */
    @Override
    public <T> boolean ajouter(T objet) {
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "insertionComposant"));

            //Ajout des parametres dans le callablestatement avant l'exécution du call
            getComposant(objet, cs);

            //Call de l'ajout d'un composant
            cs.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Modification dans la d'un objet Composant
     * @param objet Composant ou T extends Composant
     * @param id du COmposant a modifier
     * @return true si la modification a été effectué
     */
    @Override
    public <T> boolean modifier(T objet, String id) {
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "modificationComposant"));

            //Ajout des parametres dans le callablestatement avant l'exécution du call
            getComposant(objet, cs);
            //Numéro du composant a modifié
            cs.setString(12, id);

            //Call de la modification d'un composant
            cs.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Suppression d'un composant dans la bdd
     * @param id du composant a supprmier
     * @return true si la suppresion a été effectué
     */
    @Override
    public boolean supprimer(String id) {
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "supressionComposant"));
            //ID du composant a supprimer
            cs.setString(1, id);

            //Call de la suppresion d'un composant
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
     * Lecture de tous les composants
     * @return list de Composants
     */
    public <T extends Composant> List<T> lecture() {
        //List de T qui contiendra les composants
        List<T> composants = new ArrayList<>();
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "lectureAllComposants"));

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = cs.executeQuery();

            //Ajout des resultats de la requete dans une liste de composants
            while (rs.next()) {
                T composant = (T) composantFactory.getComposant(rs);
                composants.add(composant);
            }
            return composants;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Lecture de tous les composants d'une machine
     * @param id de la machine
     * @ list de Composants
     */
    public <T extends Composant> List<T> lecture(int id) {
        //List de T qui contiendra les composants
        List<T> composants = new ArrayList<>();
        try {
            //Ouverture de la connexion et préparation du call
            CallableStatement cs = conn.connexion().prepareCall(lrb.lireRB("query", "lectureComposants"));
            //Numéro de la machine
            cs.setInt(1, id);

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = cs.executeQuery();

            //Ajout des resultats de la requete dans une liste de composants
            while (rs.next()) {
                T composant = (T) composantFactory.getComposant(rs);
                composants.add(composant);
            }
            return composants;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
    }

    /**
     * Récupére les données d'un composant et les mets dans le callablestatement
     * @param objet a recupérer les infos
     * @param cs callablestatement
     * @throws SQLException
     */
    private <T> void getComposant(T objet, CallableStatement cs) throws SQLException {
        if (objet instanceof CarteMere) {
            CarteMere carteMere = (CarteMere) objet;
            getSuperComposant(cs, carteMere);
            cs.setString(5, carteMere.getFormat());
            cs.setString(7, null);
            cs.setString(8, null);
            cs.setString(9, null);
            cs.setString(10, null);
        } else if (objet instanceof DisqueDur) {
            DisqueDur disqueDur = (DisqueDur) objet;
            getSuperComposant(cs, disqueDur);
            cs.setString(5, disqueDur.getFormat());
            cs.setInt(7, disqueDur.getStockageGo());
            cs.setString(8, null);
            cs.setString(9, null);
            cs.setString(10, null);
        } else if (objet instanceof Logiciel) {
            Logiciel logiciel = (Logiciel) objet;
            getSuperComposant(cs, logiciel);
            cs.setInt(8, logiciel.getArchitecture());
            cs.setString(5, null);
            cs.setString(7, null);
            cs.setString(9, null);
            cs.setString(10, null);
        } else if (objet instanceof Processeur) {
            Processeur processeur = (Processeur) objet;
            getSuperComposant(cs, processeur);
            cs.setInt(9, processeur.getCoeurs());
            cs.setInt(10, processeur.getFrequence());
            cs.setString(5, null);
            cs.setString(7, null);
            cs.setString(8, null);
        } else if (objet instanceof Ram) {
            Ram ram = (Ram) objet;
            getSuperComposant(cs, ram);
            cs.setInt(7, ram.getCapaciteGo());
            cs.setString(5, null);
            cs.setString(8, null);
            cs.setString(9, null);
            cs.setString(10, null);
        } else if (objet instanceof SystemeExploitation) {
            SystemeExploitation systemeExploitation = (SystemeExploitation) objet;
            getSuperComposant(cs, systemeExploitation);
            cs.setString(5, systemeExploitation.getFormat());
            cs.setInt(8, systemeExploitation.getArchitecture());
            cs.setString(7, null);
            cs.setString(9, null);
            cs.setString(10, null);
        } else {
            Composant composant = (Composant) objet;
            getSuperComposant(cs, composant);
            cs.setString(5, null);
            cs.setString(7, null);
            cs.setString(8, null);
            cs.setString(9, null);
            cs.setString(10, null);
        }
    }

    /**
     * Récupére les données d'un composant et les mets dans le callablestatement
     * @param temp info générique d'un composant
     * @param cs callablestatement
     * @throws SQLException
     */
    private <T extends Composant> void getSuperComposant(CallableStatement cs, T temp) throws SQLException {
        cs.setString(1, temp.getLibelle());
        cs.setString(2, temp.getReference());
        cs.setString(3, temp.getConstructeur());
        cs.setString(4, temp.getDetails());
        cs.setString(6, temp.getType());
        cs.setInt(11,temp.getIdMachine());
    }

}