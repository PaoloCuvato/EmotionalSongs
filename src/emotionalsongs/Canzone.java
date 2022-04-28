package emotionalsongs;

import java.io.Serializable;

public class Canzone implements Serializable {
    private int ID;
    private String Nome;
    private String Artista;

    public Canzone(){
    }

    public Canzone(int ID,String Nome,String Artista){

        this.ID= ID;
        this.Nome=Nome;
        this.Artista= Artista;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }
}
