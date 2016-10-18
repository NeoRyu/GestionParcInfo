package objets; /***********************************************************************
 * Module:  objets.Batiment.java
 * Author:  user
 * Purpose: Defines the Class objets.Batiment
 ***********************************************************************/

/** @pdOid c46bfeb7-fc57-49d2-9afc-45d56a229bf1 */
public class Batiment {
   /** @pdOid 3c081896-1ad3-4d05-aa37-dd87462b8dbd */
   private int id;
   /** @pdOid 94a9dd3f-03b4-4fd1-8bbf-441295ecc04b */
   private String adresse;
   /** @pdOid cebeba03-20cb-48a1-b945-ee0dcc4d19ef */
   private String cp;
   /** @pdOid 03dacc98-42f0-4ee5-9f88-8e2d40a0a65a */
   private String ville;
   
   /** @pdRoleInfo migr=no name=objets.Salle assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
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