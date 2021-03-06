/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.observer;

import classes.metiers.*;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jeanl
 */
public class Session extends subject {

    /**
     *
     */
    protected int idsesscours;

    /**
     *
     */
    protected LocalDate datedebut;

    /**
     *
     */
    protected LocalDate datefin;

    /**
     *
     */
    protected int nbreinscrits;

    /**
     *
     */
    private int idcours;

    /**
     *
     */
    private int idlocal;
    private String nom;
    private String prenom;
    private String matiere;
    private String sigle;
    private int heures;

    /**
     *
     * @param idsesscours
     * @param datedebut
     * @param datefin
     * @param nbreinscrits
     */
    public Session(int idsesscours, LocalDate datedebut, LocalDate datefin, int nbreinscrits) {
        this.idsesscours = idsesscours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
    }

    /**
     *
     * @param idsesscours
     * @param nom
     * @param prenom
     * @param datedebut
     * @param datefin
     * @param matiere
     * @param sigle
     * @param nbreinscrits
     * @param heures
     */
    public Session(int idsesscours, String nom, String prenom, LocalDate datedebut, LocalDate datefin, String matiere, String sigle, int nbreinscrits, int heures) {
        this.idsesscours = idsesscours;
        this.nom = nom;
        this.prenom = prenom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
        this.matiere = matiere;
        this.sigle = sigle;
        this.nbreinscrits = nbreinscrits;
        this.heures = heures;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
        notifyObservers();
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
        notifyObservers();
    }

    /**
     *
     * @param matiere
     */
    public void setMatiere(String matiere) {
        this.matiere = matiere;
        notifyObservers();
    }

    /**
     *
     * @param sigle
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
        notifyObservers();
    }

    /**
     *
     * @param heures
     */
    public void setHeures(int heures) {
        this.heures = heures;
        notifyObservers();
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return
     */
    public String getMatiere() {
        return matiere;
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
    public int getHeures() {
        return heures;
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
     * @param idlocal
     */
    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
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
    public int getIdlocal() {
        return idlocal;
    }

    /**
     *
     * @param idsesscours
     * @param datedebut
     * @param datefin
     * @param nbreinscrits
     * @param idcours
     * @param idlocal
     */
    public Session(int idsesscours, LocalDate datedebut, LocalDate datefin, int nbreinscrits, int idcours, int idlocal) {
        this.idsesscours = idsesscours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
        this.idcours = idcours;
        this.idlocal = idlocal;
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
    public LocalDate getDatedebut() {
        return datedebut;
    }

    /**
     *
     * @return
     */
    public LocalDate getDatefin() {
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
     * @param datedebut
     */
    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public List<observer> getMyObservers() {
        return myObservers;
    }

    /**
     *
     * @param datefin
     */
    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    /**
     *
     * @param nbreinscrits
     */
    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
        notifyObservers();
    }

    @Override
    public String getNotification() {
        return "nouveau sigle :" + sigle;
    }
}
