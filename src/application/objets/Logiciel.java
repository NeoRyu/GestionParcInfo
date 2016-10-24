package application.objets; /***********************************************************************
 * Module:  application.objets.Logiciel.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Logiciel
 ***********************************************************************/

/** @pdOid 1d702f3f-4f03-44d8-9fc1-4809d7fafb5c */
public class Logiciel extends Composant {
   /** @pdOid 9fec35af-ac55-4a9b-8175-50947eb7a6e8 */
   private int architecture;

   public int getArchitecture() {
      return architecture;
   }

   public void setArchitecture(int architecture) {
      this.architecture = architecture;
   }

   public Logiciel(int architecture) {

      this.architecture = architecture;
   }
}