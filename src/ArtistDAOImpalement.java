import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ronja on 2018-11-20.
 */
public class ArtistDAOImpalement implements ArtistDAO  {

    static Scanner sc = new Scanner(System.in);
    private String url="jdbc:mysql://localhost:3306/artists?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user="root";
    private String password=sc.nextLine();
    private Connection connection;
    private List<Artist> artists;
    private Statement statement;
    private ResultSet rs;
    private PreparedStatement insert, findById, findByNamn, update, delete;



    public ArtistDAOImpalement() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection successes");
        insert = connection.prepareStatement("insert into artistinfo(name, lastName, age) values (?,?,?)");
        findById = connection.prepareStatement("SELECT * from artistinfo where id=?");
        findByNamn = connection.prepareStatement("SELECT * from artistinfo WHERE name like ?");
        update = connection.prepareStatement("UPDATE artistinfo set name =?, lastName = ?, age = ? where id = ?");
        delete = connection.prepareStatement("delete from artistinfo where id =?");

    }


    @Override
    public void create(Artist artist) throws IOException, SQLException {
        try{
            insert.setString(1, artist.getName());
            insert.setString(2, artist.getLastName());
            insert.setString(3, String.valueOf(artist.getAge()));
            insert.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex);
        }
        Menu.menu();
    }

    @Override
    public void findAll() throws IOException, SQLException {
        try{
            statement = connection.createStatement();
            rs =statement.executeQuery("Select * from artistinfo");
            System.out.println("Table [ArtistInfo]");
            while (rs.next()){
                System.out.println("[ID: "+rs.getString("id")+ " Name: "+rs.getString("name") + " LastName: " +
                        rs.getString("lastName") + " Age: "+ rs.getInt("age")
                        +"]\n---------------------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Menu.menu();
    }

    @Override@SuppressWarnings("Duplicates")
    public void findById(int id) throws IOException, SQLException {
        try{
            findById.setInt(1,id);
            rs = findById.executeQuery();
            while (rs.next()){
                System.out.println("[ID: "+rs.getString("id")+" Name: "+rs.getString("name")
                        + " LastName: " + rs.getString("lastName") + " Age: "+ rs.getInt("age"));
            }
        }catch (SQLException exp){
            System.out.println(exp);
        }
        Menu.menu();
    }

    @Override@SuppressWarnings("Duplicates")
    public void findByName(String name) throws IOException, SQLException {
        try{
            findByNamn.setString(1,name);
            rs =findByNamn.executeQuery();
            while (rs.next()){
                System.out.println("[ID: "+rs.getString("id")+ " Name: "+rs.getString("name")
                        + " LastName: " + rs.getString("lastName") + " Age: "+ rs.getInt("age")+"]");
            }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
        Menu.menu();
    }
    @Override
    public void updateArtist(int id) throws IOException, SQLException {

        System.out.print("Enter new name: ");
        String updateName = sc.nextLine();
        System.out.print("Enter new last name: ");
        String updateLastName = sc.nextLine();
        System.out.println("Enter new age: ");
        int updateAge = sc.nextInt();
        try{

            update.setString(1,updateName);
            update.setString(2,updateLastName);
            update.setInt(3,updateAge);
            update.setInt(4,id);
            update.executeUpdate();

            System.out.println("The person with the ID "+id+" have been updated to ");
            findById(id);

        }catch (SQLException | IOException ex2){
            System.out.println(ex2);
        }
        Menu.menu();
    }

    @Override
    public void deleteArtist(int id) throws IOException, SQLException {
        try{
            delete.setInt(1,id);
            delete.execute();
            System.out.println("The person with the id "+id+" have been deleted from the database.");
        }catch (SQLException ex3){
            System.out.println(ex3);
        }
        Menu.menu();
    }
}
