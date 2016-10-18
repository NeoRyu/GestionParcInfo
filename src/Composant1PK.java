/***********************************************************************
 * Module:  Composant1PK.java
 * Author:  user
 * Purpose: Defines the Class Composant1PK
 ***********************************************************************/

import java.util.*;

/** @pdOid 40eb9ecb-ce8f-4ff1-b7fe-04d83bfe7cff */
public class Composant1PK implements java.io.Serializable {
   /** @pdOid 229418a9-74e8-42ab-970f-ae160a3c74e8 */
   public void composant1PK() {
      // TODO: implement
   }
   
   /** @param other
    * @pdOid 08108f49-c9c2-4f9f-bfaa-855f4c1c65d2 */
   public boolean equals(Object other) {
      if (!(other instanceof Composant1PK)) 
         return false;
   
   
      boolean bEqual = true;
   
      return bEqual;
   }
   
   /** @pdOid 58d87fe9-6f34-4ce2-a47e-2d957cc95f01 */
   public int hashCode() {
      String str = this.getClass().getName();
   
      return str.hashCode();
   }
   
   /** @pdOid 9951ea82-e3af-4a3d-b2c1-754a560b9ead */
   public Composant1PK() {
      // TODO: implement
   }

}