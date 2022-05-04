package emotionalsongs;

import java.io.Serializable;

public class Canzone implements Serializable {
    private static int ID;
    private static String Nome;
    private static String Artista;

    public Canzone(){
    }

    public Canzone(int ID,String Nome,String Artista){

        this.ID= ID;
        this.Nome=Nome;
        this.Artista= Artista;

    }

    public static int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public static String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    // IMPORTANTE inizialmente volevo fare return per al posto di x,il problema e' che mi da errore,quindi sono stato costretto a fare in questo modo

    public  int compareTo(int ID) throws Exception {
        int x=0;
        for (Object o: FileDB.getAll()) { // mi da errore get all non  e' static in File db ma prima di modificare volevo chiere se andava bene renderlo static
            if(ID==Canzone.ID)
                x=0;
            else if (ID > Canzone.getID())
                x= 1;
            else x= -1;
        }
       return x;
    }
    }

// scrive compare to e restituisce  1 se maggiore ,-1 se minore e 0 se e uguale
