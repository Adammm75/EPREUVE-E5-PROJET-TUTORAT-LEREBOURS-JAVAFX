package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.AffichageDemande;
import sio.projet.Entities.AffichageSoutien;
import sio.projet.Entities.Demande;
import sio.projet.Entities.Soutien;

import java.sql.*;
import java.time.LocalDate;

public class ServicesSoutiens {


    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;


    public ServicesSoutiens() {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<AffichageSoutien> CréationSoutien(int idDemande, int idCompetence, int idSalle, LocalDate date_fin_demande, LocalDate date_updated, String Description, int status) throws SQLException {

        ObservableList<AffichageSoutien> LesSoutiens = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("INSERT INTO `soutien`( `id` ,`id_demande`, `id_competence`,`id_salle`, `date_du_soutien`, `date_updated`, `description`, `status`) VALUES (0,?,?,?,?,?,?,?)");

        ps.setInt(1, idDemande);
        ps.setInt(2, idCompetence);
        ps.setInt(3, idSalle);
        ps.setDate(4, Date.valueOf(date_fin_demande));
        ps.setDate(5, Date.valueOf(date_updated));
        ps.setString(6, Description);
        ps.setInt(7, status);


        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            AffichageSoutien unSoutien = new AffichageSoutien(idDemande, idCompetence, idSalle, date_updated, date_fin_demande, Description, status);
            LesSoutiens.add(unSoutien);
        }

        return LesSoutiens;

    }

    public ObservableList<Soutien> AffichageSoutiens() throws SQLException {

        ObservableList<Soutien> lesSoutiens = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT soutien.id,\n" +
                " u_demandeur.prenom AS prenom_demandeur,\n" +
                "u_tuteur.prenom AS prenom_tuteur, soutien.id_salle, soutien.date_du_soutien, soutien.date_updated, soutien.description, soutien.status\n" +
                "          FROM soutien\n" +
                "INNER JOIN demande ON soutien.id_demande = demande.id\n" +
                " INNER JOIN competence ON soutien.id_competence = competence.id\n" +
                " INNER JOIN user u_demandeur ON demande.id_user = u_demandeur.id\n" +
                " INNER JOIN user u_tuteur ON competence.id_user = u_tuteur.id");

        rs = ps.executeQuery();

        while (rs.next()) {

            int id_soutien = rs.getInt("id");
            String prenom_tuteur = rs.getString("prenom_tuteur");
            String prenom_demandeur = rs.getString("prenom_demandeur");
            int id_salle = rs.getInt("id_salle");
            LocalDate date_du_soutien = rs.getDate("date_du_soutien").toLocalDate();
            LocalDate date_updated = rs.getDate("date_updated").toLocalDate();
            String description = rs.getString("description");
            int status = rs.getInt("status");


            Soutien soutien1 = new Soutien(id_soutien,prenom_tuteur, prenom_demandeur, id_salle, date_du_soutien, date_updated, description, status);
            lesSoutiens.add(soutien1);
        }

        return lesSoutiens;


    }
    public void AffectationSoutien(int idSoutien, int num_salle) throws SQLException {

        ps =  uneCnx.prepareStatement("UPDATE soutien\n " +
                "SET id_salle = ?,\n" +
                "status = 2\n " +
                "WHERE id = ?;\n");

        ps.setInt(1, num_salle);
        ps.setInt(2, idSoutien);


        ps.executeUpdate();

    }
}






