package emotionalsongs;

import java.io.Serializable;

public class Persona implements Serializable, Comparable<Persona> {

    //campi
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String indirizzoFisico;
    private String email;
    private String password;

    //costruttore
    public Persona(){}

    public Persona(String nome, String cognome, String codiceFiscale, String indirizzoFisico, String email, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.indirizzoFisico = indirizzoFisico;
        this.email = email;
        this.password = password;
    }

    //getter
    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    public String getIndirizzoFisico(){
        return indirizzoFisico;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    //setter
    public void setNome(String nuovoNome){
        this.nome = nuovoNome;
    }

    public void setCognome(String nuovoCognome){
        this.cognome = nuovoCognome;
    }

    public void setCodiceFiscale(String nuovoCodiceFiscale){
        this.codiceFiscale = nuovoCodiceFiscale;
    }

    public void setIndirizzoFisico(String nuovoIndirizzoFisico){
        this.indirizzoFisico = nuovoIndirizzoFisico;
    }

    public void setEmail(String nuovaEmail){
        this.email = nuovaEmail;
    }

    public void setPassword(String nuovaPassword){
        this.password = nuovaPassword;
    }

    public int compareTo(Persona persona) {
        if(persona == null) return 1;
        return codiceFiscale.compareTo(persona.codiceFiscale);
        /* ritorna:
             <0 se obj1<obj2
             0 se obj1==obj2
             >0 se obj1>obj2
         */
    }


}
