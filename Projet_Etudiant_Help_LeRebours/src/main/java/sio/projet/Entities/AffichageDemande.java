package sio.projet.Entities;

import sio.projet.Tools.ServicesDemandes;

import java.time.LocalDate;

public class AffichageDemande extends ServicesDemandes {

    private int id;
    private LocalDate date_fin_demande;
    private LocalDate date_updated;
    private String sous_matiere;

    private int id_user;

    public int getId() {
        return id;
    }
    public int getId_user() {
        return id_user;
    }

    public LocalDate getDate_fin_demande() {
        return date_fin_demande;
    }

    public LocalDate getDate_updated() {
        return date_updated;
    }

    public String getSous_matiere() {
        return sous_matiere;
    }

    public AffichageDemande(int id, LocalDate date_fin_demande, LocalDate date_updated, String sous_matiere, int id_user) {
        this.id=id;
        this.date_updated = date_updated;
        this.date_fin_demande = date_fin_demande;

        this.sous_matiere = sous_matiere;
        this.id_user = id_user;
    }


}
