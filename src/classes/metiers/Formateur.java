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
public class Formateur {

    /**
     *
     */
    protected int idform;

    /**
     *
     */
    protected String matricule;

    /**
     *
     */
    protected String nom;

    /**
     *
     */
    protected String prénom;

    /**
     *
     */
    protected String numéro;

    /**
     *
     */
    protected String rue;

    /**
     *
     */
    protected String localité;

    /**
     *
     */
    protected int cp;

    /**
     *
     */
    protected String tel;

    /**
     *
     * @param idform
     * @param matricule
     * @param nom
     * @param prénom
     * @param numéro
     * @param rue
     * @param localité
     * @param cp
     * @param tel
     */
    public Formateur(int idform, String matricule, String nom, String prénom, String numéro, String rue, String localité, int cp, String tel) {
        this.idform = idform;
        this.matricule = matricule;
        this.nom = nom;
        this.prénom = prénom;
        this.numéro = numéro;
        this.rue = rue;
        this.localité = localité;
        this.cp = cp;
        this.tel = tel;
    }

    /**
     *
     * @return
     */
    public int getIdform() {
        return idform;
    }

    /**
     *
     * @return
     */
    public String getMatricule() {
        return matricule;
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
    public String getPrénom() {
        return prénom;
    }

    /**
     *
     * @return
     */
    public String getNuméro() {
        return numéro;
    }

    /**
     *
     * @return
     */
    public String getRue() {
        return rue;
    }

    /**
     *
     * @return
     */
    public String getLocalité() {
        return localité;
    }

    /**
     *
     * @return
     */
    public int getCp() {
        return cp;
    }

    /**
     *
     * @return
     */
    public String getTel() {
        return tel;
    }

    /**
     *
     * @param idform
     */
    public void setIdform(int idform) {
        this.idform = idform;
    }

    /**
     *
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param prénom
     */
    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    /**
     *
     * @param numéro
     */
    public void setNuméro(String numéro) {
        this.numéro = numéro;
    }

    /**
     *
     * @param rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     *
     * @param localité
     */
    public void setLocalité(String localité) {
        this.localité = localité;
    }

    /**
     *
     * @param cp
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     *
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    
        
}
