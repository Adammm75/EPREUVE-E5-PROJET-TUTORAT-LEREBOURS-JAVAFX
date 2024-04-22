package sio.projet.Entities;

public class UserConnexion
{
    private String emailUser;
    private String mdpUser;

    public UserConnexion(String emailUser, String mdpUser) {
        this.emailUser = emailUser;
        this.mdpUser = mdpUser;
    }
    public String getEmailUser() {
        return emailUser;
    }

    public String getMdpUser() {
        return mdpUser;
    }
}
