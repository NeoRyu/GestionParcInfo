package objets; /***********************************************************************
 * Module:  objets.Individu.java
 * Author:  user
 * Purpose: Defines the Class objets.Individu
 ***********************************************************************/

/** @pdOid 5dad19fa-ccd3-458d-bd96-9ea272e4b935 */
public class Individu {
   /** @pdOid 055bf3e2-7916-4ff0-abd6-f522ffb269a6 */
   private int id;
   /** @pdOid 5c280b5b-f03a-4756-bdc1-5c4666a9a2b6 */
   private String nom;
   /** @pdOid 8596dfb3-1ea9-4c34-8a48-0de79bd91222 */
   private String prenom;
   /** @pdOid 2b7f7911-07bb-495f-91dc-60e2e82bdb7d */
   private String adresse;
   /** @pdOid 4bbf86ae-b011-41df-acb2-ea684a05d33a */
   private String cp;
   /** @pdOid c6ef28e9-9857-49ef-976e-fd06a18e4cd3 */
   private String ville;
   /** @pdOid a875c3f0-713c-48d2-a238-482e11e41f7a */
   private String telephone;
   
   /** @pdRoleInfo migr=no name=objets.Role assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Role> role;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Role> getRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRole */
   public void setRole(java.util.Collection<Role> newRole) {
      removeAllRole();
      for (java.util.Iterator iter = newRole.iterator(); iter.hasNext();)
         addRole((Role)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRole */
   public void addRole(Role newRole) {
      if (newRole == null)
         return;
      if (this.role == null)
         this.role = new java.util.HashSet<Role>();
      if (!this.role.contains(newRole))
         this.role.add(newRole);
   }
   
   /** @pdGenerated default remove
     * @param oldRole */
   public void removeRole(Role oldRole) {
      if (oldRole == null)
         return;
      if (this.role != null)
         if (this.role.contains(oldRole))
            this.role.remove(oldRole);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRole() {
      if (role != null)
         role.clear();
   }
   
   /** @pdRoleInfo migr=no name=objets.Machine assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Machine> machine;
   
   
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