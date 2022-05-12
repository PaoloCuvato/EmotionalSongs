package emotionalsongs;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Classe per la creazione, aggiunta, modifica e eliminazione di oggetti serializzati
 * su un database di tipo testuale
 * @author Tropeano Martina
 * @author Guenzani Pierpaolo
 * @author Cuvato Paolo
 * @author Paradiso Fabiola
 * @param <T> Classe da serializzare su file (es: < Integer>)
 * @see InterfaceDB
 * @see Serializable
 * @see FileOutputStream
 * @see FileInputStream
 * @see ObjectOutputStream
 * @see ObjectInputStream
 */
public class FileDB<T> implements InterfaceDB<T>
{
	private final Path path;
	private File file;
	private FileInputStream input;
	private FileOutputStream output;
	
	/**
	 * Apre (e crea se neccessario) un database su file di testo
	 * @param percorsoFile percorso del file di testo
	 * @throws IOException se il file non può essere creato
	 */
	public FileDB(String percorsoFile) throws IOException
	{
		if(percorsoFile == null)
			throw new NullPointerException("il percorso non puo' essere null");
		path = Paths.get(percorsoFile);
		file = path.toFile();
		if (!file.exists())
		{
			file.createNewFile();
		}
		if (file.canRead() && file.canWrite())
		{
			input = new FileInputStream(file);
			output = new FileOutputStream(file);
		}
		//else ecezzzione da creare...
	}
	
	/**
	 * Funzione per la restituzione di tutti gli oggetti presenti nel db
	 * @return LinkedList di tutti gli oggettio nel db, null se non ci sono oggetti
	 * @throws IOException nel caso non si possa legge il file
	 * @see java.util.LinkedList
	 */
	public List getAll() throws IOException
	{
		ObjectInputStream objectstream = new ObjectInputStream(input);
		//ArrayList<T> lista = new ArrayList<T>();
		LinkedList<T> lista = new LinkedList<>();
		try
		{
			T t = (T) objectstream.readObject();    // casting di persona o canzone o playlist
			while (t != null)                        //leggo il file fino a quando non trovo un oggetto null
			{
				lista.add(t);
				t = (T) objectstream.readObject();  // Rileggiamo il file con oggetti
			}
		}
		catch (ClassNotFoundException e)
		{}
		finally
		{
			objectstream.close();
		}
		return lista;
	}
	
	/**
	 * Restituisce un oggetto dal suo identificatore
	 * @param id identificatore
	 * @return Optional contenente il dato ricercato
	 */
	public Optional<T> get(Object id)
	{
		if(id == null)
			throw new NullPointerException("il dato non puo' essere null");
		//@TODO come faccio a fare il confronto...
		return null;
	}
	
	/**
	 * Salva sul file l'oggetto passato
	 * @param t ogetto da salvare
	 * @throws IOException nel caso {@link ObjectOutputStream#writeObject(Object)} restituisca un eccezione
	 * @see ObjectOutputStream
	 * @see FileOutputStream
	 */
	public void save(T t) throws IOException
	{
		if(t == null)
			throw new NullPointerException("il dato non puo' essere null");
		ObjectOutputStream objectstream = new ObjectOutputStream(output);
		objectstream.writeObject(t);
		objectstream.flush();
		objectstream.close();
	}
	
	/**
	 * Sostituisce sul file l'ogetto passato con quello attuale
	 * @param base ogetto da sostituire
	 * @param modificato ogetto che sostituisce il precedente
	 * @return true -se l'operazione è stata eseguita con successo
	 * false -se l'operzione non è andata a buon fine
	 * @throws IOException nel case {@link FileDB#save(Object)}, {@link FileDB#delete(Object)}
	 * restituiscano un eccezione
	 * @see ObjectOutputStream
	 * @see FileOutputStream
	 */
	public boolean update(T base, T modificato) throws IOException
	{
		if(base == null)
			throw new NullPointerException("il dato da modificare non puo' essere null");
		if(modificato == null)
			throw new NullPointerException("il dato da sostituire non puo' essere null");
		if(!this.delete(base))
			return false;
		this.save(modificato);
		return true;
	}
	
	/**
	 * Elimina dal file l'ogetto passato
	 * @param t oegtto da eliminare
	 * @return true -se l'operazione è stata eseguita con successo
	 * false -se l'operzione non è andata a buon fine
	 * @throws IOException nel caso {@link ObjectOutputStream#writeObject(Object)}, {@link ObjectOutputStream#flush()},
	 * {@link ObjectOutputStream#close()} restituiscano un eccezione
	 * @see ObjectOutputStream
	 * @see	FileOutputStream
	 */
	public boolean delete(T t) throws IOException
	{
		if(t == null)
		throw new NullPointerException("il ogetto da eliminare non puo' essere null");
		LinkedList<T> lista = (LinkedList<T>)this.getAll();
		if(!lista.remove(t))
			return true;
		this.close();
		if(!file.delete())
			return false;
		if(!file.createNewFile())
			return false;
		if(!file.canWrite() && !file.canRead())
			return false;
		input = new FileInputStream(file);
		output = new FileOutputStream(file);
		ObjectOutputStream objectstream = new ObjectOutputStream(output);
		for (T n : lista)
		{
			objectstream.writeObject(n);
			objectstream.flush();
		}
		objectstream.close();
		return true;
	}
	
	/**
	 * Chiude gli stream di input e putput del file
	 * @throws IOException
	 * @see FileInputStream
	 * @see FileOutputStream
	 */
	public void close() throws IOException
	{
		input.close();
		output.close();
	}
}
