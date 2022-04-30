package emotionalsongs;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileDB<T> implements InterfaceDB<T>
{
	private Path path;
	private File file;
	private FileInputStream input;
	private FileOutputStream output;
	
	public FileDB(String percorsoFile) throws IOException
	{
		path = Paths.get(percorsoFile);
		file = path.toFile();
		if (!file.exists())
		{
			file.createNewFile();
		}
		if(file.canRead() && file.canWrite())
		{
			input = new FileInputStream(file);
			output = new FileOutputStream(file);
		}
	}
	
	public List getAll() throws IOException, ClassNotFoundException
	{
		ObjectInputStream objectstream = new ObjectInputStream(input);
		ArrayList<T> lista = new ArrayList<T>();
		T t = (T) objectstream.readObject();  // casting di persona o canzone o playlist
		while (t != null)
		{
			lista.add(t);
			t = (T) objectstream.readObject();  // Rileggiamo il file con oggetti
		}
		objectstream.close();
		return lista;
	}
	
	public Optional<T> get(Object id)
	{
		return null;
	}
	
	public void save(T t)
	{
	}
	
	public void update(T base, T modificato)
	{
	}
	
	public void delete(T t)
	{
	}
}
