package application.objets; /***********************************************************************
 * Module:  application.objets.Individu.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Individu
 ***********************************************************************/

import java.util.Collection;

/** @pdOid 9585b040-1e2b-453c-a37b-b3cc3269b384 */
public class Individu {
   /** @pdOid 5b90c2a2-4f18-49b5-a4e0-cf806a95629c */
   private int id;
   /** @pdOid 320a6a5c-3f84-4ec7-b8b5-7c1c3b93a541 */
   private String nom;
   /** @pdOid abf34c96-fb8d-45b3-9bfb-4f9383150661 */
   private String prenom;
   /** @pdOid 323d93fe-a70c-4a9e-9a8a-e3749de595d8 */
   private String adresse;
   /** @pdOid db506b49-22de-4c43-b9d5-91fc82b83cd2 */
   private String cp;
   /** @pdOid 381f05ea-7e44-47fc-8188-f939571a04a5 */
   private String ville;
   /** @pdOid 13684b8c-0dba-4a83-965a-75f9b4b05a86 */
   private String telephone;
   
   /** @pdRoleInfo migr=no name=application.objets.Role assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Role> role;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getPrenom() {
      return prenom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   public String getAdresse() {
      return adresse;
   }

   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }

   public String getCp() {
      return cp;
   }

   public void setCp(String cp) {
      this.cp = cp;
   }

   public String getVille() {
      return ville;
   }

   public void setVille(String ville) {
      this.ville = ville;
   }

   public String getTelephone() {
      return telephone;
   }

   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }

   public Individu(int id, String nom, String prenom, String adresse, String cp, String ville, String telephone, Collection<Role> role, Collection<Machine> machine) {
      this.id = id;
      this.nom = nom;
      this.prenom = prenom;
      this.adresse = adresse;
      this.cp = cp;
      this.ville = ville;
      this.telephone = telephone;
      this.role = role;

      this.machine = machine;
   }

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
      {
         this.role.add(newRole);
         newRole.addIndividu(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldRole */
   public void removeRole(Role oldRole) {
      if (oldRole == null)
         return;
      if (this.role != null)
         if (this.role.contains(oldRole))
         {
            this.role.remove(oldRole);
            oldRole.removeIndividu(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRole() {
      if (role != null)
      {
         Role oldRole;
         for (java.util.Iterator iter = getIteratorRole(); iter.hasNext();)
         {
            oldRole = (Role)iter.next();
            iter.remove();
            oldRole.removeIndividu(this);
         }
      }
   }
   
   /** @pdRoleInfo migr=no name=application.objets.Machine assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
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