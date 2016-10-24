package application.objets; /***********************************************************************
 * Module:  application.objets.Batiment.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Batiment
 ***********************************************************************/

/** @pdOid 083aa14e-4ca0-4718-b4c2-fd6b665c604a */
public class Batiment {
   /** @pdOid 0b8ebf22-7006-47b4-a3d8-afa3a1fe07da */
   private int id;
   /** @pdOid 4cd9614e-d702-444c-9e07-7dcf8af70d31 */
   private String adresse;
   /** @pdOid a254f799-4887-41f9-982d-8d65b743ff40 */
   private String cp;
   /** @pdOid 8bfb47c5-ef02-4b63-a50e-3ea84c9d02d9 */
   private String ville;
   
   /** @pdRoleInfo migr=no name=application.objets.Salle assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Salle> salle;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Salle> getSalle() {
      if (salle == null)
         salle = new java.util.HashSet<Salle>();
      return salle;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSalle() {
      if (salle == null)
         salle = new java.util.HashSet<Salle>();
      return salle.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSalle */
   public void setSalle(java.util.Collection<Salle> newSalle) {
      removeAllSalle();
      for (java.util.Iterator iter = newSalle.iterator(); iter.hasNext();)
         addSalle((Salle)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSalle */
   public void addSalle(Salle newSalle) {
      if (newSalle == null)
         return;
      if (this.salle == null)
         this.salle = new java.util.HashSet<Salle>();
      if (!this.salle.contains(newSalle))
         this.salle.add(newSalle);
   }
   
   /** @pdGenerated default remove
     * @param oldSalle */
   public void removeSalle(Salle oldSalle) {
      if (oldSalle == null)
         return;
      if (this.salle != null)
         if (this.salle.contains(oldSalle))
            this.salle.remove(oldSalle);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSalle() {
      if (salle != null)
         salle.clear();
   }

}