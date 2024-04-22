package sio.projet.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicesNiveau {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesNiveau () {
        uneCnx = ConnexionBDD.getCnx();
    }


    public String RecuperationNiveauUser(int id_user) throws SQLException {

        String niveau ="";
        ps = uneCnx.prepareStatement("Select niveau\n" +
                "from user\n" +
                "Where user.id = ?\n"
        );
        ps.setInt(1,id_user);
        rs= ps.executeQuery();
        if (rs.next()) {
            niveau = rs.getString("niveau");
        }

        return niveau;
    }
}
