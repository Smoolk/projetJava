package gestion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import classes.DAO.LocalDAO;
import classes.DAO.DAO;
import classes.metiers.Cours;
import classes.metiers.Formateur;
import classes.metiers.Local;
import classes.metiers.SessionCours;
import myconnections.DBConnection;

public class GestLocal {

    Scanner sc = new Scanner(System.in);
    Local locActuel = null;
    DAO<Local> localDAO = null;

    public GestLocal() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        localDAO = new LocalDAO();
        localDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("\n##########################################################################\nMenu local\n##########################################################################\n\n1.nouveau \n2.recherche\n3.modification\n4.suppression\n5.recherche sur nom\n6.retour au menu principal\n");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    System.out.println("\n");
                    nouveau();
                    break;
                case 2:
                    System.out.println("\n");
                    recherche();
                    break;
                case 3:
                    System.out.println("\n");
                    modif();
                    break;
                case 4:
                    System.out.println("\n");
                    sup();
                    break;
                case 5:
                    System.out.println("\n");
                    rechnom();
                    break;
                /**case 6:
                    derncom();
                    break;**/
                case 6:
                    System.out.println("\n");
                    
                    break;
                default:
                    System.out.println("\nchoix incorrect");
            }

        } while (ch != 6);
        DBConnection.closeConnection();
    }

    public void nouveau() {

        System.out.print("sigle du local : ");
        String sigle = sc.nextLine();
        System.out.print("nombre de places : ");
        int places = sc.nextInt();
        sc.skip("\n");
        System.out.print("courte description : ");
        String description = sc.nextLine();
        locActuel = new Local(0, sigle, places, description);
      
        try {
            locActuel = localDAO.create(locActuel);
            System.out.println("local actuel : " + locActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void recherche() {
        try {
            System.out.println("numéro recherché : ");
            int nc = sc.nextInt();
            locActuel = localDAO.read(nc);
            System.out.println("local actuel : " + locActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modif() {
        try {
            System.out.println("entrez l'id du local à modifier : ");
            int id = sc.nextInt();
            sc.skip("\n");
            locActuel = localDAO.read(id);
            System.out.println("entrez le nouveau sigle du local : ");
            String nouvsigle = sc.nextLine();
            locActuel.setSigle(nouvsigle);
            System.out.println("entrez le nombre de places disponibles : ");
            int nouvplaces = sc.nextInt();
            sc.skip("\n");
            locActuel.setPlaces(nouvplaces);
            System.out.println("entrez une courte description du local : ");
            String nouvdescr = sc.nextLine();
            locActuel.setDescription(nouvdescr);
            localDAO.update(locActuel);
            System.out.println("local actuel : " + locActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void sup() {
        try {
            System.out.println("numéro du local à supprimer : ");
            int nc = sc.nextInt();
            locActuel = localDAO.read(nc);
            System.out.println("local actuel : "+ locActuel);
            localDAO.delete(locActuel);
            System.out.println("\nlocal portant l'id "+nc+" à été supprimé");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechnom() {
        System.out.println("entrez une partie de la description du local recherché : ");
        String nom = sc.nextLine();
        try {
            List<Local> alc = ((LocalDAO) localDAO).rechNom(nom);
            for (Local cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur : " + e.getMessage());
        }
    }

    /**public void derncom() {
        try {
            LocalDate dt = ((LocalDAO) localDAO).dern_com(locActuel);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String aff = dt.format(dtf);
            System.out.println("date de la denière commande de " + locActuel + " = " + aff);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestLocal gc = new GestLocal();
        gc.gestion();

    }**/

}
