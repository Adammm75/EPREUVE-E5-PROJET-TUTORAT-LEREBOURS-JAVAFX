package sio.projet.Entities;

import sio.projet.Tools.ServicesDemandes;
import sio.projet.Tools.ServicesUser;

public class User extends ServicesUser
{
    private int id;
    private String prenom;
    private String mdp;
    public int getId() {
        return id;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getMdp() {
        return mdp;
    }
    public User(String prenom, String mdp, int id) {

        this.prenom = prenom;
        this.mdp = mdp;
        this.id=id;

    }


}
