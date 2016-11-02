package application.DAO.objets; /***********************************************************************
 * Module:  application.objets.Processeur.java
 * Author:  admin
 * Purpose: Defines the Class application.objets.Processeur
 ***********************************************************************/

/** @pdOid 5d6517c4-b800-475d-9f03-aa10f3fba23c */
public class Processeur extends Composant {
   /** @pdOid 2cb68de5-5db8-47fd-b718-6acc624ad2fa */
   private int coeurs;
   /** @pdOid 33d84ff6-d1f8-435c-a9a8-34644e839e9e */
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

   public Processeur(int coeurs, int frequence) {

      this.coeurs = coeurs;
      this.frequence = frequence;
   }
}