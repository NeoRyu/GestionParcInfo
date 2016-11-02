package application.DAO.objets; /***********************************************************************
 * Module:  application.objets.Ram.java
 * Author:  admin
 * Purpose: Defines the Class application.objets.Ram
 ***********************************************************************/

/** @pdOid d1b87622-3842-492a-8422-31b2a7f8be38 */
public class Ram extends Composant {
   /** @pdOid f1470625-2b39-40fb-a985-f4e4543dc105 */
   private int capaciteGo;

   public int getCapaciteGo() {
      return capaciteGo;
   }

   public void setCapaciteGo(int capaciteGo) {
      this.capaciteGo = capaciteGo;
   }

   public Ram(int capaciteGo) {

      this.capaciteGo = capaciteGo;
   }
}