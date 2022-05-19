package emotionalsongs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CollezioneCanzoni implements Serializable
{
	private static int ID = 0; //va fatto settare ogni volta che riapro la applicazione
	private final int idPlaylist; //massimo 2147483647 playlist differenti
	private final String nome;
	private final int idPersona;
	private List<Integer> listaCanzoni;
	
	public CollezioneCanzoni(String nome, int idPersona)
	{
		if(nome == null)
			throw new NullPointerException("nome della playlist non puo' eseere null");
		if(idPersona < 0)
			throw new NullPointerException("l' id della persona che creato la playlist non puo' essere minore di 0");
		this.idPersona = idPersona;
		this.nome = nome;
		idPlaylist = ID++;
		this.listaCanzoni = new ArrayList<Integer>(10);
        /* potrebbe sembrare troppo poco 10 canzoni ma nel caso peggiore,
        in cui abbiamo le playsist formate da una singola canzone sprechiamo
        n*10, anziche n*100 o n*1000 e arraylist permette di aumentare gli id
        come una classica lista (FORSE CAMBIARE CON LINKEDLIST PERCHE NON CI
        SERVE RICERCA MA SOLO AGGIUNTA E RIMOZIONE, E DIMINUIREMMO RAM OCCUPATA)*/
	}
	
	public void aggiungiCanzone(int idCanzone)
	{
		if(idCanzone < 0)
			throw new NullPointerException("id canzone deve essere maggiore o uguale a 0");
		listaCanzoni.add(Integer.valueOf(idCanzone));
	}
	
	public void aggiungiCanzone(Canzone c)
	{
		if(c == null)
			throw new NullPointerException("non si puo' aggiungere una canzone null");
		//listaCanzoni.add(Integer.valueOf(c.getID())); da eliminare
		this.aggiungiCanzone(c.getID());
	}
	
	public void rimuoviCanzone(int idCanzone)
	{
		if(idCanzone < 0)
			throw new NullPointerException("id canzone deve essere maggiore o uguale a 0");
		listaCanzoni.remove(Integer.valueOf(idCanzone));
	}
	
	public void rimuoviCanzone(Canzone c)
	{
		if(c == null)
			throw new NullPointerException("non si puo' rimuovere una canzone null");
		//listaCanzoni.remove(Integer.valueOf(c.getID())); da eliminare
		this.rimuoviCanzone(c.getID());
	}
	
	public boolean canzonePresente(int idCanzone)
	{
		return listaCanzoni.contains(Integer.valueOf(idCanzone));
	}
	
	public boolean canzonePresente(Canzone c)
	{
		return this.canzonePresente(c.getID());
	}
	
	public int getIdPersona()
	{
		return idPersona;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public List<Integer> getListaCanzoni()
	{
		return listaCanzoni;
	}
	
	public void setListaCanzoni(List<Integer> listaCanzoni)
	{
		if(listaCanzoni == null)
			throw new NullPointerException("la lista deve essere creata non puo' avere riferimento null");
		this.listaCanzoni = listaCanzoni;
	}
	
	public static void setID(int id)
	{
		ID = id;
	}
}
