package sio.projet.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class GraphiqueController2 {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public GraphiqueController2() {
        cnx = ConnexionBDD.getCnx();
    }

    public HashMap<String, Integer> GetDatasGraphique1() {
        HashMap<String, Integer> datas = new HashMap();
        try {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement("SELECT matiere.designation, COUNT(demande.id) AS demande_count\n" +
                    "                    FROM demande\n" +
                    "                    Join matiere on demande.id_matiere = matiere.id\n" +
                    "                    GROUP BY designation");
            rs = ps.executeQuery();
            while (rs.next()) {
                datas.put(rs.getString(1), rs.getInt(2));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return datas;
    }

    public HashMap<String, Integer> GetDatasGraphique2() {
        HashMap<String, Integer> datas = new HashMap();
        try {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement("SELECT matiere.designation, COUNT(competence.id) AS competence_count\n" +
                    "FROM competence\n" +
                    "Join matiere on competence.id_matiere = matiere.id\n" +
                    "GROUP BY designation");
            rs = ps.executeQuery();
            while (rs.next()) {
                datas.put(rs.getString(1), rs.getInt(2));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return datas;
    }
}
