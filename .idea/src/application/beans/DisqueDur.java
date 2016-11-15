package application.beans; /***********************************************************************
 * Module:  application.beans.DisqueDur.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.DisqueDur
 ***********************************************************************/

import application.interfaces.IComposant;

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

    public String getType() {
        return format;
    }

    public void setType(String type) {
        this.format = type;
    }

    public int getStockageGo() {
        return stockageGo;
    }

    public void setStockageGo(int stockageGo) {
        this.stockageGo = stockageGo;
    }

    public DisqueDur() {

    }


    public DisqueDur(int id, String reference, String constructeur, String libelle, String details,int idMachine, String format, int stockageGo) {
        super(id, reference, constructeur, libelle, details, idMachine);
        this.format = format;
        this.stockageGo = stockageGo;
    }
}