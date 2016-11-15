package application.beans; /***********************************************************************
 * Module:  application.beans.Logiciel.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Logiciel
 ***********************************************************************/


import application.interfaces.IComposant;

import javax.validation.constraints.NotNull;

/**
 * @pdOid 1d702f3f-4f03-44d8-9fc1-4809d7fafb5c
 */
public class Logiciel extends Composant implements IComposant {

    @NotNull
    private int architecture;

    public int getArchitecture() {
        return architecture;
    }

    public void setArchitecture(int architecture) {
        this.architecture = architecture;
    }

    public Logiciel() {
        super();
    }

    public Logiciel(int id, String reference, String constructeur, String libelle, String details,int idMachine, int architecture) {
        super(id, reference, constructeur, libelle, details, idMachine);
        this.architecture = architecture;
    }
}