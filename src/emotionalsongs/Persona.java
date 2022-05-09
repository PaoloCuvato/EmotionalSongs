package emotionalsongs;

import java.io.Serializable;

public class Persona implements Serializable, Comparable<Persona>
{
	
	//campi
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzoFisico;
	private String email;
	private String password;
	private final String userId;
	
	//costruttore
	public Persona(String nome, String cognome, String codiceFiscale, String indirizzoFisico, String email, String password, String userId)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzoFisico = indirizzoFisico;
		this.email = email;
		this.password = password;
		this.userId = userId;
	}
	
	//getter
	public String getNome()
	{
		return nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	
	public String getCodiceFiscale()
	{
		return codiceFiscale;
	}
	
	public String getIndirizzoFisico()
	{
		return indirizzoFisico;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getUserId(){
		return userId;
	}
	
	//setter
	public void setNome(String nuovoNome)
	{
		this.nome = nuovoNome;
	}
	
	public void setCognome(String nuovoCognome)
	{
		this.cognome = nuovoCognome;
	}
	
	public void setCodiceFiscale(String nuovoCodiceFiscale)
	{
		this.codiceFiscale = nuovoCodiceFiscale;
	}
	
	public void setIndirizzoFisico(String nuovoIndirizzoFisico)
	{
		this.indirizzoFisico = nuovoIndirizzoFisico;
	}
	
	public void setEmail(String nuovaEmail)
	{
		this.email = nuovaEmail;
	}
	
	public void setPassword(String nuovaPassword)
	{
		this.password = nuovaPassword;
	}

	
	//metodo
	public int compareTo(Persona persona)
	{
		if (persona == null)
			throw new NullPointerException("Comparazione fallita.");
		return codiceFiscale.compareTo(persona.codiceFiscale);
        /* ritorna:
             <0 se obj1<obj2
             0 se obj1==obj2
             >0 se obj1>obj2
         */
	}
 
}
