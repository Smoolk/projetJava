package gestion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import classes.DAO.CoursDAO;
import classes.DAO.DAO;
import classes.metiers.Cours;
import classes.metiers.Formateur;
import classes.metiers.Cours;
import classes.metiers.Session;
import myconnections.DBConnection;

public class GestCours {

    Scanner sc = new Scanner(System.in);
    Cours coursActuel = null;
    DAO<Cours> coursDAO = null;

    public GestCours() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        coursDAO = new CoursDAO();
        coursDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("\n##########################################################################\nMenu cours\n##########################################################################\n\n1.nouveau \n2.recherche\n3.modification\n4.suppression\n5.recherche sur nom\n6.retour au menu principal\n");
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

        System.out.print("nom de la matière : ");
        String matiere = sc.nextLine();
        System.out.print("nombre d'heures : ");
        int heures = sc.nextInt();
        coursActuel = new Cours(0, matiere, heures);
      
        try {
            coursActuel = coursDAO.create(coursActuel);
            System.out.println("cours actuel : " + coursActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void recherche() {
        try {
            System.out.println("numéro recherché : ");
            int nc = sc.nextInt();
            coursActuel = coursDAO.read(nc);
            System.out.println("cours actuel : " + coursActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modif() {
        try {
            System.out.println("entrez l'id du cours à modifier : ");
            int id = sc.nextInt();
            sc.skip("\n");
            coursActuel = coursDAO.read(id);
            System.out.println("entrez la nouvelle matière du cours : ");
            String nouvmatiere = sc.nextLine();
            coursActuel.setMatière(nouvmatiere);
            System.out.println("entrez le nombre d'heures du cours : ");
            int nouvHeures = sc.nextInt();
            sc.skip("\n");
            coursActuel.setHeures(nouvHeures);
            coursDAO.update(coursActuel);
            System.out.println("cours actuel : " + coursActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void sup() {
        try {
            System.out.println("numéro du cours à supprimer : ");
            int nc = sc.nextInt();
            coursActuel = coursDAO.read(nc);
            System.out.println("cours actuel : "+ coursActuel);
            coursDAO.delete(coursActuel);
            System.out.println("\nLe cours portant l'id "+nc+" à été supprimé");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechnom() {
        System.out.println("entrez le nom du cours recherché : ");
        String nom = sc.nextLine();
        try {
            List<Cours> alc = ((CoursDAO) coursDAO).rechNom(nom);
            for (Cours cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur : " + e.getMessage());
        }
    }

    /**public void derncom() {
        try {
            CoursDate dt = ((CoursDAO) coursDAO).dern_com(coursActuel);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Course.FRENCH);
            String aff = dt.format(dtf);
            System.out.println("date de la denière commande de " + coursActuel + " = " + aff);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestCours gc = new GestCours();
        gc.gestion();

    }**/

}
