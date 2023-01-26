package authenticator;

public class UserAuthenticator {

    private UserAuthenticator()
    {

    }
    public  static boolean isAdmin(String Token)
    {
        return true;
    }
    public  static boolean isMember(String token)
    {
        return true;
    }
}
