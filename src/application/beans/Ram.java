package application.beans; /***********************************************************************
 * Module:  application.beans.Ram.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Ram
 ***********************************************************************/

import application.interfaces.IComposant;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @pdOid d1b87622-3842-492a-8422-31b2a7f8be38
 */
public class Ram extends Composant implements IComposant {

    @NotNull
    @Min(1)
    private int capaciteGo;

    public int getCapaciteGo() {
        return capaciteGo;
    }

    public void setCapaciteGo(int capaciteGo) {
        this.capaciteGo = capaciteGo;
    }

    public Ram() {
        super();
    }

    public Ram(int id, String reference, String constructeur, String libelle, String details,int idMachine, int capaciteGo) {
        super(id, reference, constructeur, libelle, details, idMachine);
        this.capaciteGo = capaciteGo;
    }
}