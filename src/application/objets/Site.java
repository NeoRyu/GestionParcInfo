package application.objets; /***********************************************************************
 * Module:  application.objets.Site.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Site
 ***********************************************************************/

import java.util.Collection;

/** @pdOid 97ae18c2-e8e8-4d7c-8da4-3322509a9136 */
public class Site {
   /** @pdOid ff7364da-5b1a-4604-90b8-6e8839be31e9 */
   private int id;
   /** @pdOid c224e4a6-80ac-455c-b557-7dfa608d3f37 */
   private String libelle;
   
   /** @pdRoleInfo migr=no name=application.objets.Batiment assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Batiment> batiment;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public Site(int id, String libelle, Collection<Batiment> batiment) {

      this.id = id;
      this.libelle = libelle;
      this.batiment = batiment;
   }

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