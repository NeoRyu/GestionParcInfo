package application.DAO.objets; 
/***********************************************************************
 * Module:  application.objets.Machine.java
 * Author:  FREDERIC
 * Purpose: Defines the Class application.objets.Machine
 ***********************************************************************/

import java.util.Collection;
import java.util.Date;
//import java.util.Map;
import java.util.Properties;

// IMPORT DES PROPERTIES :
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
/*	PROPERTY :
 *	Avec JavaFX il est courant d'utiliser les Properties pour tous les champs de votre classe.
 *	Une Property (propriété) nous permet, par exemple, d'être automatiquement averti lorsque la
 *	variable id ou toute autre variable a été modifiée. 
 *	Ceci nous aide à maintenir la view synchronisée avec les données. 
 */

//import javafx.beans.binding.Bindings;
//import javafx.util.StringConverter;



/** @pdOid 29bd1de5-32fa-4bc5-ac7b-a0c0ed192d80 */
public class Machine {
	
		//STRING - TODO : types variables a revoir
	   private String id;
	   private String idAfpa;
	   private String idUnique;
	   private String dateAchat;
	   private String dureeGarantie;
	   private String adresseIP;
	   private String type;
	   
	   // STRINGPROPERTY
	   private StringProperty idSP;
	   private StringProperty idAfpaSP;
	   private StringProperty idUniqueSP;
	   private StringProperty dateAchatSP;
	   private StringProperty dureeGarantieSP;
	   private StringProperty adresseIPSP;
	   private StringProperty typeSP;
	   
	   // COMPOSANTS - TODO
	   /** @pdRoleInfo migr=no name=application.objets.Composant assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
	   private java.util.Collection<Composant> composant;
	

	   /*
	    * GETTERS / SETTERS
	    */
	   
	   // ID
	   public String getId() {
		      return id;
	   }
	   public void setId(String id) {
		   this.id = id;
	   }
	   // StringProperty
	   public String getIdSP() {
		   return idSP.get();
	   }
	   public int getIntIdSP() {
		   return Integer.parseInt(getId());
	   }
	   public void setIdSP(String id) {
		   this.idSP.set(id);
	   }
	   public void setIdSP(int id) {
		   this.idSP.set(String.valueOf(id));
	   }
	   public StringProperty idProperty() {
		   return idSP;
	   }
	
	
	   // IDAFPA
	   public String getIdAfpa() {
	      return idAfpa;
	   }
	   public void setIdAfpa(String idAfpa) {
	      this.idAfpa = idAfpa;
	   }
	   // StringProperty
	   public String getIdAfpaSP() {
	      return idAfpaSP.get();
	   }
	   public void setIdAfpaSP(String idAfpa) {
	      this.idAfpaSP.set(idAfpa);
	   }
	   public StringProperty idAfpaProperty() {
		   return idAfpaSP;
	   }
	
	   // IDUNIQUE
	   public String getIdUnique() {
	      return idUnique;
	   }
	   public void setIdUnique(String idUnique) {
	      this.idUnique = idUnique;
	   }
	   // StringProperty
	   public String getIdUniqueSP() {
	      return idUniqueSP.get();
	   }
	   public void setIdUniqueSP(String idUnique) {
	      this.idUniqueSP.set(idUnique);
	   }
	   public StringProperty idUniqueProperty() {
		   return idUniqueSP;
	   }
		   
	   // DATEACHAT
	   public String getDateAchat() {
	      return dateAchat;
	   }
	   public void setDateAchat(String dateAchat) {
	      this.dateAchat = dateAchat;
	   }
	   // StringProperty
	   public String getDateAchatSP() {
		   return dateAchatSP.get();
	   }
	   public void setDateAchatSP(String dateAchat) {
	      this.dateAchatSP.set(dateAchat);
	   }
	   public StringProperty dateAchatProperty() {
		   return dateAchatSP;
	   }
	
	   // DUREEGARANTIE
	   public String getDureeGarantie() {
	      return dureeGarantie;
	   }
	   public void setDureeGarantie(String dureeGarantie) {
	      this.dureeGarantie = dureeGarantie;
	   }
	   // StringProperty
	   public String getDureeGarantieSP() {
	      return dureeGarantieSP.get();
	   }
	   public int getIntDureeGarantieSP() {
		   return Integer.parseInt(getDureeGarantie());
	   }
	   public void setDureeGarantieSP(String dureeGarantie) {
	      this.dureeGarantieSP.set(dureeGarantie);
	   }
	   public void setDureeGarantieSP(int duree) {
		   this.dureeGarantieSP.set(String.valueOf(duree));
	   }
	   public StringProperty dureeGarantieProperty() {
		   return dureeGarantieSP;
	   }
	
	   // ADRESSEIP
	   public String getAdresseIP() {
	      return adresseIP;
	   }
	   public void setAdresseIP(String adresseIP) {
	      this.adresseIP = adresseIP;
	   }
	   // StringProperty
	   public String getAdresseIPSP() {
	      return adresseIPSP.get();
	   }
	   public void setAdresseIPSP(String adresseIP) {
	      this.adresseIPSP.set(adresseIP);
	   }
	   public StringProperty adresseIPProperty() {
		   return adresseIPSP;
	   }
	
