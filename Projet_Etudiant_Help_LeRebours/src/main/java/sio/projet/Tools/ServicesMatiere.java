package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.*;

import java.sql.*;
import java.time.LocalDate;

public class ServicesMatiere {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;


    public ServicesMatiere () {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<AffichageMatiere> AffichageMatières() throws SQLException {

        ObservableList<AffichageMatiere> lesMatieres = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT designation FROM matiere ");

        rs = ps.executeQuery();

        while (rs.next()) {

            AffichageMatiere uneMatiere = new AffichageMatiere (rs.getString(1));
            lesMatieres.add(uneMatiere);
        }

        return lesMatieres;
    }


    public ObservableList<SousMatiere> AffichageSousMatières(String matiere) throws SQLException {

        ObservableList<SousMatiere> lesSousmatieres = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT `sous_matiere` FROM `matiere` WHERE designation = ? ");
        ps.setString(1, matiere);
        rs = ps.executeQuery();

        while (rs.next()) {
            String sousMatiereString = rs.getString(1);

            String[] sousMatiereArray = sousMatiereString.split("#");
            for (String sousMatiere : sousMatiereArray) {
                if (!sousMatiere.trim().isEmpty()) {
                    SousMatiere unesousmatiere = new SousMatiere(sousMatiere.trim());
                    lesSousmatieres.add(unesousmatiere);
                }
            }
        }

        return lesSousmatieres;
    }


    public int RécuperationIdmatiere(String matiere) throws SQLException {

        int id=0;
        ps = uneCnx.prepareStatement("Select matiere.id\n" +
                "from matiere\n" +
                "Where matiere.designation = ?\n"
        );
        ps.setString(1,matiere);
        rs= ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;
    }




    public ObservableList<VraieMatiere> AffichageVraieMatiere() throws SQLException {

        ObservableList<VraieMatiere> lesMatieres = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT m.id,m.designation,m.sous_matiere FROM matiere as m");

        rs = ps.executeQuery();

        while (rs.next()) {

            VraieMatiere uneMatiere = new VraieMatiere (rs.getInt(1),rs.getString(2),0,rs.getString(3));
            lesMatieres.add(uneMatiere);
        }

        return lesMatieres;
    }

   public ObservableList<ServicesMatiere> AjoutMatiere(String nom,int code, String sousMatiere) throws SQLException {

       ObservableList<ServicesMatiere> LesMatières = FXCollections.observableArrayList();

       ps = uneCnx.prepareStatement("INSERT INTO `matiere` (`designation`, `code`, `sous_matiere`) VALUES (?, ?, ?)");

    ps.setString(1, nom);
       ps.setInt(2, code);
       ps.setString(3, sousMatiere);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            Matiere uneMatiere = new Matiere(nom, code, sousMatiere);
            LesMatières.add(uneMatiere);
        }

        return LesMatières;

    }



    public void modifierMatiere(int idMatiere, String nomMatiere, String sousMatieres) throws SQLException {
        PreparedStatement ps = uneCnx.prepareStatement("UPDATE `matiere` SET `designation` = ?, `sous_matiere` = ? WHERE `id` = ?");

        ps.setString(1, nomMatiere);
        ps.setString(2, sousMatieres);
        ps.setInt(3, idMatiere);

        ps.executeUpdate();
    }




}
