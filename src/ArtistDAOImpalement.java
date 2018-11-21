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
        insert = connection.prepareStatement("insert into artistinfo(name, lastName, age) values (?,?,?)");
        findById = connection.prepareStatement("SELECT * from artistinfo where id like ?");
        findByNamn = connection.prepareStatement("SELECT * from artistinfo WHERE name like ?");
        update = connection.prepareStatement("UPDATE artistinfo set name =?");
        artists=new ArrayList<>();
    }


    @Override
    public void create(Artist artist) {
        try{
            insert.setString(1, artist.getName());
            insert.setString(2, artist.getLastName());
            insert.setString(3, String.valueOf(artist.getAge()));
            insert.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void findAll()  {
        try{
            statement = connection.createStatement();
            rs =statement.executeQuery("Select * from artistinfo");
            System.out.println("Table [ArtistInfo]");
            List<Artist> temp = new ArrayList<>();
            while (rs.next()){
                System.out.println("[ID: "+rs.getString("id")+ " Name: "+rs.getString("name") + " LastName: " +
                        rs.getString("lastName") + " Age: "+ rs.getInt("age")
                        +"]\n---------------------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ;
    }

    @Override@SuppressWarnings("Duplicates")
    public void findById() {
        System.out.print("Type what ID you want to search from: ");
        int id1 = Integer.parseInt(sc.nextLine());
      try{
          findById.setString(1,"%"+id1+"%");
          rs = findById.executeQuery();
          while (rs.next()){
              System.out.println("[ID: "+rs.getString("id")+" Name: "+rs.getString("name")
                      + " LastName: " + rs.getString("lastName") + " Age: "+ rs.getInt("age"));
          }
      }catch (SQLException exp){
          System.out.println(exp);
      }
    }

    @Override@SuppressWarnings("Duplicates")
    public void findByName() {
        System.out.print("Type what name you want to search from: ");
        String name= sc.nextLine();
        try{
               findByNamn.setString(1,"%"+name+"%");
               rs =findByNamn.executeQuery();
            while (rs.next()){
                    System.out.println("[ID: "+rs.getString("id")+ " Name: "+rs.getString("name")
                            + " LastName: " + rs.getString("lastName") + " Age: "+ rs.getInt("age"));
            }
        }catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public boolean updateArtist(Artist artist) {
        return false;
    }

    @Override
    public boolean deleteArtist(Artist artist) {
        return false;
    }

}
