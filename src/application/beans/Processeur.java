package application.beans; /***********************************************************************
 * Module:  application.beans.Processeur.java
 * Author:  RENAUD + BORIS
 * Purpose: Defines the Class application.beans.Processeur
 ***********************************************************************/

import application.interfaces.IComposant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/** @pdOid 5d6517c4-b800-475d-9f03-aa10f3fba23c */
public class Processeur extends Composant implements IComposant {

   @NotNull
   @Min(1)
   private int coeurs;

   @NotNull
   @Min(1024)
   private int frequence;


   private StringProperty coeursSP;
   private StringProperty frequenceSP;



   public int getCoeurs() {
      return coeurs;
   }

   public void setCoeurs(int coeurs) {
      this.coeurs = coeurs;
      this.setCoeursSP(String.valueOf(coeurs));
   }

   public String getCoeursSP() {
      return coeursSP.get();
   }

   public StringProperty coeursSPProperty() {
      return coeursSP;
   }

   public void setCoeursSP(String coeursSP) {
      this.coeursSP.set(String.valueOf(coeurs));
   }

   public int getFrequence() {
      return frequence;
   }

   public void setFrequence(int frequence) {
      this.frequence = frequence;
      this.setFrequenceSP(String.valueOf(frequence));
   }

   public String getFrequenceSP() {
      return frequenceSP.get();
   }

   public StringProperty frequenceSPProperty() {
      return frequenceSP;
   }

   public void setFrequenceSP(String frequenceSP) {
      this.frequenceSP.set(String.valueOf(frequence));
   }

   public Processeur() {
      super();
   }

   public Processeur(int id, String reference, String constructeur, String libelle, String details, int idMachine,String type, int coeurs, int frequence) {
      super(id, reference, constructeur, libelle, details, idMachine,type);
      this.coeurs = coeurs;
      this.frequence = frequence;
      remplirSP();
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
      this.coeursSP = new SimpleStringProperty(String.valueOf(this.getCoeurs()));
      this.frequenceSP = new SimpleStringProperty(String.valueOf(this.getFrequence()));
   }
}