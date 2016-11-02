package application.DAO.objets; /***********************************************************************
 * Module:  application.objets.Role.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Role
 ***********************************************************************/

import java.util.Collection;

/** @pdOid 9deeaa81-12e9-4c1e-9088-4cc779421093 */
public class Role {
   /** @pdOid 39976556-5d14-4041-a2ef-ff726af7aa40 */
   private int id;
   /** @pdOid 97bd4c44-aebc-4147-a4de-79909b9d4212 */
   private String libelle;
   
   /** @pdRoleInfo migr=no name=application.objets.Individu assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<Individu> individu;


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

   public Role(int id, String libelle, Collection<Individu> individu) {

      this.id = id;
      this.libelle = libelle;
      this.individu = individu;
   }

   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Individu> getIndividu() {
      if (individu == null)
         individu = new java.util.HashSet<Individu>();

      return individu;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
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
      {
         this.individu.add(newIndividu);
         newIndividu.addRole(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldIndividu */
   public void removeIndividu(Individu oldIndividu) {
      if (oldIndividu == null)
         return;
      if (this.individu != null)
         if (this.individu.contains(oldIndividu))
         {
            this.individu.remove(oldIndividu);
            oldIndividu.removeRole(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIndividu() {
      if (individu != null)
      {
         Individu oldIndividu;
         for (java.util.Iterator iter = getIteratorIndividu(); iter.hasNext();)
         {
            oldIndividu = (Individu)iter.next();
            iter.remove();
            oldIndividu.removeRole(this);
         }
      }
   }

}