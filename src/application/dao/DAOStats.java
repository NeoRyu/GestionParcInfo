package application.dao;

import application.beans.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by RENAUD on 23/11/2016.
 * Edited by Noo_Ryu
 */
public class DAOStats {

    DAOConnection conn = new DAOConnection();
    private static ResourceBundle config = ResourceBundle.getBundle("application.Config");
    
 // Liste d'objets de type Stats
    public List<Stats> viewStat = new ArrayList<>();    
    
 // Liste d'objets observable de type Stats
	private ObservableList<Stats> obsListStats = FXCollections.observableArrayList();
	public ObservableList<Stats> getObsListStats() {
		return obsListStats;
	}
	public void setObsListStats(ObservableList<Stats> obsListStats) {
		this.obsListStats = obsListStats;
	}
 // Methode permettant l'ajout d'une stat dans la liste
	public void addToObsList(Stats data) {
		this.obsListStats.add(data);
	}
	
	
    
    /**
     * count type machine
     * @return 
     */
	// Ajout de la liste des stats concernant le type de machine a la liste des stats
	public void addTypeMachine(String requete) throws SQLException {		
		setObsListStats(countTypeMachine(requete));
    }
	// Recupération de ma liste des stats concernant les types de machines
    public ObservableList<Stats> countTypeMachine(String requete) {
    	ObservableList<Stats> listTemp = FXCollections.observableArrayList();
        try {
            //Ouverture de la connexion et préparation du call
            PreparedStatement ps = conn.connexion().prepareStatement(requete);

            //Stockage du résultat de la requete dans un resultset
            ResultSet rs = ps.executeQuery();

            //Ajout des resultats de la requete
            Stats stats = new Stats();
            while (rs.next()) {

            	// Ajout dans une list d'objets observables les Stats recupérées
            	listTemp.add(stats.add(rs.getString(1), rs.getString(2)));
            	if(config.getString("test").equals("1")) {
            		System.out.println(rs.getString(1) + " " + rs.getString(2));
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //return null;
        } finally {
            //Fermeture de la connexion
            conn.fermer();
        }
        
		return listTemp;
    }
	
}