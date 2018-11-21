/**
 * Created by Ronja on 2018-11-13.
 */



import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException, IOException {

        ArtistDAO dao = new ArtistDAOImpalement();
        System.out.println("Hello and welcome the artist management application.\n"
                + "What would you like to do?\n"
                + "[1] Add an artist.\n"
                + "[2] Show all artists.\n"
                + "[3] Find an artist by ID.\n"
                + "[4] Find an artist by Name\n"
                + "[5] Update an artist.\n"
                + "[6] Delete an artist.\n"
                + "[0] Exit application. ");


        String choice = sc.nextLine();
        while (true) {

            switch (choice) {

                case "1":  // create
                    System.out.print("Insert first name: ");
                    String name = sc.nextLine();
                    System.out.print("Insert last name: ");
                    String lastNamn =sc.nextLine();
                    int age=sc.nextInt();
                    sc.nextLine();
                    Artist artist = new Artist(name,lastNamn,age);
                    dao.create(artist);
                    break;

                case "2": // read/find All
                    dao.findAll();
                    break;

                case "3":  // Find by ID
                    System.out.print("Type what ID of the Artist you want to search for: ");
                    int id =sc.nextInt();
                    sc.nextLine();
                    dao.findById(id);
                    break;

                case "4": // Find by Name
                    System.out.print("Type what name you want to search for: ");
                    String nameSearch =sc.nextLine();
                    dao.findByName(nameSearch);
                    break;

                case "5": // Update
                    System.out.print("Type what ID of the Artist you want to update: ");
                    int idUpdate =sc.nextInt();
                    sc.nextLine();
                    dao.updateArtist(idUpdate);
                    break;

                case "6": // Delete.
                    System.out.print("Type what ID of the Artist you want to DELETE: ");
                    int idDelete =sc.nextInt();
                    sc.nextLine();
                    dao.deleteArtist(idDelete);
                    break;

                case"0": //Quit Program.
                    System.out.println("Program is exiting");
                    System.exit(0);
                        break;
                default:
                    System.out.println("Wrong choice. Try aging");
                    break;
            }

        }
    }
}