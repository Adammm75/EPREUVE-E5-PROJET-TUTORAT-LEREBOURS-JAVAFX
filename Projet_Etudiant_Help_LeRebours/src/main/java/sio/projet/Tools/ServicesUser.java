package sio.projet.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.projet.Entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ServicesUser
{
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesUser()
    {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<User> VerifUser() throws SQLException {

        ObservableList<User> Users = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT `prenom`, `password`, `id`  FROM `user` Where user.role = 'Etudiant'  ");

        rs = ps.executeQuery();

        while (rs.next()) {
            String mdp = rs.getString("password");
            String user = rs.getString("prenom");
            int id = rs.getInt("id");


            User user1 = new User(mdp, user, id);
            Users.add(user1);
        }

        return Users;
    }

    public ObservableList<User> RecuperationInformationsUser(String mdp, String prenom) throws SQLException {

        ObservableList<User> user = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT `id` " +
                "FROM `user` " +
                "Where `prenom` = ?" +
                "And `password`= ? "
        );

        ps.setString(1, prenom);
        ps.setString(2, mdp);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");

            User user1 = new User(mdp, prenom, id);
            user.add(user1);
        }

        return user;
    }
    public ObservableList<User> VerifAdminConnexion() throws SQLException {

        ObservableList<User> Users = FXCollections.observableArrayList();

            ps = uneCnx.prepareStatement("SELECT `prenom`, `password`, `id`  FROM `user` Where user.role = 'Administrateur' ");



        rs = ps.executeQuery();


        while (rs.next()) {
            String mdp = rs.getString("password");
            String user = rs.getString("prenom");
            int id = rs.getInt("id");


            User user1 = new User(mdp, user, id);
            Users.add(user1);
        }

        return Users;
    }

}
