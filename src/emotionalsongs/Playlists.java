package emotionalsongs;

import java.io.IOException;
import java.util.List;

public class Playlists
{
	private List<CollezioneCanzoni> playlists;
	private InterfaceDB<CollezioneCanzoni> db;
	
	public Playlists() throws IOException
	{
		db = new FileDB<>("../../data/Playlist.dati.txt");
		playlists = db.getAll();
	}
	
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
	
}
