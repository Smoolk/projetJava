/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.metiers;

/**
 *
 * @author jeanl
 */
public class SessionCours {

    /**
     *
     */
    protected int idsesscours;

    /**
     *
     */
    protected String date;

    /**
     *
     */
    protected String datefin;

    /**
     *
     */
    protected int nbreinscrits;

    /**
     *
     * @param idsesscours
     * @param date
     * @param datefin
     * @param nbreinscrits
     */
    public SessionCours(int idsesscours, String date, String datefin, int nbreinscrits) {
        this.idsesscours = idsesscours;
        this.date = date;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
    }

    /**
     *
     * @return
     */
    public int getIdsesscours() {
        return idsesscours;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @return
     */
    public String getDatefin() {
        return datefin;
    }

    /**
     *
     * @return
     */
    public int getNbreinscrits() {
        return nbreinscrits;
    }

    /**
     *
     * @param idsesscours
     */
    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @param datefin
     */
    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    /**
     *
     * @param nbreinscrits
     */
    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }
    
    
}
