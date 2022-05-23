package emotionalsongs;
public class Authentication {

    private static Persona loggedAs;
    private static Authentication authentication= new Authentication();

    private Authentication() {}

    public static Authentication getAuthentication()
    {
        if(loggedAs == null)
            return null;
        else
            return authentication;
    }
    
    public static void setAuthentication(Persona p)
    {
        loggedAs = p;
    }
    
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
        if(loggedAs == null)
            return false;
        else
            return true;
    }
}
