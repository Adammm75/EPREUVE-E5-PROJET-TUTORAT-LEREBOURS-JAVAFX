package sio.projet.Entities;

import sio.projet.Tools.ServicesCompetence;

public class Competence extends ServicesCompetence {


    private int id_matiere;

    private int iduser;

    private String Sousmatiere;

    private int statut;
    public Competence(int id_matiere, int iduser, String Sousmatiere, int statut) {
        this.id_matiere = id_matiere;
        this.iduser = iduser;
        this.Sousmatiere = Sousmatiere;
        this.statut = statut;
    }
    public int getId_matiere() {
        return id_matiere;
    }

    public int getIduser() {
        return iduser;
    }

    public String getSousmatiere() {
        return Sousmatiere;
    }

    public int getStatut() {
        return statut;
    }
}
