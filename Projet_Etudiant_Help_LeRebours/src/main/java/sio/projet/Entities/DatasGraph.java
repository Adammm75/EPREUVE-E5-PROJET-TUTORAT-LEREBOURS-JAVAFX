package sio.projet.Entities;

public class DatasGraph {
    private String nomUser;
    private int nbCompetence;
    public DatasGraph(String nomUser, int nbCompetence)
    {
        this.nomUser = nomUser;
        this.nbCompetence = nbCompetence;
    }

    public String getNomUser() {
        return nomUser;
    }

    public int getNbCompetence() {
        return nbCompetence;
    }
}
