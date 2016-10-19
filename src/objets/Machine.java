package objets; /***********************************************************************
 * Module:  objets.Machine.java
 * Author:  user
 * Purpose: Defines the Class objets.Machine
 ***********************************************************************/

/** @pdOid 8c3f0b24-7e72-4510-8a9d-e480d54a25dd */
public class Machine {
   /** @pdOid 62d0ebe0-85b5-4e7f-97ac-b97f361b03e2 */
   private int id;
   /** @pdOid 72a8f44d-c7f6-4d15-9b1f-9cd59f1773cc */
   private String idAfpa;
   /** @pdOid 266ba813-8ab4-4d7a-aa58-85747f2c02a8 */
   private String idUnique;
   /** @pdOid 425965ed-3724-46f5-bb57-2f569c51bf57 */
   private java.util.Date dateAchat;
   /** @pdOid c13659fa-1826-4290-91fe-41ec94389b74 */
   private int dureeGarantie;
   /** @pdOid 81819717-4061-438c-92f7-f161d64b135a */
   private String adresseIP;
   /** @pdOid 5c6ce2e3-4c5a-4fad-ad67-063df176a606 */
   private String type;
   /** @pdOid f68bb64b-20ee-40a1-bd00-8a0ce4a96a75 */
   private String systemeExploitation;
   
   /** @pdRoleInfo migr=no name=objets.Composant assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Composant> composant;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Composant> getComposant() {
      if (composant == null)
         composant = new java.util.HashSet<Composant>();
      return composant;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorComposant() {
      if (composant == null)
         composant = new java.util.HashSet<Composant>();
      return composant.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newComposant */
   public void setComposant(java.util.Collection<Composant> newComposant) {
      removeAllComposant();
      for (java.util.Iterator iter = newComposant.iterator(); iter.hasNext();)
         addComposant((Composant)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newComposant */
   public void addComposant(Composant newComposant) {
      if (newComposant == null)
         return;
      if (this.composant == null)
         this.composant = new java.util.HashSet<Composant>();
      if (!this.composant.contains(newComposant))
         this.composant.add(newComposant);
   }
   
   /** @pdGenerated default remove
     * @param oldComposant */
   public void removeComposant(Composant oldComposant) {
      if (oldComposant == null)
         return;
      if (this.composant != null)
         if (this.composant.contains(oldComposant))
            this.composant.remove(oldComposant);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllComposant() {
      if (composant != null)
         composant.clear();
   }
   
   /** @pdRoleInfo migr=no name=objets.Logiciel assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Logiciel> logiciel;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Logiciel> getLogiciel() {
      if (logiciel == null)
         logiciel = new java.util.HashSet<Logiciel>();
      return logiciel;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLogiciel() {
      if (logiciel == null)
         logiciel = new java.util.HashSet<Logiciel>();
      return logiciel.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLogiciel */
   public void setLogiciel(java.util.Collection<Logiciel> newLogiciel) {
      removeAllLogiciel();
      for (java.util.Iterator iter = newLogiciel.iterator(); iter.hasNext();)
         addLogiciel((Logiciel)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLogiciel */
   public void addLogiciel(Logiciel newLogiciel) {
      if (newLogiciel == null)
         return;
      if (this.logiciel == null)
         this.logiciel = new java.util.HashSet<Logiciel>();
      if (!this.logiciel.contains(newLogiciel))
         this.logiciel.add(newLogiciel);
   }
   
   /** @pdGenerated default remove
     * @param oldLogiciel */
   public void removeLogiciel(Logiciel oldLogiciel) {
      if (oldLogiciel == null)
         return;
      if (this.logiciel != null)
         if (this.logiciel.contains(oldLogiciel))
            this.logiciel.remove(oldLogiciel);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLogiciel() {
      if (logiciel != null)
         logiciel.clear();
   }

}