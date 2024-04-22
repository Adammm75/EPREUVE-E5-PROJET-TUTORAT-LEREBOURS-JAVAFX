package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.AffichageSoutien;
import sio.projet.Entities.SousMatiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicesSousMatieres {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesSousMatieres()
    {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<SousMatiere> RecuperationSousMatiereUser(int id_user) throws SQLException {

        ObservableList<SousMatiere> LesSousMatieres = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("Select sous_matiere\n" +
                "from competence\n" +
                "Where id_user = ?\n"
        );
        ps.setInt(1,id_user);
        rs= ps.executeQuery();
        while (rs.next()) {
            String sous_matiere = rs.getString("sous_matiere");
            SousMatiere sous_matieres = new SousMatiere(sous_matiere) ;
            LesSousMatieres.add(sous_matieres);
        }

        return LesSousMatieres;
    }

}
