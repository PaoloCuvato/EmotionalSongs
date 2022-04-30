package emotionalsongs;

import java.io.IOException;
import java.util.List;

public class Persone {

    private List<Persona> listaPersone;
    private InterfaceDB<Persona> db;

    public InterfaceDB<Persona> getDB() {
        return db;
    }

    public void setDB(InterfaceDB<Persona> DB) {
        this.db = DB;
    }

    public List<Persona> getListaPersone() {
        return listaPersone;
    }

    public void setListaPersone(List<Persona> listaPersone) {
        this.listaPersone = listaPersone;
    }
    
    public Persone() throws IOException, ClassNotFoundException
    {
        db = new FileDB<>("../../data/UtentiRegistrati.txt");
        listaPersone = db.getAll();
    }
}
