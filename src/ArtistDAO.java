import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ronja on 2018-11-20.
 */
public interface ArtistDAO {
    void create (Artist artist) throws IOException, SQLException;
    void findAll() throws IOException, SQLException;
    void findById(int id) throws IOException, SQLException;
    void findByName(String name) throws SQLException, IOException;
    void findByAge(int age) throws SQLException, IOException;
    void updateArtist(int id) throws IOException, SQLException;
    void deleteArtist(int id) throws IOException, SQLException;

}
