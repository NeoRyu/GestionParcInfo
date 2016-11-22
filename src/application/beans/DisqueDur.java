package application.beans; /***********************************************************************
 * Module:  application.beans.DisqueDur.java
 * Author:  RENAUD + BORIS
 * Purpose: Defines the Class application.beans.DisqueDur
 ***********************************************************************/

import application.interfaces.IComposant;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @pdOid 33f611c4-528e-4aeb-9bf5-98798acda2b6
 */
public class DisqueDur extends Composant implements IComposant {

    @NotNull
    @Pattern(regexp = "(SSD|HDD|FSH)", message = "Veuillez entrer une valeur valide.")
    private String format;

    @NotNull
    @Min(1)
    private int stockageGo;

    private StringProperty formatSP;
    private StringProperty stockageSP;

    public String getFormat() {
        return format;
    }

    public void setFormat(String type) {
        this.format = type;
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


    public int getStockageGo() {
        return stockageGo;
    }

    public void setStockageGo(int stockageGo) {
        this.stockageGo = stockageGo;
        this.setStockageSP(String.valueOf(stockageGo));
    }

    public String getStockageSP() {
        return stockageSP.get();
    }

    public StringProperty stockageSPProperty() {
        return stockageSP;
    }

    public void setStockageSP(String stockageSP) {
        this.stockageSP.set(String.valueOf(stockageGo));
    }


    public DisqueDur() {
super();
    }


    public DisqueDur(int id, String reference, String constructeur, String libelle, String details,int idMachine,String type, String format, int stockageGo) {
        super(id, reference, constructeur, libelle, details, idMachine,type);
        this.format = format;
        this.stockageGo = stockageGo;
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
        this.stockageSP = new SimpleStringProperty(String.valueOf(this.getStockageGo()));
    }
}