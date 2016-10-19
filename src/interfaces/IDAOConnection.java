package interfaces; /***********************************************************************
 * Module:  interfaces.IDAOConnection.java
 * Author:  user
 * Purpose: Defines the Interface interfaces.IDAOConnection
 ***********************************************************************/

import java.util.*;

/**
 * @pdOid d2535553-59f5-4fd3-af72-54396ef3db17
 */
public interface IDAOConnection {
    /**
     * @pdOid b42d2de3-a34f-4cd3-9a95-362034b75b53
     */
    final String adresse = null;
    /**
     * @pdOid db339d21-5592-42ee-99dc-83246ec7b8e7
     */
    final String user = null;
    /**
     * @pdOid 4ef73ffb-1b78-4eac-9309-d99f89c61e58
     */
    final String mdp = null;
    /**
     * @pdOid c2e391aa-f1ee-4fb3-88d3-5d7cc4567894
     */
    final String nomBase = null;

    /**
     * @pdOid de697fca-c491-456c-9a67-b69654578dd3
     */
    void connection();

    /**
     * @pdOid 41ac0fb3-920f-4f53-b401-899e33a8515c
     */
    void close();

}