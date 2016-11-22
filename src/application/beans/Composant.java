package application.beans; /***********************************************************************
 * Module:  application.beans.Composant.java
 * Author:  RENAUD + BORIS
 * Purpose: Defines the Class application.beans.Composant
 ***********************************************************************/

import application.interfaces.IComposant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Composant implements IComposant{

   /**
    * Déclaration des variables et des StringProperty
    */

   @NotNull
   private int id;

   @NotNull
   private String reference;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un constructeur valide")
   private String constructeur;

   @NotNull
   private String libelle;


   @NotNull
   private String details;

   private int idMachine;
   private String type;

   StringProperty idSP;
   StringProperty referenceSP;
   StringProperty constructeurSP;
   StringProperty libelleSP;
   StringProperty detailsSP;
   StringProperty idMachineSP;
   StringProperty typeSP;

   /**
    * Identifiant
    * Getter/Setter pour la variable + la StringProperty    *
    * @return
    */
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
      this.setIdSP(id);
   }

   public String getIdSP() {
      return idSP.get();
   }

   public int getIntIdSP() {
      return getId();
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

   public StringProperty idSPProperty() {
      return idSP;
   }

   /**
    * Référence
    * Getter/Setter pour la variable + la StringProperty
    * @return
    */

   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
      this.setReferenceSP(reference);
   }

   public String getReferenceSP() {
      return referenceSP.get();
   }

   public StringProperty referenceSPProperty() {
      return referenceSP;
   }

   public void setReferenceSP(String referenceSP) {
      this.referenceSP.set(referenceSP);
   }

   /**
    * Constructeur
    * Getter/Setter pour la variable + la StringProperty    *
    * @return
    */
   public String getConstructeur() {
      return constructeur;
   }

   public void setConstructeur(String constructeur) {
      this.constructeur = constructeur;
      this.setConstructeurSP(constructeur);
   }

   public String getConstructeurSP() {
      return constructeurSP.get();
   }

   public StringProperty constructeurSPProperty() {
      return constructeurSP;
   }

   public void setConstructeurSP(String constructeurSP) {
      this.constructeurSP.set(constructeurSP);
   }

   /**
    * Libellé
    * Getter/Setter pour la variable + la StringProperty    *
    * @return
    */
   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
      this.setLibelleSP(libelle);
   }

   public String getLibelleSP() {
      return libelleSP.get();
   }

   public StringProperty libelleSPProperty() {
      return libelleSP;
   }

   public void setLibelleSP(String libelleSP) {
      this.libelleSP.set(libelleSP);
   }


   /**
    * Détails
    * Getter/Setter pour la variable + la StringProperty    *
    * @return
    */
   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
      this.setDetailsSP(details);
   }

   public String getDetailsSP() {
      return detailsSP.get();
   }

   public StringProperty detailsSPProperty() {
      return detailsSP;
   }

   public void setDetailsSP(String detailsSP) {
      this.detailsSP.set(detailsSP);
   }

   /**
    * IdMachine
    * Getter/Setter pour la variable + la StringProperty    *
    * @return
    */
   public int getIdMachine() {
      return idMachine;
   }

   public void setIdMachine(int idMachine) {
      this.idMachine = idMachine;
      this.setIdMachineSP(String.valueOf(idMachine));
   }

   public String getIdMachineSP() {
      return idMachineSP.get();
   }

   public StringProperty idMachineSPProperty() {
      return idMachineSP;
   }

   public void setIdMachineSP(String idMachineSP) {
      this.idMachineSP.set(idMachineSP);
   }


   /**
    * Type
    * Getter/Setter pour la variable + la StringProperty    *
    * @return
    */
   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
      this.setTypeSP(type);
   }

   public String getTypeSP() {
      return typeSP.get();
   }

   public StringProperty typeSPProperty() {
      return typeSP;
   }

   public void setTypeSP(String typeSP) {
      this.typeSP.set(typeSP);
   }


   /**
    * Constructeurs
    */
   public Composant() {
   }

   public Composant(int id, String reference, String constructeur, String libelle, String details, int idMachine,String type) {
      this.id = id;
      this.reference = reference;
      this.constructeur = constructeur;
      this.libelle = libelle;
      this.details = details;
      this.idMachine = idMachine;
      this.type = type;
      this.remplirSP();
   }

   public void remplirSP() {
      // CONVERSION EN TYPE D'OBJETS OBSERVABLES
      this.idSP = new SimpleStringProperty(String.valueOf(this.getId()));
      this.referenceSP = new SimpleStringProperty(this.getReference());
      this.constructeurSP = new SimpleStringProperty(this.getConstructeur());
      this.libelleSP = new SimpleStringProperty(this.getLibelle());
      this.detailsSP = new SimpleStringProperty((this.getDetails()));
      this.idMachineSP = new SimpleStringProperty(String.valueOf(this.getIdMachine()));
      this.typeSP = new SimpleStringProperty(this.getType());
   }
}