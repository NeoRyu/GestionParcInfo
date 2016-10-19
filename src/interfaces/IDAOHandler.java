package interfaces; /***********************************************************************
 * Module:  interfaces.IDAOHandler.java
 * Author:  user
 * Purpose: Defines the Interface interfaces.IDAOHandler
 ***********************************************************************/

import java.util.*;

/** @pdOid 3c1d3a7d-5bc0-4ba1-a07e-f22b397ee611 */
public interface IDAOHandler {
   /** @pdOid ad6aa5f2-998e-47b2-9bc6-cda8d7248c6f */
   boolean ajouter(Object object);
   /** @pdOid 87b1d763-321e-4637-96d9-0d0128b19eea */
   boolean supprimer(Object object);
   /** @pdOid 125e5050-18a7-44c1-913d-9e8c9c7eda9d */
   boolean modifier(Object object);
   /** @pdOid a9e7227d-f849-413a-8a34-f6147147df3b */
   Object lecture();

}