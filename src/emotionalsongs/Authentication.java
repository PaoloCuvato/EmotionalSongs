package emotionalsongs;

/**
 * Classe per controllare che solo una persona possa essere loggata in un determinato momento
 */
public class Authentication {

    private static Persona loggedAs;
    private static Authentication authentication= new Authentication();

    private Authentication() {}
    
    /**
     *Ritorna un oggetto globale di tipo Authentication se una persona ha eseguito il login
     * @return Authentication che riferisce a se stessi
     */
    public static Authentication getAuthentication()
    {
        if(loggedAs == null)
            return null;
        else
            return authentication;
    }
    
    /**
     * Setta la persona che ha effettuato l'acesso
     * @param persona che ha passato il test dell login
     */
    public static void setAuthentication(Persona persona)
    {
        loggedAs = persona;
    }
    
    /**
     * Permette di sapere conoscere la persona che ha effettuato l'accesso
     * @return {@link Persona} se la persona ha effettuato l'acesso, {@code null} altrimenti
     */
    public static Persona getLoggedAs()
    {
        if(loggedAs == null)
            return null;
        else
            return loggedAs;
    }

    /**
     * Permette di effettuare il LogOut dall'applicazione.
     */
    public static void logOut()
    {
        loggedAs = null;
    }

    /**
     * Permette di controllare se qualcuno ha già effettuto l'accesso all'applicazione rimanendo connesso.
     * @return True se qualcuno ha già effettutato l'accesso. False se nessuno è connesso.
     */
    public static boolean isLogged()
    {
        /*if(loggedAs == null)
            return false;
        else
            return true;
        DA ELIMINARE*/
        return loggedAs != null;
    }
}
