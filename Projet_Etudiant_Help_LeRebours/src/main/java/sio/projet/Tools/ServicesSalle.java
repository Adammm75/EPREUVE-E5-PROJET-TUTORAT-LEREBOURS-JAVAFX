package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.AffichageSalle;
import sio.projet.Entities.Salle;

import java.sql.*;

public class ServicesSalle {


    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;


    public ServicesSalle () {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<ServicesSalle> CreationSalle (int idMatiere, String codeSalle, int etage) throws SQLException {

        ObservableList<ServicesSalle> LesSalles = FXCollections.observableArrayList();


        ps =  uneCnx.prepareStatement("INSERT INTO salle (id ,code_salle, etage) VALUES (?,?,?)");

        ps.setInt(1,idMatiere);
        ps.setString(2,codeSalle);
        ps.setInt(3, etage);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            Salle uneSalle = new Salle(idMatiere, codeSalle, etage);
            LesSalles.add(uneSalle);
        }

        return LesSalles;

    }


    public ObservableList<Salle> AffichageSalles() throws SQLException {

        ObservableList<Salle> lesSalles = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT s.id,s.code_salle,s.etage FROM salle as s");

        rs = ps.executeQuery();

        while (rs.next()) {

            Salle uneSalle = new Salle (rs.getInt(1),rs.getString(2),rs.getInt(3));
            lesSalles.add(uneSalle);
        }

        return lesSalles;
    }

    public void ModificationSalle(int idMatiere,int nvIdMatiere, String numSalle, int numEtage) throws SQLException {
        PreparedStatement ps = uneCnx.prepareStatement("UPDATE salle as s SET s.id = ?, s.code_salle = ?,s.etage = ?  " +
                "WHERE s.id = ?;");

        ps.setInt(1, nvIdMatiere);
        ps.setString(2, numSalle);
        ps.setInt(3, numEtage);
        ps.setInt(4,idMatiere);

        ps.executeUpdate();
    }

    public ObservableList<AffichageSalle> AffichageSalle() throws SQLException {

        ObservableList<AffichageSalle> lesSalles = FXCollections.observableArrayList();

        ps =  uneCnx.prepareStatement("SELECT id \n" +
                "FROM salle \n" +
                "WHERE id NOT IN (SELECT id FROM salle WHERE id = 0);\n");

        rs = ps.executeQuery();

        while (rs.next()) {

            AffichageSalle uneSalle = new AffichageSalle (rs.getInt(1));
            lesSalles.add(uneSalle);
        }

        return lesSalles;
    }
}
