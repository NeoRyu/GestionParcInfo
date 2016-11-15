package application.beans; /***********************************************************************
 * Module:  application.beans.CarteMere.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.CarteMere
 ***********************************************************************/

import application.interfaces.IComposant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/** @pdOid c4da89b7-f727-476c-b028-3b0bd309f63b */
public class CarteMere extends Composant implements IComposant {

   @NotNull
   @Pattern(regexp = "[A-Z]{3}", message = "Veuillez entrer un format de carte mère valide")
   private String format;

   public String getFormat() {
      return format;
   }

   public void setFormat(String format) {

      this.format = format;
   }

   public CarteMere() {
      super();
   }


   public CarteMere(int id, String reference, String constructeur, String libelle, String details, int idMachine, String format) {
      super(id, reference, constructeur, libelle, details, idMachine);
      this.format = format;
   }
}