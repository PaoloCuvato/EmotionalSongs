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
		CollezioneCanzoni.setID(playlists.size());
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

	/**
	 * Con
	 * @param idPersona
	 * @param idCanzone
	 * @return True se la canzone corrispondente all'IdCanzone passato come argomento è presente in almeno una delle playlist dell'utente corrispondente all'IdPersona passato come argomento.
	 * 		   False altrimenti.
	 */
	public boolean associaCanzonePersona(int idPersona, int idCanzone)
	{
		for (CollezioneCanzoni c : playlists)
		{
			if (idPersona == c.getIdPersona())
				return c.canzonePresente(idCanzone);
		}
		return false;
	}
	
}
