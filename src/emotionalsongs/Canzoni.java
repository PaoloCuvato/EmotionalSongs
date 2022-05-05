package emotionalsongs;

import java.lang.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Canzoni  {
    private InterfaceDB<Canzone> db;
    private List<Canzone> listacanzoni;

    Canzoni() {
        listacanzoni = db.getAll();
    }

    public List cercaBranoMusicale(String nomeBrano) {
        LinkedList<Canzone> listaBrani= new LinkedList<Canzone>();

        for (Canzone c: listacanzoni) {
            if (nomeBrano.equals(c.getNome() ))
                listaBrani.add(c);
        }
        return listaBrani;
    }

    public List cercaBranoMusicale(String artista,int anno){
        LinkedList<Canzone> listaBrani= new LinkedList<Canzone>();
        for (Canzone c : listacanzoni) {
            if(artista.equals(c.getArtista())&& anno== c.getAnno()) {
                listaBrani.add(c);
            }
        }
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

//CercaPerBrano(id){
//if canzone.id == id
// return canzone

//CercaBrano(String nomebrano){
//return canzone

// return String="";
// }
//CercaPerArtista(artista){


// cerchi artista nella lista se e presente aggiungi tutte canzoni a una lined e la restituisci
// return Linked list
//return List Canzone