/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.observer;

/**
 *
 * @author jeanl
 */
public class Info extends subject {

    private formateur f;
    private Session s;

    public void setF(formateur f) {
        this.f = f;
    }

    public void setS(Session s) {
        this.s = s;
    }

    public formateur getF() {
        return f;
    }

    public Session getS() {
        return s;
    }

    public Info(formateur f, Session s) {
        this.f = f;
        this.s = s;
        s.addObserver(f);
    }
}
