package emotionalsongs;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Playlists implements Serializable
{
	private List<CollezioneCanzoni> playlists;
	private InterfaceDB<CollezioneCanzoni> db;
	
	public InterfaceDB<CollezioneCanzoni> getDB()
	{
		return db;
	}
	
	public void setDB(InterfaceDB<CollezioneCanzoni> DB)
	{
		this.db = DB;
	}
	
	public List<CollezioneCanzoni> getPlaylists()
	{
		return playlists;
	}
	
	public void setPlaylists(List<CollezioneCanzoni> playlists)
	{
		this.playlists = playlists;
	}
	
	public Playlists() throws IOException, ClassNotFoundException
	{
        db = new FileDB<>("../../data/Playlist.txt");
		playlists = db.getAll();
	}
}
