package application.beans; /***********************************************************************
 * Module:  application.beans.Processeur.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Processeur
 ***********************************************************************/

import application.interfaces.IComposant;

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

   public int getCoeurs() {
      return coeurs;
   }

   public void setCoeurs(int coeurs) {
      this.coeurs = coeurs;
   }

   public int getFrequence() {
      return frequence;
   }

   public void setFrequence(int frequence) {
      this.frequence = frequence;
   }

   public Processeur() {
      super();
   }

   public Processeur(int id, String reference, String constructeur, String libelle, String details, int idMachine, int coeurs, int frequence) {
      super(id, reference, constructeur, libelle, details, idMachine);
      this.coeurs = coeurs;
      this.frequence = frequence;
   }
}