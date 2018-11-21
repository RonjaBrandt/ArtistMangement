/**
 * Created by Ronja on 2018-11-13.
 */



import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException {
        System.out.println("Hello and welcome the artist management application.\n"
                + "What would you like to do?\n"
                + "[1] Add an artist.\n"
                + "[2] Delete an artist.\n"
                + "[3] Update an artist.\n"
                + "[4] Show all artists.\n"
                + "[5] Find an artist by ID."
                + "[6] Exit application. ");

        String choice = sc.nextLine();
        ArtistDAO dao = new ArtistDAOImpalement();
        String name="";
        String lastNamn ="";
        Integer age=0;



        while (true) {

            switch (choice) {

                case "1":  // add
                    System.out.println("Insert first name");
                    name = sc.nextLine();
                    lastNamn =sc.nextLine();
                    age=sc.nextInt();
                    sc.next();
                    Artist a = new Artist(name,lastNamn,age);





                    break;

                case "2": // delete
                    break;

                case "3":  // update
                    break;

                case "4": // show all
                    break;

                case "5": // findby id
                    break;

                case "6": // exit program.
                    System.exit(0);
                    break;

            }

        }
    }
}
/*
Project goal:
The purpose of this project is for you to exercise on your newly learned topics such as SQL, JDBC and
core java.
Project description:
Object type: Artist
Attributes: id, name, lastName, age X
You are supposed to create methods to:
Add
Delete
Update
Show All
FindById
Optional: FindByAge , FindByName
Step 1: Choose your database type (JavaDb or MySql) and add to your project the appropriate driver. X
Step 2: Create your table X
Step 3: Create your main menu X
Step 4: Create your methods to serve your menu
*/