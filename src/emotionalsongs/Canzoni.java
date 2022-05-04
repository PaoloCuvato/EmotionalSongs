package emotionalsongs;

import java.lang.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Canzoni implements Serializable {
    private InterfaceDB<Canzone> db;
    private List<Canzone> listacanzoni;

    Canzoni() {
        listacanzoni = new ArrayList<>(5000);
        listacanzoni = db.getAll();
    }

    public String CercaBrano(String nomeBrano) {
        String NomeCanzone = "";
        String errore= new String("Canzone non presente");

        for (Object o : db.getAll()) {
            if (nomeBrano.equals(Canzone.getNome() ))
                NomeCanzone = Canzone.getNome();
            else return errore;
    }
        return Canzone.getNome();
    }

    public List cercaPerArtista(String artista){
        LinkedList<String> PlaylistArtista= new LinkedList<String>();
        for (Object o: db.getAll()) {
            if(artista.equals(Canzone.getArtista())) {
             //   for ( artista : Canzone.getArtista()) {
                    PlaylistArtista.add(Canzone.getNome());
                }
           // }
        }
        return  PlaylistArtista;

    }

    public String CercaPerId(int Id) {
        String nomeCanzone = "";
        String errore= new String("Canzone non presente");

        for (Object o : db.getAll()) {
            if (Id == Canzone.getID())
                nomeCanzone = Canzone.getNome();
            else return errore;
        }
        return Canzone.getNome();
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
//return List Canzone;