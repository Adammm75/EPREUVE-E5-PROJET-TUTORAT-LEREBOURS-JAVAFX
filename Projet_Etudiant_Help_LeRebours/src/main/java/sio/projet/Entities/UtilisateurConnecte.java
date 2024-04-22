package sio.projet.Entities;

public class UtilisateurConnecte {


    private static int connecteeeUserId;

    public static int getConnecteeUserId() {
        return connecteeeUserId;
    }

    public static void setConnecteeUserId(int userId) {
        connecteeeUserId = userId;
    }
}