	   // TYPE
	   public String getType() {
	      return type;
	   }
	   public void setType(String type) {
	      this.type = type;
	   }
	   // StringProperty
	   public String getTypeSP() {
	      return typeSP.get();
	   }
	   public void setTypeSP(String type) {
	      this.typeSP.set(type);
	   }
	   public StringProperty typeProperty() {
		   return typeSP;
	   }
	   
	
	   
	   /* 
	    * CONSTRUCTEURS
	    */
	   public Machine() {
		   /*
		  this.id = "";
	      this.idAfpa = "";
	      this.idUnique = "";
	      this.dateAchat = "";
	      this.dureeGarantie = "";
	      this.adresseIP = "";
	      this.type = "";
	      this.idSP= new SimpleStringProperty("");
	      this.idAfpaSP = new SimpleStringProperty("");
	      this.idUniqueSP = new SimpleStringProperty("");
	      this.dateAchatSP = new SimpleStringProperty("");
	      this.dureeGarantieSP = new SimpleStringProperty("");
	      this.adresseIPSP = new SimpleStringProperty("");
	      this.typeSP = new SimpleStringProperty("");
	      */
	   }
	   
	   public Machine(String id, String idAfpa, String idUnique, String dateAchat, String dureeGarantie, String adresseIP, String type) {	   
		      this.id = id;
		      this.idAfpa = idAfpa;
		      this.idUnique = idUnique;
		      this.dateAchat = dateAchat;
		      this.dureeGarantie = dureeGarantie;
		      this.adresseIP = adresseIP;
		      this.type = type;
		      
			  // CONVERSION EN TYPE D'OBJETS OBSERVABLES
		      this.idSP= new SimpleStringProperty(id);
		      this.idAfpaSP = new SimpleStringProperty(idAfpa);
		      this.idUniqueSP = new SimpleStringProperty(idUnique);
		      this.dateAchatSP = new SimpleStringProperty(dateAchat);
		      this.dureeGarantieSP = new SimpleStringProperty(dureeGarantie);
		      this.adresseIPSP = new SimpleStringProperty(adresseIP);
		      this.typeSP = new SimpleStringProperty(type);
	   }
	   /*
	   public Machine(String id, String idAfpa, String idUnique, Date dateAchat, String dureeGarantie, String adresseIP, String type, Collection<Composant> composant) {
		  // CONVERSION EN TYPE D'OBJETS OBSERVABLES
	      this.id = new SimpleStringProperty(id);
	      this.idAfpa = new SimpleStringProperty(idAfpa);
	      this.idUnique = new SimpleStringProperty(idUnique);
	      this.dateAchat = new SimpleObjectProperty<java.util.Date>(dateAchat);
	      this.dureeGarantie = new SimpleStringProperty(dureeGarantie);
	      this.adresseIP = new SimpleStringProperty(adresseIP);
	      this.type = new SimpleStringProperty(type);
	      // ET DE COMPOSANTS
	      this.composant = composant;
	   }
	   */
	
	   
	   /*
	    *  COMPOSANTS
	    */
	   /**
	     * @return  *  @pdGenerated default getter */
	   public java.util.Collection<Composant> getComposant() {
	      if (composant == null)
	         composant = new java.util.HashSet<Composant>();
	      return composant;
	
	   }   
	   
	   /**
	     * @return  *  @pdGenerated default iterator getter */
	   public java.util.Iterator getIteratorComposant() {
	      if (composant == null)
	         composant = new java.util.HashSet<Composant>();
	      return composant.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newComposant */
	   public void setComposant(java.util.Collection<Composant> newComposant) {
	      removeAllComposant();
	      for (java.util.Iterator iter = newComposant.iterator(); iter.hasNext();)
	         addComposant((Composant)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newComposant */
	   public void addComposant(Composant newComposant) {
	      if (newComposant == null)
	         return;
	      if (this.composant == null)
	         this.composant = new java.util.HashSet<Composant>();
	      if (!this.composant.contains(newComposant))
	         this.composant.add(newComposant);
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldComposant */
	   public void removeComposant(Composant oldComposant) {
	      if (oldComposant == null)
	         return;
	      if (this.composant != null)
	         if (this.composant.contains(oldComposant))
	            this.composant.remove(oldComposant);
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllComposant() {
	      if (composant != null)
	         composant.clear();
	   }
	   
	
	
	   // TODO
	   /**
	     * @return  *  @pdOid c048567c-b284-4a21-af5d-7e4f990bf0fe */
	   public boolean estSousGarantie() {
	      // TODO: implement
	      return false;
	   }
	   // TODO : ?
	   /**
	     * @return  *  @pdOid ed539b07-b49c-4883-8b95-773e5a3a6699 */
	   public boolean ipDispo() {
	      // TODO: implement
	      return false;
	   }
}