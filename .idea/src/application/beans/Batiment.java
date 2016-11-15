package application.beans; /***********************************************************************
 * Module:  application.beans.Batiment.java
 * Author:  RENAUD
 * Purpose: Defines the Class application.beans.Batiment
 ***********************************************************************/

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/**
 * @pdOid 083aa14e-4ca0-4718-b4c2-fd6b665c604a
 */
public class Batiment {

    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
    private int id;

    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Veuillez entrer un identifiant valide (chiffres uniquement)")
    private int site;

    @NotNull
    public java.util.Collection<Salle> salle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }


    /**
     * @return *  @pdGenerated default getter
     */
    public java.util.Collection<Salle> getSalle() {
        if (salle == null)
            salle = new java.util.HashSet<Salle>();
        return salle;
    }

    /**
     * @return *  @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorSalle() {
        if (salle == null)
            salle = new java.util.HashSet<Salle>();
        return salle.iterator();
    }

    public Batiment() {
    }

    public Batiment(int id, int site, Collection<Salle> salle) {
        this.id = id;
        this.site = site;
        this.salle = salle;
    }

    /**
     * @param newSalle
     * @pdGenerated default setter
     */
    public void setSalle(java.util.Collection<Salle> newSalle) {
        removeAllSalle();
        for (java.util.Iterator iter = newSalle.iterator(); iter.hasNext(); )
            addSalle((Salle) iter.next());
    }

    /**
     * @param newSalle
     * @pdGenerated default add
     */
    public void addSalle(Salle newSalle) {
        if (newSalle == null)
            return;
        if (this.salle == null)
            this.salle = new java.util.HashSet<Salle>();
        if (!this.salle.contains(newSalle))
            this.salle.add(newSalle);
    }

    /**
     * @param oldSalle
     * @pdGenerated default remove
     */
    public void removeSalle(Salle oldSalle) {
        if (oldSalle == null)
            return;
        if (this.salle != null)
            if (this.salle.contains(oldSalle))
                this.salle.remove(oldSalle);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllSalle() {
        if (salle != null)
            salle.clear();
    }

}