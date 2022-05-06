package emotionalsongs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CollezioneCanzoni implements Serializable
{
	private final String nome;
	private final String idPersona;
	private List<Integer> listaCanzoni;
	
	public CollezioneCanzoni(String nome, String idPersona)
	{
		if(nome == null)
			throw new NullPointerException("nome della playlist non puo' eseere null");
		if(idPersona == null)
			throw new NullPointerException("l' User_id della persona che creato la playlist non puo' eseere null");
		this.idPersona = idPersona;
		this.nome = nome;
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
		//futura aggiunta aumentare di 10 in 10 la lista
		listaCanzoni.add(Integer.valueOf(idCanzone));
	}
	
	public void rimuoviCanzone(int idCanzone)
	{
		if(idCanzone < 0)
			throw new NullPointerException("id canzone deve essere maggiore o uguale a 0");
		listaCanzoni.remove(Integer.valueOf(idCanzone));
	}
	
	public String getIdPersona()
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
}
