package objets; /***********************************************************************
 * Module:  objets.Formation.java
 * Author:  user
 * Purpose: Defines the Class objets.Formation
 ***********************************************************************/

/** @pdOid ad6d1ed0-43fa-42ca-8b6d-03050f0cd43c */
public class Formation {
   /** @pdOid 08e4ac03-8d44-45b6-952c-b1d31cf3410c */
   private int id;
   /** @pdOid 60e6fbd4-43da-42f5-95dd-5850c5f9e924 */
   private String libelle;
   
   /** @pdRoleInfo migr=no name=objets.Individu assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Individu> individu;
   /** @pdRoleInfo migr=no name=objets.Machine assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Machine> machine;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Individu> getIndividu() {
      if (individu == null)
         individu = new java.util.HashSet<Individu>();
      return individu;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIndividu() {
      if (individu == null)
         individu = new java.util.HashSet<Individu>();
      return individu.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIndividu */
   public void setIndividu(java.util.Collection<Individu> newIndividu) {
      removeAllIndividu();
      for (java.util.Iterator iter = newIndividu.iterator(); iter.hasNext();)
         addIndividu((Individu)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIndividu */
   public void addIndividu(Individu newIndividu) {
      if (newIndividu == null)
         return;
      if (this.individu == null)
         this.individu = new java.util.HashSet<Individu>();
      if (!this.individu.contains(newIndividu))
         this.individu.add(newIndividu);
   }
   
   /** @pdGenerated default remove
     * @param oldIndividu */
   public void removeIndividu(Individu oldIndividu) {
      if (oldIndividu == null)
         return;
      if (this.individu != null)
         if (this.individu.contains(oldIndividu))
            this.individu.remove(oldIndividu);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIndividu() {
      if (individu != null)
         individu.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Machine> getMachine() {
      if (machine == null)
         machine = new java.util.HashSet<Machine>();
      return machine;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMachine() {
      if (machine == null)
         machine = new java.util.HashSet<Machine>();
      return machine.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMachine */
   public void setMachine(java.util.Collection<Machine> newMachine) {
      removeAllMachine();
      for (java.util.Iterator iter = newMachine.iterator(); iter.hasNext();)
         addMachine((Machine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMachine */
   public void addMachine(Machine newMachine) {
      if (newMachine == null)
         return;
      if (this.machine == null)
         this.machine = new java.util.HashSet<Machine>();
      if (!this.machine.contains(newMachine))
         this.machine.add(newMachine);
   }
   
   /** @pdGenerated default remove
     * @param oldMachine */
   public void removeMachine(Machine oldMachine) {
      if (oldMachine == null)
         return;
      if (this.machine != null)
         if (this.machine.contains(oldMachine))
            this.machine.remove(oldMachine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMachine() {
      if (machine != null)
         machine.clear();
   }

}