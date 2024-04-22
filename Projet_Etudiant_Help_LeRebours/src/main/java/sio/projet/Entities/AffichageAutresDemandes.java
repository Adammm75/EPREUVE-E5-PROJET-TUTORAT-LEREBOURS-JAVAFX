package sio.projet.Entities;

import javafx.scene.chart.PieChart;
import sio.projet.Tools.ServicesDemandes;

import java.time.LocalDate;
import java.util.Date;

public class AffichageAutresDemandes extends ServicesDemandes {

    private String nom;
    private String niveau;
    private String prenom;
    private int id;
    private LocalDate date_updated;

    private LocalDate date_fin_demande;

    private String sous_matiere;

    private int id_user;

    private int id_matiere;

    public AffichageAutresDemandes(String nom, String niveau,String prenom, int id, LocalDate date_updated, LocalDate date_fin_demande, String sous_matiere, int id_user, int id_matiere) {
        this.nom=nom;
        this.niveau=niveau;
        this.prenom = prenom;
        this.id = id;
        this.date_updated = date_updated;
        this.date_fin_demande = date_fin_demande;
        this.sous_matiere = sous_matiere;
        this.id_user = id_user;
        this.id_matiere= id_matiere;
    }


    public String getNom() {
        return nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate_updated() {
        return date_updated;
    }

    public LocalDate getDate_fin_demande() {
        return date_fin_demande;
    }

    public String getSous_matiere() {
        return sous_matiere;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    @Override
    public String toString() {
        return "AffichageAutresDemandes{" +
                "nom='" + nom + '\'' +
                ", niveau='" + niveau + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id=" + id +
                ", date_updated=" + date_updated +
                ", date_fin_demande=" + date_fin_demande +
                ", sous_matiere='" + sous_matiere + '\'' +
                ", id_user=" + id_user +
                '}';
    }
}
