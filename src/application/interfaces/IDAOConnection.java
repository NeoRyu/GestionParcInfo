package application.interfaces; /***********************************************************************
 * Module:  application.interfaces.IDAOConnection.java
 * Author:  RENAUD
 * Purpose: Defines the Interface application.interfaces.IDAOConnection
 ***********************************************************************/

import java.util.*;

/** @pdOid 136f5f04-8780-41f4-b070-b03cc1b2d666 */
public interface IDAOConnection {
   /** @pdOid c84b92b1-5eaa-41f7-9542-8a341deb264d */
   final String ADRESSE = null;
   /** @pdOid 405a4f49-e89e-4a5a-b1c8-f8f1c6d58ff5 */
   final String USER = null;
   /** @pdOid 6424f6b2-b966-4741-8c0a-392b9e43aa52 */
   final String MDP = null;
   /** @pdOid 0a98bf29-2754-4e39-a8e3-5e2ab3be43ed */
   final String NOMBASE = null;
   
   /** @pdOid 84c2a628-4166-4aa8-8ed5-f9e580b4a0c9 */
   boolean connexion();
   /** @pdOid 5c40d471-57d3-40f6-aca2-5bd752f3483e */
   boolean fermer();

}