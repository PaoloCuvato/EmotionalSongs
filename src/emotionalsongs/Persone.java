package emotionalsongs;

import java.io.IOException;
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
	
	public Persone() throws IOException
	{
		db = new FileDB<>("../../data/UtentiRegistrati.txt");
		listaPersone = db.getAll();
	}
	
	//metodi
	public boolean Registrazione(Persona newPersona) throws IOException
	{
		//ritorna true se la registrazione è andata a buon fine --> utente è nuovo

		if (!listaPersone.isEmpty()) {
			//utilizzo un bucle for-each per scorrere l'intera lista
			for (Persona persona : listaPersone) {
				//confronto ogni persona già presente in lista con la nuova da inserire,
				//mediante gli UserId
				//condizione è true se sono uguali --> utente già registrato --> non lo salvo
				if ((persona.getUserId()).equals(newPersona.getUserId())) {
					return false;
				}
			}
			//persona è nuova --> procedo con la registrazione effettiva
		}
		listaPersone.add(newPersona) ;
		db.save(newPersona) ;
		return true;
	}

	public boolean accedi(String userId, String password)
	{
		/*
		// se ritorna true --> c'è già qualcuno collegato da far disconnettere
		if( Authentication.isLogged() ){
			// se è la stessa persona che tenta di riaccedere --> la lasciamo dentro
			Persona personaLogIn = Authentication.getLoggedAs();
			if( userId.equals(personaLogIn.getUserId()) ){
				// se condizione è true --> la persona è la stessa --> ritorna true
				return true;
			}else{
				// se la condizione è false --> la persona è diversa

			}
		}
		*/

		for(Persona persona : listaPersone)
		{
			if( ((persona.getUserId()).equals(userId)) & ((persona.getPassword().equals(password))) ){
				Authentication.setAuthentication(persona);
				return true;    //accesso riuscito
			}
		}
		return false;  //accesso non riuscito
	}


}
