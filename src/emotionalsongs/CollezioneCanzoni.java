import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CollezioneCanzoni implements Serializable {
    private String nome;
    private String id_persona;
    private List<Integer> lista_canzoni;

    public CollezioneCanzoni(String nome, String id_persona) {
        this.id_persona = id_persona;
        this.nome = nome;
        this.lista_canzoni = new ArrayList<Integer>(10);
        /* potrebbe sembrare troppo poco 10 canzoni ma nel caso peggiore,
        in cui abbiamo le playsist formate da una singola canzone sprechiamo
        n*10, anziche n*100 o n*1000 e arraylist permette di aumentare gli id
        come una classica lista */
    }

    public void aggiungiCanzone(int id_canzone)
    {
        //futura aggiunta aumentare di 10 in 10 la lista
        lista_canzoni.add(Integer.valueOf(id_canzone));
    }

    public void rimuoviCanzone(int id_canzone)
    {
        lista_canzoni.remove(Integer.valueOf(id_canzone));
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getLista_canzoni() {
        return lista_canzoni;
    }

    public void setLista_canzoni(List<Integer> lista_canzoni) {
        this.lista_canzoni = lista_canzoni;
    }
}
