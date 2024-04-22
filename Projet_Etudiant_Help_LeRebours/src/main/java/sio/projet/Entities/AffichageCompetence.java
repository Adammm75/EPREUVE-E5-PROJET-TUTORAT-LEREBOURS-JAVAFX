package sio.projet.Entities;

import sio.projet.Tools.ServicesCompetence;

public class AffichageCompetence extends ServicesCompetence {
    private String sous_matieres;

    private int id;

    private int id_user;

    public int getId_user() {
        return id_user;
    }

    public int getId() {
        return id;
    }

    public String getSous_matieres() {
        return sous_matieres;
    }

    public AffichageCompetence(String sous_matieres, int id, int id_user) {
        this.sous_matieres = sous_matieres;
        this.id=id;
        this.id_user=id_user;
    }
}
