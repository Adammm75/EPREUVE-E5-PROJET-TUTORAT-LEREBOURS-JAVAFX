package sio.projet.Entities;

import sio.projet.Tools.ServicesDemandes;

import java.time.LocalDate;

public class Demande extends ServicesDemandes {

    private int id;
    private LocalDate date_fin_demande;

    private String sousMatieres1;

    private int iduser;

    private LocalDate dateupdated;

    private int id_matiere;

    private int status;

    public Demande(int id,LocalDate date_fin_demande,String sousMatieres1, int iduser, LocalDate dateupdated, int id_matiere, int status) {
        this.id=id;
        this.date_fin_demande = date_fin_demande;
        this.dateupdated=dateupdated;
        this.sousMatieres1=sousMatieres1;
        this.iduser=iduser;
        this.id_matiere=id_matiere;
        this.status=status;
    }


    public int getId() {
        return id;
    }

    public String getSousMatieres1() {
        return sousMatieres1;
    }



    public int getStatus() {
        return status;
    }

    public LocalDate getDateupdated() {
        return dateupdated;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public int getIduser() {
        return iduser;
    }

    public String getSousmatieres() {
        return sousMatieres1;
    }

    public LocalDate getDate_fin_demande() {
        return date_fin_demande;
    }


}
