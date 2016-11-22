package application.beans; /***********************************************************************
 * Module:  application.beans.Logiciel.java
 * Author:  RENAUD + BORIS
 * Purpose: Defines the Class application.beans.Logiciel
 ***********************************************************************/


import application.interfaces.IComposant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.NotNull;

/**
 * @pdOid 1d702f3f-4f03-44d8-9fc1-4809d7fafb5c
 */
public class Logiciel extends Composant implements IComposant {

    @NotNull
    private int architecture;

    private StringProperty architectureSP;



    public int getArchitecture() {
        return architecture;
    }

    public void setArchitecture(int architecture) {
        this.architecture = architecture;
        this.setArchitectureSP(String.valueOf(architecture));
    }

    public String getArchitectureSP() {
        return architectureSP.get();
    }

    public StringProperty architectureSPProperty() {
        return architectureSP;
    }

    public void setArchitectureSP(String architectureSP) {
        this.architectureSP.set(String.valueOf(architecture));
    }

    public Logiciel() {
        super();
    }

    public Logiciel(int id, String reference, String constructeur, String libelle, String details,int idMachine,String type, int architecture) {
        super(id, reference, constructeur, libelle, details, idMachine,type);
        this.architecture = architecture;
        remplirSP();
    }

    public void remplirSP() {
        // CONVERSION EN TYPE D'OBJETS OBSERVABLES
        this.idSP = new SimpleStringProperty(String.valueOf(this.getId()));
        this.referenceSP = new SimpleStringProperty(this.getReference());
        this.constructeurSP = new SimpleStringProperty(this.getConstructeur());
        this.libelleSP = new SimpleStringProperty(this.getLibelle());
        this.detailsSP = new SimpleStringProperty((this.getDetails()));
        this.idMachineSP = new SimpleStringProperty(String.valueOf(this.getIdMachine()));
        this.typeSP = new SimpleStringProperty(this.getType());
        this.architectureSP = new SimpleStringProperty(String.valueOf(this.getArchitecture()));
    }
}