/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.observer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author jeanl
 */
public class formateurObserver {
    
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(2012, 6, 30);
        
      
        
        Session s1 = new Session(1,a,a,1);
        Session s2 = new Session(2,a,a,1);
        
        formateur f1 = new formateur(1,"Papi","Paul","Pierre","1","neuve","Bruxelles",1000,"0123456789");
        formateur f2 = new formateur(2,"Papi","Paul","Pierre","1","neuve","Bruxelles",1000,"0123456789");
        
        s1.addObserver(f1);
        s1.addObserver(f2);
        s2.addObserver(f2);
        
        s1.setSigle("11");
        s2.setSigle("22");
        
        
        
    }
}
