package emotionalsongs;

public class Authentication {

    public static Persona loggedAs;
    public static boolean islogged = false;
    private static Authentication authentication= new Authentication();

    private Authentication() {
    }

    public static boolean isIslogged() {
        return islogged;
    }

    public static Authentication getAuthentication()
    {
        return authentication;
    }
}
