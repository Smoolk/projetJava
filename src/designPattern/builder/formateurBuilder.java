/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.builder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author jeanl
 */
public class formateurBuilder {

    public static void main(String[] args) {
        try {
            formateur f1 = new formateur.formateurBuilder().setIdform(1).setMatricule("Matr").setNom("Paul").setPrenom("Jacques").setNumero("2").setRue("Neuve").setLocalite("Bruxelles").setCp(1000).setTel("0123456789").
                    build();
            formateur f2 = new formateur.formateurBuilder().setIdform(1).setMatricule("Matr").setNom("Paul").setPrenom("Jacques").setNumero("2").setRue("Neuve").setLocalite("Bruxelles").setCp(1000).setTel("0123456789").
                    build();
            formateur f3 = new formateur.formateurBuilder().setIdform(1).setMatricule("Matr").setNom("Paul").setPrenom("Jacques").setNumero("2").setRue("Neuve").setLocalite("Bruxelles").setCp(1000).setTel("0123456789").
                    build();
            System.out.println(f1);
            System.out.println(f2);
            System.out.println(f3);

        } catch (Exception e) {
            System.out.println("erreur " + e);
        }
        try {
            formateur f1 = new formateur.formateurBuilder().setIdform(1).setNom("Paul").setPrenom("Jacques").setNumero("2").setRue("Neuve").setLocalite("Bruxelles").setCp(1000).setTel("0123456789").
                    build();
            System.out.println(f1);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        }

    }

}
