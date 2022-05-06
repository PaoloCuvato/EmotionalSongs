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
    
    public static void logOut()
    {
        loggedAs = null;
    }
    
    public static boolean isLogged()
    {
        if(loggedAs == null)
            return false;
        else
            return true;
    }
}
