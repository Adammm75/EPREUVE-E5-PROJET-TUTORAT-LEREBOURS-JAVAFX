package sio.projet.Entities;

import java.time.LocalDate;
import java.util.Date;

public class AffichageSoutien {

    private int id_demande;
    private int id_competence;
    private int id_Salle;
    private LocalDate date_du_soutien;
    private LocalDate date_updated;
    private String description;
    private int status;

    public AffichageSoutien(int id_demande, int id_competence, int id_Salle, LocalDate date_du_soutien, LocalDate date_updated, String description, int status) {
        this.id_demande = id_demande;
        this.id_competence = id_competence;
        this.id_Salle = id_Salle;
        this.date_du_soutien = date_du_soutien;
        this.date_updated = date_updated;
        this.description = description;
        this.status = status;

    }

    public int getId_demande() {
        return id_demande;
    }

    public int getId_competence() {
        return id_competence;
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

    public int getId_Salle() {
        return id_Salle;
    }
}
