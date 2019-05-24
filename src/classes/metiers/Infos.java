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
public class Infos {
    
    private int nh;
    private int idform;
    private int idsesscours;
    private int idinfos;
    
    /**
     *
     * @param nh
     * @param idform
     * @param idsesscours
     * @param idinfos
     */
    public Infos(int nh, int idform, int idsesscours, int idinfos){
        this.nh = nh;
        this.idform = idform;
        this.idsesscours = idsesscours;
        this.idinfos = idinfos;
    }

    public Infos(int idform){
        this.idform = idform;
    }
    
    /**
     *
     * @param nh
     */
    public void setNh(int nh) {
        this.nh = nh;
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
     * @param idsesscours
     */
    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    /**
     *
     * @param idinfos
     */
    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    /**
     *
     * @return
     */
    public int getNh() {
        return nh;
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
    public int getIdsesscours() {
        return idsesscours;
    }

    /**
     *
     * @return
     */
    public int getIdinfos() {
        return idinfos;
    }
}
