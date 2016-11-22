package application.beans; /***********************************************************************
 * Module:  application.beans.Ram.java
 * Author:  RENAUD + BORIS
 * Purpose: Defines the Class application.beans.Ram
 ***********************************************************************/

import application.interfaces.IComposant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @pdOid d1b87622-3842-492a-8422-31b2a7f8be38
 */
public class Ram extends Composant implements IComposant {

    @NotNull
    @Min(1)
    private int capaciteGo;

    private StringProperty capaciteSP;

    public int getCapaciteGo() {
        return capaciteGo;
    }

    public void setCapaciteGo(int capaciteGo) {
        this.capaciteGo = capaciteGo;
        this.setCapaciteSP(String.valueOf(capaciteGo));
    }

    public String getCapaciteSP() {
        return capaciteSP.get();
    }

    public StringProperty capaciteSPProperty() {
        return capaciteSP;
    }

    public void setCapaciteSP(String capaciteSP) {
        this.capaciteSP.set(String.valueOf(capaciteGo));
    }

    public Ram() {
        super();
    }

    public Ram(int id, String reference, String constructeur, String libelle, String details,int idMachine,String type, int capaciteGo) {
        super(id, reference, constructeur, libelle, details, idMachine,type);
        this.capaciteGo = capaciteGo;
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
        this.capaciteSP = new SimpleStringProperty(String.valueOf(this.getCapaciteGo()));
    }
}