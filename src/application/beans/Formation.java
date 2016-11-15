package application.beans; /***********************************************************************
 * Module:  application.beans.Formation.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Formation
 ***********************************************************************/


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;


/** @pdOid a11ac2b3-8aa8-4334-b2fb-57a3e07da044 */
public class Formation {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   private int id;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un libellé valide")
   private String libelle;
   
   /** @pdRoleInfo migr=no name=application.beans.Utilisateur assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Utilisateur> utilisateur;
   /** @pdRoleInfo migr=no name=application.beans.Machine assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Machine> machine;
   
   
   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Utilisateur> getUtilisateur() {
      if (utilisateur == null)
         utilisateur = new java.util.HashSet<Utilisateur>();
      return utilisateur;
   }

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

   public Formation() {
   }

   public Formation(int id, String libelle, Collection<Utilisateur> utilisateur, Collection<Machine> machine) {
      this.id = id;
      this.libelle = libelle;
      this.utilisateur = utilisateur;

      this.machine = machine;
   }

   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUtilisateur() {

      if (utilisateur == null)
         utilisateur = new java.util.HashSet<Utilisateur>();
      return utilisateur.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUtilisateur */
   public void setUtilisateur(java.util.Collection<Utilisateur> newUtilisateur) {
      removeAllUtilisateur();
      for (java.util.Iterator iter = newUtilisateur.iterator(); iter.hasNext();)
         addUtilisateur((Utilisateur)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUtilisateur */
   public void addUtilisateur(Utilisateur newUtilisateur) {
      if (newUtilisateur == null)
         return;
      if (this.utilisateur == null)
         this.utilisateur = new java.util.HashSet<Utilisateur>();
      if (!this.utilisateur.contains(newUtilisateur))
         this.utilisateur.add(newUtilisateur);
   }
   
   /** @pdGenerated default remove
     * @param oldUtilisateur */
   public void removeUtilisateur(Utilisateur oldUtilisateur) {
      if (oldUtilisateur == null)
         return;
      if (this.utilisateur != null)
         if (this.utilisateur.contains(oldUtilisateur))
            this.utilisateur.remove(oldUtilisateur);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUtilisateur() {
      if (utilisateur != null)
         utilisateur.clear();
   }
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