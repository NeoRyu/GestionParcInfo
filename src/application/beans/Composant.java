package application.beans; /***********************************************************************
 * Module:  application.beans.Composant.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Composant
 ***********************************************************************/

import application.interfaces.IComposant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Composant implements IComposant{

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

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
   }

   public String getConstructeur() {
      return constructeur;
   }

   public void setConstructeur(String constructeur) {
      this.constructeur = constructeur;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
   }

   public int getIdMachine() {
      return idMachine;
   }

   public void setIdMachine(int idMachine) {
      this.idMachine = idMachine;
   }

   public Composant() {
   }

   public Composant(int id, String reference, String constructeur, String libelle, String details, int idMachine) {
      this.id = id;
      this.reference = reference;
      this.constructeur = constructeur;
      this.libelle = libelle;
      this.details = details;
      this.idMachine = idMachine;
   }
}