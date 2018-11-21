import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ronja on 2018-11-20.
 */
public interface ArtistDAO {
    void create (Artist artist);
    void findAll();
    void findById(int id);
    void findByName() throws SQLException, IOException;
    void updateArtist(int id);
    void deleteArtist(int id);

}
