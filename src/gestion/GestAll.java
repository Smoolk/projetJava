package gestion;

import java.sql.Connection;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Locale;
import java.util.Scanner;
//import classes.DAO.LocalDAO;
//import classes.DAO.DAO;
//import classes.metiers.Cours;
//import classes.metiers.Formateur;
//import classes.metiers.Local;
//import classes.metiers.SessionCours;
import myconnections.DBConnection;


public class GestAll {

    Scanner sc = new Scanner(System.in);
    GestLocal gl = new GestLocal();
    GestCours gc = new GestCours();
    GestFormateur gf = new GestFormateur();
    

    public GestAll() {

    }

    public void gestionAll() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");
        
        

        int ch = 0;
        do {
            System.out.println("\n##########################################################################\nMenu principal\n##########################################################################\n\n1.gérer les locaux \n2.gérer les formateurs\n3.gérer les cours\n4.fin\n");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    System.out.println("\n");
                    gl.gestion();
                    break;
                case 2:
                    System.out.println("\n");
                    gf.gestion();
                    break;
                case 3:
                    System.out.println("\n");
                    gc.gestion();
                    break;
                /*case 4:
                    System.out.println("\npas encore implémenté");
                    //sup();
                    break;*/
                case 4:
                    System.out.println("\n");
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("\nchoix incorrect");
            }

        } while (ch != 4);
        DBConnection.closeConnection();
    }

   

    public static void main(String[] args) {
        GestAll gest = new GestAll();
        gest.gestionAll();

    }

}
