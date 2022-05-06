package emotionalsongs;

import java.io.IOException;
import java.lang.*;
import java.util.LinkedList;
import java.util.List;

public class Canzoni  {
    private static final String dbFile = "../../data/Canzoni.dati.txt";
    private InterfaceDB<Canzone> db;
    private List<Canzone> listacanzoni;

    Canzoni() throws IOException
    {
        db = new FileDB<Canzone>(dbFile);
        listacanzoni = db.getAll();
    }

    public List cercaBranoMusicale(String nomeBrano) {
        LinkedList<Canzone> listaBrani= new LinkedList<Canzone>();
        for (Canzone c: listacanzoni) {
            if (nomeBrano.equals(c.getNome() ))
                listaBrani.add(c);
        }
        if(listaBrani.isEmpty())
            return null;
        return listaBrani;
    }

    public List cercaBranoMusicale(String artista,int anno){
        LinkedList<Canzone> listaBrani= new LinkedList<Canzone>();
        for (Canzone c : listacanzoni) {
            if(artista.equals(c.getArtista())&& anno== c.getAnno()) {
                listaBrani.add(c);
            }
        }
        if(listaBrani.isEmpty())
            return null;
        return  listaBrani;
    }
    
    public Canzone cercaBranoMusicale(int Id) {
        for (Canzone c: listacanzoni) {
            if (Id == c.getID())
                return  c;
        }
        return null;
    }

}