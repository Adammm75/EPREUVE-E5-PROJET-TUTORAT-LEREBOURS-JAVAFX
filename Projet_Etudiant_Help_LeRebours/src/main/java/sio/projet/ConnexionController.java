package sio.projet;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sio.projet.Entities.User;
import sio.projet.Entities.UtilisateurConnecte;
import sio.projet.Tools.ConnexionBDD;
import sio.projet.Tools.ServicesUser;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnexionController implements Initializable {

    @FXML
    private TextField idIdentifiant;
    @FXML
    private Button BtnSeConnecter;
    @FXML
    private TextField idMdp;
    ServicesUser serviceuser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            new ConnexionBDD();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void BtnSeConnecterClicked(Event event) throws IOException, SQLException {

        String prenom = idIdentifiant.getText();
        String mdp = idMdp.getText();

        serviceuser = new ServicesUser();
        ObservableList<User> userList = serviceuser.VerifUser();
        ObservableList<User> userList2 = serviceuser.VerifAdminConnexion();
        boolean statututilisateur = false;

        for (User utilisateur : userList) {
            String prenombdd = utilisateur.getMdp();
            String mdpbdd = utilisateur.getPrenom();
                if (prenombdd.equals(prenom) && mdpbdd.equals(mdp)) {
                    int userId = utilisateur.getId();
                    UtilisateurConnecte.setConnecteeUserId(userId);
                    System.out.println(userId);
                    statututilisateur = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Accès Validé");
                    alert.setHeaderText("Bienvenue " + prenom + " sur votre Espace Etudiant");
                    alert.showAndWait();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Etudiant_view.fxml"));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("Espace Etudiant");
                    stage.setScene(scene);
                    stage.show();

                    break;
                }

        }
        for (User utilisateur2 : userList2) {
            String prenomadmin = utilisateur2.getMdp();
            String mdpadmin = utilisateur2.getPrenom();
            if (prenomadmin.equals(prenom) && mdpadmin.equals(mdp)) {
                int userId2 = utilisateur2.getId();
                UtilisateurConnecte.setConnecteeUserId(userId2);
                System.out.println(userId2);
                statututilisateur = true;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Accès Validé");
                alert.setHeaderText("Bienvenue " + prenomadmin + " sur votre Espace Admin");
                alert.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin_view.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Espace Admin");
                stage.setScene(scene);
                stage.show();
                break;
            }

        }

        if (statututilisateur == false) {
            // Aucune correspondance trouvée, afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'authentification");
            alert.setHeaderText("Identifiant ou mot de passe incorrect");
            alert.showAndWait();
        }

    }
}








