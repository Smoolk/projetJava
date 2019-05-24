/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.observer;

import classes.metiers.*;

/**
 *
 * @author jeanl
 */
public class Local extends subject {

    /**
     *
     */
    protected int idlocal;

    /**
     *
     */
    protected String sigle;

    /**
     *
     */
    protected int places;

    /**
     *
     */
    protected String description;

    /**
     *
     * @param idlocal
     * @param sigle
     * @param places
     * @param description
     */
    public Local(int idlocal, String sigle, int places, String description) {
        this.idlocal = idlocal;
        this.sigle = sigle;
        this.places = places;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getIdlocal() {
        return idlocal;
    }

    /**
     *
     * @return
     */
    public String getSigle() {
        return sigle;
    }

    /**
     *
     * @return
     */
    public int getPlaces() {
        return places;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param idlocal
     */
    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    /**
     *
     * @param sigle
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     *
     * @param places
     */
    public void setPlaces(int places) {
        this.places = places;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "\n     Id local : "+idlocal+"\n     sigle : "+sigle+"\n     nombre de places : "+places+"\n     description : "+description;
    }

    @Override
    public String getNotification() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
