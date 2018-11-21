/**
 * Created by Ronja on 2018-11-13.
 */



import java.io.IOException;
import java.sql.SQLException;

public class Main {



    public static void main(String[] args) throws SQLException, IOException {
        ArtistDAO dao = new ArtistDAOImpalement();
        Artist a1 = new Artist("Jennie","Holm",33);

        dao.create(a1);
        //dao.findAll();
        dao.findByName();





    }
}