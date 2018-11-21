import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ronja on 2018-11-20.
 */
public interface ArtistDAO {
    void create (Artist artist);
    void findAll();
    void findById();
    void findByName() throws SQLException, IOException;
    boolean updateArtist(Artist artist);
    boolean deleteArtist(Artist artist);

}
