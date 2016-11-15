package application.beans; /***********************************************************************
 * Module:  application.beans.Role.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Role
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/** @pdOid 9deeaa81-12e9-4c1e-9088-4cc779421093 */
public class Role {

   @NotNull
   @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
   private int id;

   @NotNull
   @Pattern(regexp = "^[^0-9]+", message = "Veuillez entrer un rôle valide")
   private String libelle;
   
   /** @pdRoleInfo migr=no name=application.beans.Individu assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Utilisateur> utilisateur;


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

   public Role() {
   }

   public Role(int id, String libelle, Collection<Utilisateur> individu) {

      this.id = id;
      this.libelle = libelle;
      this.utilisateur = individu;
   }

   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Utilisateur> getIndividu() {
      if (utilisateur == null)
         utilisateur = new java.util.HashSet<Utilisateur>();

      return utilisateur;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIndividu() {
      if (utilisateur == null)
         utilisateur = new java.util.HashSet<Utilisateur>();
      return utilisateur.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIndividu */
   public void setIndividu(java.util.Collection<Utilisateur> newIndividu) {
      removeAllIndividu();
      for (java.util.Iterator iter = newIndividu.iterator(); iter.hasNext();)
         addIndividu((Utilisateur)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIndividu */
   public void addIndividu(Utilisateur newIndividu) {
      if (newIndividu == null)
         return;
      if (this.utilisateur == null)
         this.utilisateur = new java.util.HashSet<Utilisateur>();
      if (!this.utilisateur.contains(newIndividu))
      {
         this.utilisateur.add(newIndividu);
         newIndividu.addRole(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldIndividu */
   public void removeIndividu(Utilisateur oldIndividu) {
      if (oldIndividu == null)
         return;
      if (this.utilisateur != null)
         if (this.utilisateur.contains(oldIndividu))
         {
            this.utilisateur.remove(oldIndividu);
            oldIndividu.removeRole(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIndividu() {
      if (utilisateur != null)
      {
         Utilisateur oldIndividu;
         for (java.util.Iterator iter = getIteratorIndividu(); iter.hasNext();)
         {
            oldIndividu = (Utilisateur)iter.next();
            iter.remove();
            oldIndividu.removeRole(this);
         }
      }
   }

}