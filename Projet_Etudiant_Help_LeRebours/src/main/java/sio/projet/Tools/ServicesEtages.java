package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.Etage;
import sio.projet.Entities.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicesEtages {


    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;


    public ServicesEtages () {
        uneCnx = ConnexionBDD.getCnx();
    }

    public ObservableList<Etage> AffichageEtages() throws SQLException {

        ObservableList<Etage> LesEtages = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT Distinct(etage) FROM salle ");

        rs = ps.executeQuery();

        while (rs.next()) {

            Etage unEtage = new Etage (rs.getInt(1));
            LesEtages.add(unEtage);
        }

        return LesEtages;
    }

}
