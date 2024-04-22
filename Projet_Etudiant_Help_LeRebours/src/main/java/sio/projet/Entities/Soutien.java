package sio.projet.Entities;

import java.time.LocalDate;

public class Soutien {

    private int id;
    private String prenom_tuteur;
    private String prenom_demandeur;
    private int id_salle;
    private LocalDate date_du_soutien;
    private LocalDate date_updated;
    private String description;
    private int status;

    public Soutien(int id, String prenom_tuteur, String prenom_demandeur, int id_salle, LocalDate date_du_soutien, LocalDate date_updated, String description, int status) {
        this.id=id;
        this.prenom_tuteur = prenom_tuteur;
        this.prenom_demandeur = prenom_demandeur;
        this.id_salle=id_salle;
        this.date_du_soutien = date_du_soutien;
        this.date_updated = date_updated;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getId_salle() {
        return id_salle;
    }

    public String getPrenom_tuteur() {
        return prenom_tuteur;
    }

    public String getPrenom_demandeur() {
        return prenom_demandeur;
    }

    public LocalDate getDate_du_soutien() {
        return date_du_soutien;
    }

    public LocalDate getDate_updated() {
        return date_updated;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }
}
