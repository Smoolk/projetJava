/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeanl
 */
public abstract class subject {
    
    protected List<observer> myObservers = new ArrayList<>();

    public void addObserver(observer o) {
        myObservers.add(o);
    }

    public void removeObserver(observer o) {
        myObservers.remove(o);
    }

    public void notifyObservers() {
        String msg = getNotification();
        for (observer o : myObservers) {
            o.update(msg);
        }
    }

    public abstract String getNotification();
}
