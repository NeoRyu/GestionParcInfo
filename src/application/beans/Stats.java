package application.beans;

import application.dao.DAOStats;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;



public class Stats {	
	
	private DAOStats daoStats = new DAOStats();
	private ObservableList<Stats> listStats = FXCollections.observableArrayList();

	
 // VARIABLES LOCALES
    private String nom;
    private int qte;
 // STRINGPROPERTY
    private StringProperty nomSP;
    private StringProperty qteSP;
    
    
    
 // GETTERS / SETTERS
    // NOM DU TYPE D'OBJET
    public String getNom() {
        return nom;
    }
    public void setNom(String txt) {
        this.nom = txt;
        this.setNomSP(txt);
    }
    // StringProperty
    public String getNomSP() {
        return nomSP.get();
    }
    public void setNomSP(String txt) {
        this.nomSP.set(String.valueOf(txt));
    }
    public StringProperty nomProperty() {
        return nomSP;
    }
    
    
    // QUANTITE
    public int getQte() {
        return qte;
    }
    public void setQte(int nbr) {
        this.qte = nbr;
        this.setQteSP(nbr);
    }
    public void setQte(String txt) {
        this.qte = Integer.parseInt(txt);
        this.setQteSP(txt);
    }
    // StringProperty
    public String getQteSP() {
        return qteSP.get();
    }
    public int getIntQteSP() {
        return getQte();
    }    
    public void setQteSP(int nbr) {
        this.qteSP.set(String.valueOf(nbr));
    }
    public void setQteSP(String txt) {
        this.qteSP.set(txt);
    }
    public StringProperty qteProperty() {
        return qteSP;
    }
    
    
    
 // CONSTRUCTEURS
    public Stats() {
        this.remplirSP();
    }
    public Stats(String nom, String qte) {
        this.nom = nom;
        this.qte = Integer.parseInt(qte);
        this.remplirSP();
    }
    public Stats(String txt, int nbr) {
        this.nom = txt;
        this.qte = nbr;
        this.remplirSP();
    }
    public Stats(int nbr, String txt) {
        this.nom = txt;
        this.qte = nbr;
        this.remplirSP();
    }
    public void remplirSP() {
        // CONVERSION EN TYPE D'OBJETS OBSERVABLES
        this.nomSP = new SimpleStringProperty(String.valueOf(this.getNom()));
        this.qteSP = new SimpleStringProperty(String.valueOf(this.getQte()));
    }   
    
    // Methode d'ajout d'une Stat
	public Stats add(String data1, String data2) {
		return new Stats(data1, data2);
	}
	
	
}
