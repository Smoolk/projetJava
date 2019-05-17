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
    protected String prenom;

    /**
     *
     */
    protected String numero;

    /**
     *
     */
    protected String rue;

    /**
     *
     */
    protected String localite;

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
     * @param prenom
     * @param numero
     * @param rue
     * @param localite
     * @param cp
     * @param tel
     */
    public Formateur(int idform, String matricule, String nom, String prenom, String numero, String rue, String localite, int cp, String tel) {
        this.idform = idform;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.rue = rue;
        this.localite = localite;
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
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
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
    public String getLocalite() {
        return localite;
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
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @param localite
     */
    public void setLocalite(String localite) {
        this.localite = localite;
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
    
    @Override
    public String toString(){
        return "\n     Id formateur : "+idform+"\n     Matricule : "+matricule+"\n     Nom : "+nom+"\n     Prénom : "+prenom+"\n     Numéro de maison : "+numero+"\n     Rue : "+rue+"\n     Localité : "+localite+"\n     Code postal : "+cp+"\n     Téléphone : "+tel;
    }
        
}
