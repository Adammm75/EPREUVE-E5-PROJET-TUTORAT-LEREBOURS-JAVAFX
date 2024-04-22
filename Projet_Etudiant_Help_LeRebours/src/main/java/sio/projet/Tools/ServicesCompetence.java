package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.AffichageCompetence;
import sio.projet.Entities.Competence;

import java.sql.*;

public class ServicesCompetence {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesCompetence () {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<ServicesCompetence> CréationCompétences(int id_matiere, int iduser, String Sousmatiere, int statut) throws SQLException {

        ObservableList<ServicesCompetence> LesCompetences = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("INSERT INTO `competence`(`id_matiere`,`id_user`,`sous_matiere`,`statut` ) VALUES (?,?,?,?)");
        ps.setInt(1, id_matiere);
        ps.setInt(2, iduser);
        ps.setString(3,Sousmatiere);
        ps.setInt(4, statut);

        int rowsAffected = ps.executeUpdate();

        // Vous pouvez ajouter la nouvelle demande directement à votre liste observable si nécessaire
        if (rowsAffected > 0) {
            Competence uneCompetence = new Competence(id_matiere, iduser, Sousmatiere, statut );
            LesCompetences.add(uneCompetence);
        }

        return LesCompetences;

    }


    public ObservableList<AffichageCompetence> VisualiserCompétences(int iduser) throws SQLException {

        ObservableList<AffichageCompetence> lescompetences = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT `id`, `sous_matiere`, `id_user`  FROM `competence` WHERE id_user = ?");

        ps.setInt(1,iduser);

        rs = ps.executeQuery();

        while (rs.next()) {

            String sous_matieres = rs.getString("sous_matiere");
            int id = rs.getInt("id");
            int id_user1 = rs.getInt("id_user");

            AffichageCompetence affichage1competence = new AffichageCompetence(sous_matieres, id, id_user1);
            lescompetences.add(affichage1competence);
        }

        return lescompetences;
    }


    public ObservableList<ServicesCompetence> ModificationCompetences (int id, String sousmatiereString, int statut, int id_user, int id_matiere  ) throws SQLException {

        ObservableList<ServicesCompetence> Lescompetences = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("UPDATE competence\n" +
                "SET\n" +
                "    competence.sous_matiere = ?,\n" +
                "    competence.id_matiere = ?,\n" +
                "    competence.statut = ?,\n" +
                "    competence.id_user = ?\n" +
                "WHERE\n" +
                "    competence.id = ?\n");

        ps.setString(1,sousmatiereString);
        ps.setInt(2, id_matiere);
        ps.setInt(3,statut);
        ps.setInt(4, id_user);
        ps.setInt(5,id);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {

            AffichageCompetence unecompetence = new AffichageCompetence(sousmatiereString, id, id_user);
            Lescompetences.add(unecompetence);
        }

        return Lescompetences;
    }


    public int VerifIdMatiere(int iduser, int id_matiere, String sousmatiere) throws SQLException {

        int id=0;
        ps =  uneCnx.prepareStatement("SELECT `id`" +
                "  FROM `competence`" +
                " WHERE id_user = ?" +
                " AND id_matiere = ?" +
                " AND sous_matiere = ?");

        ps.setInt(1,iduser);
        ps.setInt(2,id_matiere);
        ps.setString(3,sousmatiere);

        rs= ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;
    }

    public int RécuperationSousmatiere(int iduser) throws SQLException {

        int id=0;
        ps =  uneCnx.prepareStatement("SELECT `id_matiere`,  FROM `competence` WHERE id_user = ?");
        ps.setInt(1,iduser);
        rs= ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;
    }
}