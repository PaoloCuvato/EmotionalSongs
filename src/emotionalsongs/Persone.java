package emotionalsongs;

import java.io.Serializable;
import java.util.List;

public class Persone implements Serializable {

    private List<Persona> listaPersone;
    private InterfaceDB<Persona> DB;

    //getter
    public InterfaceDB<Persona> getDB() {
        return DB;
    }

    public List<Persona> getListaPersone() {
        return listaPersone;
    }

    //setter
    public void setDB(InterfaceDB<Persona> DB) {
        this.DB = DB;
    }

    public void setListaPersone(List<Persona> listaPersone) {
        this.listaPersone = listaPersone;
    }

    //metodi
    public boolean Registrazione(Persona newPersona){
        //ritorna true se la registrazione è andata a buon fine --> utente è nuovo

        //il primo controllo che effettuo è se la lista è vuota  --> non effettuo alcun confronto
        if(listaPersone.isEmpty()){
            listaPersone.add(newPersona);
            DB.save(newPersona);
        }
        //se la lista non è vuota inizio con i confronti fra persone
        else{
            //utilizzo un bucle for-each per scorrere l'intera lista
            for(Persona persona : listaPersone ) {
                //confronto ogni persona già presente in lista con la nuova da inserire,
                //mediante i codici fiscali
                //condizione è true se sono uguali --> utente già registrato --> non lo salvo
                if ((persona.getCodiceFiscale()).equals(newPersona.getCodiceFiscale())) {
                    return false;
                }
            }
            //persona è nuova --> procedo con la registrazione effettiva
            listaPersone.add(newPersona);
            DB.save(newPersona);
        }
        return true;
    }


}
