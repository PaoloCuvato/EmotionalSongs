package emotionalsongs;

import java.io.Serializable;

public class Canzone implements Serializable,Comparable<Canzone>
{
	private int ID;
	private String Nome;
	private String Artista;
	private int anno;

	public Canzone()
	{
	}
	
	public Canzone(int ID, String Nome, String Artista,int anno)
	{
		this.ID = ID;
		this.Nome = Nome;
		this.Artista = Artista;
		this.anno=anno;
	}
	
	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public String getNome()
	{
		return Nome;
	}

	public void setNome(String nome)
	{
		this.Nome = nome;
	}

	public String getArtista()
	{
		return Artista;
	}

	public void setArtista(String Artista)
	{
		this.Artista = Artista;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	@Override
	public int compareTo(Canzone o) {
		if (ID== o.getID())
			return 0;
		if (ID> o.getID()|| o== null)
			return 1;
		else return -1;
	}
}
// scrive compare to e restituisce  1 se maggiore ,-1 se minore e 0 se e uguale