import java.io.Serializable;
import java.util.List;

public class Playlists implements Serializable {
    private List<CollezioneCanzoni> playlists;
    private InterfaceDB<CollezioneCanzoni> DB;

    public InterfaceDB<CollezioneCanzoni> getDB() {
        return DB;
    }

    public void setDB(InterfaceDB<CollezioneCanzoni> DB) {
        this.DB = DB;
    }

    public List<CollezioneCanzoni> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<CollezioneCanzoni> playlists) {
        this.playlists = playlists;
    }

}
