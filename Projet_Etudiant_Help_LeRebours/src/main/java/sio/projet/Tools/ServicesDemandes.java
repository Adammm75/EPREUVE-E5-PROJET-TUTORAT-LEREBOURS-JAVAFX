package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import sio.projet.Entities.AffichageAutresDemandes;
import sio.projet.Entities.AffichageDemande;
import sio.projet.Entities.Demande;
import sio.projet.Entities.SousMatiere;

import java.sql.*;
import java.time.LocalDate;

public class ServicesDemandes {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesDemandes () {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<ServicesDemandes> CréationDemandes (LocalDate datefindemande, String sousmatiereString, int iduser, LocalDate dateupdated, int id_matiere, int status) throws SQLException {

        ObservableList<ServicesDemandes> LesDemandes = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("INSERT INTO `demande`( `date_updated`, `date_fin_demande`, `sous_matiere`, `id_user`,`id_matiere`,`status` ) VALUES (?,?,?,?,?,?)");

        ps.setDate(1, Date.valueOf(dateupdated));
        ps.setDate(2, Date.valueOf(datefindemande));
        ps.setString(3,sousmatiereString);
        ps.setInt(4, iduser);
        ps.setInt(5, id_matiere);
        ps.setInt(6, status);

        int id= 0;

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            Demande uneDemande = new Demande(id, datefindemande, sousmatiereString, iduser,dateupdated,id_matiere, status);
            LesDemandes.add(uneDemande);
        }

        return LesDemandes;

    }


    public ObservableList<AffichageDemande> AffichageDemandes(int iduser) throws SQLException {

        ObservableList<AffichageDemande> lesdemandes = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT `id`, `date_updated`, `date_fin_demande`, `sous_matiere`" +
                " FROM `demande`" +
                " Where id_user =? ");
        ps.setInt(1,iduser);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id1 = rs.getInt("id");
            LocalDate dateUpdated = rs.getDate("date_updated").toLocalDate();
            LocalDate dateFinDemande = rs.getDate("date_fin_demande").toLocalDate();
            String sous_matiere = rs.getString("sous_matiere");
            int id = 0;
            //int id = rs.getInt("id_user");

            AffichageDemande affichage1Demande = new AffichageDemande(id1, dateUpdated, dateFinDemande, sous_matiere, id);
            lesdemandes.add(affichage1Demande);
        }

        return lesdemandes;
    }


    public LocalDate AffichageDemandesModifier(int idDemande) throws SQLException {

        Date date_fin_demande = null;

        ps = uneCnx.prepareStatement("Select demande.date_fin_demande\n" +
                "from demande\n" +
                 "Where demande.id = ?\n"
        );
        ps.setInt(1,idDemande);
        rs= ps.executeQuery();
        if (rs.next()) {
            date_fin_demande = rs.getDate("date_fin_demande");
        }

        return date_fin_demande.toLocalDate();
    }


    public ObservableList<ServicesDemandes> ModificationDemandes (LocalDate datefindemande, String sousmatiereString, LocalDate dateupdated, int id, int id_matiere, int status, int idDemande) throws SQLException {

        ObservableList<ServicesDemandes> LesDemandes = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("UPDATE demande\n" +
                "SET\n" +
                "    demande.date_updated = ?,\n" +
                "    demande.date_fin_demande = ?,\n" +
                "    demande.sous_matiere = ?,\n" +
                "    demande.id_matiere = ?,\n" +
                "    demande.status = ?\n" +
                "WHERE\n" +
                "    demande.id = ?\n");

        ps.setDate(1, Date.valueOf(dateupdated));
        ps.setDate(2, Date.valueOf(datefindemande));
        ps.setString(3,sousmatiereString);
        ps.setInt(4, id_matiere);
        ps.setInt(5, status);
        ps.setInt(6, idDemande);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            AffichageDemande uneDemande = new AffichageDemande(id ,datefindemande,dateupdated, sousmatiereString,id);
            LesDemandes.add(uneDemande);
        }

        return LesDemandes;
    }


    public ObservableList<AffichageAutresDemandes> AffichageAutreDemandes(int iduser, String Niveau) throws SQLException {

        ObservableList<AffichageAutresDemandes> lesdemandes = FXCollections.observableArrayList();


        ps =  uneCnx.prepareStatement("SELECT DISTINCT demande.id, demande.date_updated, demande.date_fin_demande, demande.sous_matiere, \n" +
                "user_demandeur.prenom AS prenom_user_demande, user_demandeur.nom AS nom_user_demande, user_demandeur.niveau, demande.id_user, competence.id, demande.id_matiere\n" +
                "                FROM demande\n" +
                "                Join matiere on demande.id_matiere = matiere.id\n" +
                "                JOIN user AS user_demandeur ON demande.id_user = user_demandeur.id\n" +
                "                JOIN competence ON matiere.id = competence.id_matiere\n" +
                "                JOIN user AS user_competent ON competence.id_user = user_competent.id\n" +
                "                Where user_competent.niveau = ?\n" +
                "                AND (\n" +
                " \t\t\t\t\t(user_demandeur.niveau = \"Terminale\" AND user_competent.niveau = \"BTS 2\") OR\n" +
                "                    (user_demandeur.niveau = \"BTS 1\" AND user_competent.niveau = \"Bachelor\") OR\n" +
                "                    (user_demandeur.niveau = \"BTS 2\" AND user_competent.niveau = \"Master 1\") OR \n" +
                "                    (user_demandeur.niveau = \"Bachelor\" AND user_competent.niveau = \"Master 2\")OR\n" +
                "                    (user_demandeur.niveau = \"BTS 2\" AND user_competent.niveau = \"Master 2\")OR\n" +
                "                    (user_demandeur.niveau = \"BTS 1\" AND user_competent.niveau = \"Master 2\")OR\n" +
                "                   (user_demandeur.niveau = \"BTS 2\" AND user_competent.niveau = \"Master 1\")OR\n" +
                "                    (user_demandeur.niveau = \"Terminale\" AND user_competent.niveau = \"Bachelor\")OR \n" +
                "                    (user_demandeur.niveau = \"Terminale\" AND user_competent.niveau = \"Master 2\")OR \n" +
                "                    (user_demandeur.niveau = \"BTS 1\" AND user_competent.niveau = \"Master 1\"))\n" +
                "                AND demande.id_user NOT IN (\n" +
                "                   SELECT id_user\n" +
                "                 FROM demande\n" +
                "                  WHERE id_user = ? )" +
                "GROUP BY demande.id");

        ps.setString(1,Niveau);
        ps.setInt(2,iduser);

        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            LocalDate dateUpdated = rs.getDate("date_updated").toLocalDate();
            LocalDate dateFinDemande = rs.getDate("date_fin_demande").toLocalDate();
            String sous_matiere = rs.getString("sous_matiere");
            int id1 = rs.getInt("id_user");
            String prenom = rs.getString("prenom_user_demande");
            String nom = rs.getString("nom_user_demande");
            String niveau = rs.getString("niveau");
            int id_matiere = rs.getInt("id_matiere");

            AffichageAutresDemandes affichage1Demande = new AffichageAutresDemandes(nom, niveau,prenom, id, dateUpdated, dateFinDemande, sous_matiere, id1, id_matiere);
            lesdemandes.add(affichage1Demande);
        }

        return lesdemandes;
    }


}
