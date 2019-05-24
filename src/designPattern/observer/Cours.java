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
public class Cours extends subject {

    /**
     *
     */
    protected int idcours;

    /**
     *
     */
    protected int heures;

    /**
     *
     */
    protected String matière;

    /**
     *
     * @param idcours
     * @param heures
     * @param matière
     */
    public Cours(int idcours, String matière, int heures) {
        this.idcours = idcours;
        this.heures = heures;
        this.matière = matière;
    }

    /**
     *
     * @return
     */
    public int getIdcours() {
        return idcours;
    }

    /**
     *
     * @return
     */
    public int getHeures() {
        return heures;
    }

    /**
     *
     * @return
     */
    public String getMatière() {
        return matière;
    }

    /**
     *
     * @param idcours
     */
    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    /**
     *
     * @param heures
     */
    public void setHeures(int heures) {
        this.heures = heures;
    }

    /**
     *
     * @param matière
     */
    public void setMatière(String matière) {
        this.matière = matière;
    }
    
    @Override
    public String toString(){
        return "\n     Id cours : "+idcours+"\n     matière : "+matière+"\n     nombre d'heures : "+heures;
    }

    @Override
    public String getNotification() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
