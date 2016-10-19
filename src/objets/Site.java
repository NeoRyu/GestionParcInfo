package objets; /***********************************************************************
 * Module:  objets.Site.java
 * Author:  user
 * Purpose: Defines the Class objets.Site
 ***********************************************************************/

/** @pdOid 0988e168-5376-49cd-addf-1530c2ec656e */
public class Site {
   /** @pdOid c8d89341-08f8-450d-a988-2a8c4e575f6c */
   private int id;
   /** @pdOid bf155789-5a6f-4556-b3a3-54f44379be45 */
   private String libelle;
   
   /** @pdRoleInfo migr=no name=objets.Batiment assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Batiment> batiment;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Batiment> getBatiment() {
      if (batiment == null)
         batiment = new java.util.HashSet<Batiment>();
      return batiment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorBatiment() {
      if (batiment == null)
         batiment = new java.util.HashSet<Batiment>();
      return batiment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newBatiment */
   public void setBatiment(java.util.Collection<Batiment> newBatiment) {
      removeAllBatiment();
      for (java.util.Iterator iter = newBatiment.iterator(); iter.hasNext();)
         addBatiment((Batiment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBatiment */
   public void addBatiment(Batiment newBatiment) {
      if (newBatiment == null)
         return;
      if (this.batiment == null)
         this.batiment = new java.util.HashSet<Batiment>();
      if (!this.batiment.contains(newBatiment))
         this.batiment.add(newBatiment);
   }
   
   /** @pdGenerated default remove
     * @param oldBatiment */
   public void removeBatiment(Batiment oldBatiment) {
      if (oldBatiment == null)
         return;
      if (this.batiment != null)
         if (this.batiment.contains(oldBatiment))
            this.batiment.remove(oldBatiment);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllBatiment() {
      if (batiment != null)
         batiment.clear();
   }

}