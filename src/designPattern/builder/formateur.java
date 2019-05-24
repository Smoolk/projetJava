/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.builder;

/**
 *
 * @author jeanl
 */
public class formateur {

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

    private formateur(formateurBuilder f) {
        this.idform = f.idform;
        this.matricule = f.matricule;
        this.nom = f.nom;
        this.prenom = f.prenom;
        this.numero = f.numero;
        this.rue = f.rue;
        this.localite = f.localite;
        this.cp = f.cp;
        this.tel = f.tel;
    }

    public int getIdform() {
        return idform;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getLocalite() {
        return localite;
    }

    public int getCp() {
        return cp;
    }

    public String getTel() {
        return tel;
    }

    public static class formateurBuilder {

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

        public formateurBuilder setIdform(int idform) {
            this.idform = idform;
            return this;
        }

        public formateurBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public formateurBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public formateurBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public formateurBuilder setNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public formateurBuilder setRue(String rue) {
            this.rue = rue;
            return this;
        }

        public formateurBuilder setLocalite(String localite) {
            this.localite = localite;
            return this;
        }

        public formateurBuilder setCp(int cp) {
            this.cp = cp;
            return this;
        }

        public formateurBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public formateur build() throws Exception {
            if (matricule == null || nom == null || prenom == null || numero == null || rue == null || localite == null || cp == 0 || tel == null) {
                throw new Exception("Informations de construction incomplètes");
            }
            return new formateur(this);
        }

        

    }
    
    @Override
        public String toString() {
            return "\n     Id formateur : " + idform + "\n     Matricule : " + matricule + "\n     Nom : " + nom + "\n     Prénom : " + prenom + "\n     Numéro de maison : " + numero + "\n     Rue : " + rue + "\n     Localité : " + localite + "\n     Code postal : " + cp + "\n     Téléphone : " + tel;
        }
}
