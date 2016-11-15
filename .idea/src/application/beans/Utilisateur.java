package application.beans; /***********************************************************************
 * Module:  application.beans.Utilisateur.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Utilisateur
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/** @pdOid 9585b040-1e2b-453c-a37b-b3cc3269b384 */
public class Utilisateur {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   private int id;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un nom valide")
   private String nom;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un prénom valide")
   private String prenom;

   @NotNull
   private String adresse;

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   private String cp;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer une ville valide")
   private String ville;

   @NotNull
   @Pattern(regexp = "^(0)[1-5679]([0-9]{2}){4}$", message = "Veuillez entrer un numéro de téléphone valide")
   private String telephone;

   @NotNull
   /** @pdRoleInfo migr=no name=application.beans.Role assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
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

   public Utilisateur() {
   }

   public Utilisateur(int id, String nom, String prenom, String adresse, String cp, String ville, String telephone, Collection<Role> role, Collection<Machine> machine) {
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

   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Role> getRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
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
   
   /** @pdRoleInfo migr=no name=application.beans.Machine assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Machine> machine;
   
   
   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Machine> getMachine() {
      if (machine == null)
         machine = new java.util.HashSet<Machine>();
      return machine;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
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