package gestion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import classes.DAO.FormateurDAO;
import classes.DAO.DAO;
import classes.metiers.Cours;
import classes.metiers.Formateur;
import classes.metiers.Formateur;
import classes.metiers.SessionCours;
import myconnections.DBConnection;

public class GestFormateur {

    Scanner sc = new Scanner(System.in);
    Formateur formActuel = null;
    DAO<Formateur> formateurDAO = null;

    public GestFormateur() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        formateurDAO = new FormateurDAO();
        formateurDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("\n##########################################################################\nMenu formateur\n##########################################################################\n\n1.nouveau \n2.recherche\n3.modification\n4.suppression\n5.recherche sur nom\n6.retour au menu principal\n");
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

        System.out.print("Matricule : ");
        String matricule = sc.nextLine();
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Numéro : ");
        String numero = sc.nextLine();
        System.out.print("Rue : ");
        String rue = sc.nextLine();
        System.out.print("Localité : ");
        String localite = sc.nextLine();
        System.out.print("Code postal : ");
        int cp = sc.nextInt();
        sc.skip("\n");
        System.out.print("Téléphone : ");
        String tel = sc.nextLine();
        formActuel = new Formateur(0, matricule, nom, prenom, numero, rue, localite, cp, tel);
      
        try {
            formActuel = formateurDAO.create(formActuel);
            System.out.println("formateur actuel : " + formActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void recherche() {
        try {
            System.out.println("numéro recherché : ");
            int nc = sc.nextInt();
            formActuel = formateurDAO.read(nc);
            System.out.println("formateur actuel : " + formActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modif() {
        try {
            System.out.println("entrez l'id du formateur à modifier : ");
            int id = sc.nextInt();
            sc.skip("\n");
            formActuel = formateurDAO.read(id);
            System.out.println("entrez le nouveau matricule du formateur : ");
            String nouvMatr = sc.nextLine();
            formActuel.setMatricule(nouvMatr);
            System.out.println("entrez le nom du formateur : ");
            String nouvNom = sc.nextLine();
            formActuel.setNom(nouvNom);
            System.out.println("entrez le prénom du formateur : ");
            String nouvPrenom = sc.nextLine();
            formActuel.setPrenom(nouvPrenom);
            System.out.println("entrez le numéro de maison du formateur : ");
            String nouvNumero = sc.nextLine();
            formActuel.setNumero(nouvNumero);
            System.out.println("entrez la rue du formateur : ");
            String nouvRue = sc.nextLine();
            formActuel.setRue(nouvRue);
            System.out.println("entrez la localité du formateur : ");
            String nouvLocalite = sc.nextLine();
            formActuel.setLocalite(nouvLocalite);
            System.out.println("entrez le code postal du formateur : ");
            int nouvCp = sc.nextInt();
            sc.skip("\n");
            formActuel.setCp(nouvCp);
            System.out.println("entrez le numéro de téléphone du formateur : ");
            String nouvTel = sc.nextLine();
            formActuel.setTel(nouvTel);
            formateurDAO.update(formActuel);
            System.out.println("formateur actuel : " + formActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void sup() {
        try {
            System.out.println("Id du formateur à supprimer : ");
            int nc = sc.nextInt();
            formActuel = formateurDAO.read(nc);
            System.out.println("formateur actuel : "+ formActuel);
            formateurDAO.delete(formActuel);
            System.out.println("\nformateur portant l'id "+nc+" à été supprimé");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechnom() {
        System.out.println("entrez le nom du formateur recherché : ");
        String nom = sc.nextLine();
        try {
            List<Formateur> alc = ((FormateurDAO) formateurDAO).rechNom(nom);
            for (Formateur cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur : " + e.getMessage());
        }
    }

    /**public void derncom() {
        try {
            FormateurDate dt = ((FormateurDAO) formateurDAO).dern_com(formActuel);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Formateure.FRENCH);
            String aff = dt.format(dtf);
            System.out.println("date de la denière commande de " + formActuel + " = " + aff);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestFormateur gc = new GestFormateur();
        gc.gestion();

    }**/

}
