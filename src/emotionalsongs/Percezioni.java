package emotionalsongs;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe per l'implementazione della nostra logica
 *  @author Paradiso Fabiola
 */

public class Percezioni {
    private List<Percezione> listaPercezioni;
    private InterfaceDB<Percezione> db;

    public Percezioni() throws IOException {

        db= new FileDB<>("../../data/Emozioni.dati.txt");

        if(listaPercezioni.isEmpty())
            throw new NullPointerException("la lista delle percezioni non può essere null");
    }

    public List cercaEmozioni(String idCanzone) {
        LinkedList<Percezione> listaEmozioni= new LinkedList<Percezione>();
        for (Percezione p: listaPercezioni) {
            if (idCanzone.equals(p.getSongId()))
                listaEmozioni.add(p);
        }
        if (listaEmozioni.size()==0)
            return null;
        return listaEmozioni;}


    //getter e setter
    /**
     * Restituisce la lista delle percezioni rappresentata dall'oggetto che esegue il metodo.
     * @return la lista delle percezioni
     */
    
    public List<Percezione> getListaPercezioni() {
        return listaPercezioni;
    }

    /**
     * Assegna la lista delle percezioni alla percezione rappresentata dall'oggetto che esegue il metodo.
     * @param listaPercezioni
     */

    public void setListaPercezioni(List<Percezione> listaPercezioni) {
        this.listaPercezioni = listaPercezioni;
    }

    /**
     * Restituisce il nostro oggetto db rappresentata dall'oggetto che esegue il metodo.
     * @return db
     */

    public InterfaceDB<Percezione> getDb() {
        return db;
    }

    /**
     * Assegna il Database fornito come argomento alla percezione rappresentata dall'oggetto che esegue il metodo.
     * @param db
     */

    public void setDb(InterfaceDB<Percezione> db) {
        this.db = db;
    }
}
