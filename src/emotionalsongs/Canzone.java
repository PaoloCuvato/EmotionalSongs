import java.io.Serializable;

public class Canzone implements Serializable {
    private int ID;
    private String Nome;
    private String Artista;

   // private interface DB <Canzone> get DB(){ da sistemare

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
        Nome = nome;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        Artista = Artista;
    }
}
