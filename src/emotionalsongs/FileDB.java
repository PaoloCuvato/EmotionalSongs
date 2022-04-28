package emotionalsongs;

import java.io.*;
import java.nio.file.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;

public class FileDB<T> implements InterfaceDB<T>{
    Path path;
    FileInputStream input;
    public FileDB(String percorsoFile) throws FileNotFoundException {
        path=Paths.get(percorsoFile);
        input= new FileInputStream(path.toFile());
    }

    public List getAll() throws Exception {

        ObjectInputStream objectstream= new ObjectInputStream(input);
        ArrayList<T> lista= new ArrayList<T>();
        T t= (T)objectstream.readObject();  // casting di persona o canzone o playlist
        while (t !=null) {
            lista.add(t);
            t= (T)objectstream.readObject();  // Rileggiamo il file con oggetti
        }

        return lista;
    }
    public Optional<T> get(Object id){return null;}
    public void save(T t){}
    public void update(T base, T modificato){}
    public void delete(T t){}
}
