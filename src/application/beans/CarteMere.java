package application.beans; /***********************************************************************
 * Module:  application.beans.CarteMere.java
 * Author:  RENAUD + BORIS
 * Purpose: Defines the Class application.beans.CarteMere
 ***********************************************************************/

import application.interfaces.IComposant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @pdOid c4da89b7-f727-476c-b028-3b0bd309f63b
 */
public class CarteMere extends Composant implements IComposant {


    /**
     * Variables + StringProperty
     */
    @NotNull
    @Pattern(regexp = "[A-Z]{3}", message = "Veuillez entrer un format de carte mère valide")
    private String format;

    private StringProperty formatSP;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        this.setFormatSP(format);
    }

    public String getFormatSP() {
        return formatSP.get();
    }

    public StringProperty formatSPProperty() {
        return formatSP;
    }

    public void setFormatSP(String formatSP) {
        this.formatSP.set(format);
    }


    public CarteMere() {
        super();
    }

    public CarteMere(int id, String reference, String constructeur, String libelle, String details, int idMachine, String type, String format) {
        super(id, reference, constructeur, libelle, details, idMachine, type);
        this.format = format;
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
        this.formatSP = new SimpleStringProperty(this.getFormat());
    }

}