package emotionalsongs;

import java.io.Serializable;
import java.util.List;

public class Persone
{
	
	private List<Persona> listaPersone;
	private InterfaceDB<Persona> db;
	
	//getter
	public InterfaceDB<Persona> getDB()
	{
		return db;
	}
	
	public List<Persona> getListaPersone()
	{
		return listaPersone;
	}
	
	//setter
	public void setDB(InterfaceDB<Persona> DB)
	{
		this.db = DB;
	}
	
	public void setListaPersone(List<Persona> listaPersone)
	{
		this.listaPersone = listaPersone;
	}
	
	public Persone() throws IOException, ClassNotFoundException
	{
		db = new FileDB<>("../../data/UtentiRegistrati.txt");
		listaPersone = db.getAll();
	}
	
	//metodi
	public boolean Registrazione(Persona newPersona)
	{
		//ritorna true se la registrazione è andata a buon fine --> utente è nuovo
		
		//il primo controllo che effettuo è se la lista è vuota  --> non effettuo alcun confronto
		if (listaPersone.isEmpty())
		{
			listaPersone.add(newPersona);
			db.save(newPersona);
		}
		//se la lista non è vuota inizio con i confronti fra persone
		else
		{
			//utilizzo un bucle for-each per scorrere l'intera lista
			for (Persona persona : listaPersone)
			{
				//confronto ogni persona già presente in lista con la nuova da inserire,
				//mediante i codici fiscali
				//condizione è true se sono uguali --> utente già registrato --> non lo salvo
				if ((persona.getCodiceFiscale()).equals(newPersona.getCodiceFiscale()))
				{
					return false;
				}
			}
			//persona è nuova --> procedo con la registrazione effettiva
			listaPersone.add(newPersona);
			db.save(newPersona);
		}
		return true;
	}

	public boolean accedi(String userId, String password)
	{
		for(Persona persona : listaPersone)
		{
			if( ((persona.getUserId()).equals(userId)) && ((persona.getPassword().equals(password))) )
				return true;    //accesso riuscito
		}
		return false;  //accesso non riuscito
	}


}
