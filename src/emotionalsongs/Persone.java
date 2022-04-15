package emotionalsongs;

import java.io.Serializable;
import java.util.List;

public class Persone implements Serializable {

    private List<Persona> listaPersone;
    private InterfaceDB<Persona> DB;

    public InterfaceDB<Persona> getDB() {
        return DB;
    }

    public void setDB(InterfaceDB<Persona> DB) {
        this.DB = DB;
    }

    public List<Persona> getListaPersone() {
        return listaPersone;
    }

    public void setListaPersone(List<Persona> listaPersone) {
        this.listaPersone = listaPersone;
    }
}
