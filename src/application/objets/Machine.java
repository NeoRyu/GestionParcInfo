package application.objets; /***********************************************************************
 * Module:  application.objets.Machine.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.objets.Machine
 ***********************************************************************/

import java.util.Collection;
import java.util.Date;

/** @pdOid 29bd1de5-32fa-4bc5-ac7b-a0c0ed192d80 */
public class Machine {
   /** @pdOid 40555939-bba9-4d75-86cd-8625d6989102 */
   private int id;
   /** @pdOid e9a0a83d-ce7a-4cb7-9837-15df7bb2623b */
   private String idAfpa;
   /** @pdOid 607c1715-5c6c-47fa-886c-54b17c15e2db */
   private String idUnique;
   /** @pdOid 772da07e-d119-4af1-9b90-e46745521d0d */
   private java.util.Date dateAchat;
   /** @pdOid c5643e4c-f69a-4635-b4ae-6b6f9f45273f */
   private int dureeGarantie;
   /** @pdOid 1b8c0308-3320-4538-ae91-5b266e4b9908 */
   private String adresseIP;
   /** @pdOid 10b0d178-156a-4d1d-a648-d9afeb4c708f */
   private String type;
   
   /** @pdRoleInfo migr=no name=application.objets.Composant assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Composant> composant;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getIdAfpa() {
      return idAfpa;
   }

   public void setIdAfpa(String idAfpa) {
      this.idAfpa = idAfpa;
   }

   public String getIdUnique() {
      return idUnique;
   }

   public void setIdUnique(String idUnique) {
      this.idUnique = idUnique;
   }

   public Date getDateAchat() {
      return dateAchat;
   }

   public void setDateAchat(Date dateAchat) {
      this.dateAchat = dateAchat;
   }

   public int getDureeGarantie() {
      return dureeGarantie;
   }

   public void setDureeGarantie(int dureeGarantie) {
      this.dureeGarantie = dureeGarantie;
   }

   public String getAdresseIP() {
      return adresseIP;
   }

   public void setAdresseIP(String adresseIP) {
      this.adresseIP = adresseIP;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public Machine(int id, String idAfpa, String idUnique, Date dateAchat, int dureeGarantie, String adresseIP, String type, Collection<Composant> composant) {

      this.id = id;
      this.idAfpa = idAfpa;
      this.idUnique = idUnique;
      this.dateAchat = dateAchat;
      this.dureeGarantie = dureeGarantie;
      this.adresseIP = adresseIP;
      this.type = type;
      this.composant = composant;
   }

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
   
   /** @pdOid c048567c-b284-4a21-af5d-7e4f990bf0fe */
   public boolean estSousGarantie() {
      // TODO: implement
      return false;
   }
   
   /** @pdOid ed539b07-b49c-4883-8b95-773e5a3a6699 */
   public boolean ipDispo() {
      // TODO: implement
      return false;
   }

}