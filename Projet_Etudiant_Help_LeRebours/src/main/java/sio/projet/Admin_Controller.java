package sio.projet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sio.projet.Entities.*;
import sio.projet.Tools.*;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Admin_Controller implements Initializable {
    @javafx.fxml.FXML
    private Button BtnMatieres;
    @javafx.fxml.FXML
    private Button BtnSalles;
    @javafx.fxml.FXML
    private Button btnSoutiens;
    @javafx.fxml.FXML
    private Button BtnStatistiques;
    @javafx.fxml.FXML
    private AnchorPane apMatiere;
    @javafx.fxml.FXML
    private Button BtnCreerMatiere;
    @javafx.fxml.FXML
    private Button BtnCréationDemandes;
    @javafx.fxml.FXML
    private TextField txtCreerNomMatiere;
    @javafx.fxml.FXML
    private TableColumn tcModifNomMatière;
    @javafx.fxml.FXML
    private TableColumn tcModifSousMatiere;
    @javafx.fxml.FXML
    private Button BtnModifMatiere;
    @javafx.fxml.FXML
    private TableColumn tcNomMatiere;
    @javafx.fxml.FXML
    private TableColumn tcSousMatiere;
    @javafx.fxml.FXML
    private Button BtnModifierMatiere;
    @javafx.fxml.FXML
    private Button BtnVisualiserMatiere;
    @javafx.fxml.FXML
    private AnchorPane apSalles;
    @javafx.fxml.FXML
    private Button BtnModifierSalle;
    @javafx.fxml.FXML
    private AnchorPane apSoutien;
    @javafx.fxml.FXML
    private AnchorPane apGraph1;
    @javafx.fxml.FXML
    private PieChart graph1;
    @javafx.fxml.FXML
    private AnchorPane apStastistiques;
    @javafx.fxml.FXML
    private AnchorPane apCreerMatiere;
    @javafx.fxml.FXML
    private AnchorPane apModifierMatiere;
    @javafx.fxml.FXML
    private AnchorPane apVisualiserMatiere;
    @javafx.fxml.FXML
    private AnchorPane apCreerSalle;
    @javafx.fxml.FXML
    private AnchorPane apModifierSalle;
    @javafx.fxml.FXML
    private Button BtnCréationSalle;
    @javafx.fxml.FXML
    private Button BtnModificationSalle;
    @javafx.fxml.FXML
    private ComboBox cboEtage;
    @javafx.fxml.FXML
    private TextField txtNumCreationSalle;
    ServicesMatiere servicesMatiere;
    ServicesSalle servicesSalle;
    @javafx.fxml.FXML
    private TableView tvModifMatiere;
    @javafx.fxml.FXML
    private TableColumn tcModifIdMatiere;
    @javafx.fxml.FXML
    private TextField txtModifNomMatiere;
    @javafx.fxml.FXML
    private TextField txtModifSousMatiere;
    @javafx.fxml.FXML
    private TableView tvVisualiserMatiere;
    @javafx.fxml.FXML
    private TableColumn tcIdMatiere;
    @javafx.fxml.FXML
    private Button BtnCreerSalle;
    @javafx.fxml.FXML
    private TableView tvModifSalle;
    @javafx.fxml.FXML
    private TableColumn tcIdModifSalle;
    @javafx.fxml.FXML
    private TableColumn tcEtageModifSalle;
    @javafx.fxml.FXML
    private TableColumn tcNumSalleModifSalle;
    @javafx.fxml.FXML
    private ComboBox cboModifEtage;
    @javafx.fxml.FXML
    private TextField txtNumModifSalle;

    ConnexionBDD maCnx;
    ServicesSoutiens ServicesSoutiens;
    ServicesSalle ServicesSalle;

    ServicesEtages ServicesEtages;
    @javafx.fxml.FXML
    private TextField txtCreerSousMatiere;
    @javafx.fxml.FXML
    private AnchorPane apGraph5;
    @javafx.fxml.FXML
    private Button Btngraph3;
    @javafx.fxml.FXML
    private Button Btngraph4;
    @javafx.fxml.FXML
    private AnchorPane apGraph6;
    @javafx.fxml.FXML
    private PieChart graph2;
    @javafx.fxml.FXML
    private TableView tvSoutiens;
    @javafx.fxml.FXML
    private TableColumn tcSalle;
    @javafx.fxml.FXML
    private TableColumn tcDescription;
    @javafx.fxml.FXML
    private TableColumn tcStatus;
    @javafx.fxml.FXML
    private ComboBox cmbBoxSalle;
    @javafx.fxml.FXML
    private TableColumn tcNomEtudiant;
    @javafx.fxml.FXML
    private TableColumn tcNomTuteur;
    @javafx.fxml.FXML
    private TableColumn tcDateFinDeDemande;
    @javafx.fxml.FXML
    private TableColumn tcDateUpdated;
    @javafx.fxml.FXML
    private Button btnAffectationSalle;
    @javafx.fxml.FXML
    private TableColumn tcIdSoutien;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try {
            maCnx = new ConnexionBDD();


            apGraph1.toFront();
            servicesMatiere = new ServicesMatiere();
            servicesSalle = new ServicesSalle();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } catch (SQLException e) {

        }

    }




////////////////////////////////////////////////////////////////////////////////////////////
                                        // MENU //
///////////////////////////////////////////////////////////////////////////////////////////
    @javafx.fxml.FXML
    public void BtnMatieresClicked(Event event) {
        apMatiere.toFront();
    }
    @javafx.fxml.FXML
    public void BtnSallesClicked(Event event) {
        apSalles.toFront();
    }
    @javafx.fxml.FXML
    public void BtnSoutiensClicked(Event event) throws SQLException {
        apSoutien.toFront();
        ServicesSoutiens servicesSoutiens1 = new ServicesSoutiens();
        ServicesSalle servicesSalle1 = new ServicesSalle();
        cmbBoxSalle.setItems(servicesSalle1.AffichageSalle());

       tvSoutiens.setItems(servicesSoutiens1.AffichageSoutiens());

        tcIdSoutien.setCellValueFactory(new PropertyValueFactory<Soutien, Integer>("id"));
        tcNomTuteur.setCellValueFactory(new PropertyValueFactory<Soutien, String>("prenom_tuteur"));
        tcNomEtudiant.setCellValueFactory(new PropertyValueFactory<Soutien, String>("prenom_demandeur"));
        tcSalle.setCellValueFactory(new PropertyValueFactory<Soutien, Integer>("id_salle"));
        tcDateFinDeDemande.setCellValueFactory(new PropertyValueFactory<Soutien, LocalDate>("date_du_soutien"));
        tcDateUpdated.setCellValueFactory(new PropertyValueFactory<Soutien, LocalDate>("date_updated"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<Soutien, String>("description"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<Soutien, String>("status"));


    }
    @javafx.fxml.FXML
    public void BtnStatistiquesClicked(Event event) {

        apStastistiques.toFront();
        GraphiqueController2 graphiqueController1 = new GraphiqueController2();
        graph1.getData().clear();
        if(event.getSource() == Btngraph3) {

            apGraph5.toFront();
            ObservableList<PieChart.Data> datasGraph2 = FXCollections.observableArrayList();
            HashMap<String, Integer> datasGraphique2 = graphiqueController1.GetDatasGraphique1();

            for (String valeur : datasGraphique2.keySet()) {
                datasGraph2.add(new PieChart.Data(valeur, datasGraphique2.get(valeur)));
            }
            graph1.setData(datasGraph2);

            for (PieChart.Data entry : graph1.getData()) {
                Tooltip t = new Tooltip(entry.getPieValue() + " : " + entry.getName());
                t.setStyle("-fx-background-color:#3D9ADA");
                Tooltip.install(entry.getNode(), t);
            }

        }
        graph2.getData().clear();
        if(event.getSource() == Btngraph4) {

            apGraph6.toFront();
            ObservableList<PieChart.Data> datasGraph2 = FXCollections.observableArrayList();
            HashMap<String, Integer> datasGraphique2 = graphiqueController1.GetDatasGraphique2();

            for (String valeur : datasGraphique2.keySet()) {
                datasGraph2.add(new PieChart.Data(valeur, datasGraphique2.get(valeur)));
            }
            graph2.setData(datasGraph2);

            for (PieChart.Data entry : graph2.getData()) {
                Tooltip t = new Tooltip(entry.getPieValue() + " : " + entry.getName());
                t.setStyle("-fx-background-color:#3D9ADA");
                Tooltip.install(entry.getNode(), t);
            }

        }
    }

////////////////////////////////////////////////////////////////////////////////////////////
                                // MENU MATIERE//
///////////////////////////////////////////////////////////////////////////////////////////
    @javafx.fxml.FXML
    public void BtnAccCreerMatiereClicked(Event event) {
        apCreerMatiere.toFront();
    }
    @javafx.fxml.FXML
    public void BtnAccModifierMatiereClicked(Event event) throws SQLException {
        apModifierMatiere.toFront();
        tcModifIdMatiere.setCellValueFactory(new PropertyValueFactory<VraieMatiere, Integer>("idMatiere"));
        tcModifNomMatière.setCellValueFactory(new PropertyValueFactory<VraieMatiere,String>("nomMatiere"));
        tcModifSousMatiere.setCellValueFactory(new PropertyValueFactory<VraieMatiere,String>("sousMatiere"));


        tvModifMatiere.setItems(servicesMatiere.AffichageVraieMatiere());

    }
    @javafx.fxml.FXML
    public void BtnAccVisualiserMatiereClicked(Event event) throws SQLException {
        apVisualiserMatiere.toFront();

        tcIdMatiere.setCellValueFactory(new PropertyValueFactory<VraieMatiere, Integer>("idMatiere"));
        tcNomMatiere.setCellValueFactory(new PropertyValueFactory<VraieMatiere,String>("nomMatiere"));
        tcSousMatiere.setCellValueFactory(new PropertyValueFactory<VraieMatiere,String>("sousMatiere"));

        tvVisualiserMatiere.setItems(servicesMatiere.AffichageVraieMatiere());

//        String nom = ((VraieMatiere) tvModifMatiere.getSelectionModel().getSelectedItem()).getNomMatiere();
//        txtModifNomMatiere.setText(nom);
//
//        String SM = ((VraieMatiere) tvModifMatiere.getSelectionModel().getSelectedItem()).getSousMatiere();
//        txtModifNomMatiere.setText(SM);
    }
///////////////////////////////////////////////////////////////////////////////////////////
                                    // MENU SALLE//
///////////////////////////////////////////////////////////////////////////////////////////
    @javafx.fxml.FXML
    public void BtnAccCreerSalleClicked(Event event) throws SQLException {
        apCreerSalle.toFront();
        ServicesEtages servicesEtages = new ServicesEtages();
        cboEtage.setItems(servicesEtages.AffichageEtages());



     /*   ServicesEtages = new ServicesEtages();

        ObservableList<Etage> LesEtages = ServicesEtages.AffichageEtages();
        cboEtage.getItems().clear();

        for (Etage etage : LesEtages) {
            cboEtage.getItems().add(etage);
        }
*/
    }
    @javafx.fxml.FXML
    public void BtnAccModifierSalleClicked(Event event) throws SQLException {
        apModifierSalle.toFront();
        ServicesEtages servicesEtages = new ServicesEtages();
        cboModifEtage.setItems(servicesEtages.AffichageEtages());
      /* ObservableList<Etage> LesEtages = ServicesEtages.AffichageEtages();
        cboModifEtage.getItems().clear();

        for (Etage etage : LesEtages) {
            cboModifEtage.getItems().add(etage);
        }


*/

        tcIdModifSalle.setCellValueFactory(new PropertyValueFactory<Salle,Integer>("idSalle"));
        tcNumSalleModifSalle.setCellValueFactory(new PropertyValueFactory<Salle,String>("code_salle"));
        tcEtageModifSalle.setCellValueFactory(new PropertyValueFactory<Salle,Integer>("etage"));

        tvModifSalle.setItems(servicesSalle.AffichageSalles());
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
                                           // SALLE //
    ///////////////////////////////////////////////////////////////////////////////////////////
    @javafx.fxml.FXML
    public void BtnCreationSalleClicked(Event event) throws SQLException {
        String numSalle = txtNumCreationSalle.getText();
        String chiffres = numSalle.replaceAll("\\D", "");

        if (!numSalle.matches("^Salle\\s\\d{3}$")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire le bon format de numéro de Salle");
            alert.showAndWait();

        }
        else {
            char premierChiffre = chiffres.charAt(0);
            String Etage = cboEtage.getSelectionModel().getSelectedItem().toString();
            char premierChiffreComboBox = Etage.charAt(0);


            if (cboEtage.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Vous devez inscrire l'Etage d'une Salle");
                alert.showAndWait();
            } else if (numSalle.isEmpty() == true) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Vous devez inscrire le Code d'une Salle");
                alert.showAndWait();
            } else if (premierChiffre != premierChiffreComboBox) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Le numéro de la salle doit être lié à l'étage.");
                alert.showAndWait();

            } else {

                int numEtage = Integer.valueOf(cboEtage.getSelectionModel().getSelectedItem().toString());

                // Recherche de la dernière occurrence de l'espace
                int dernierEspaceIndex = numSalle.lastIndexOf(" ");
                // Extrait la sous-chaîne à partir de l'indice après le dernier espace
                String numeroSalleTexte = numSalle.substring(dernierEspaceIndex + 1);
                // Convertit la sous-chaîne en entier
                int idSalle = Integer.parseInt(numeroSalleTexte);

                ServicesSalle servicesSalle = new ServicesSalle();

                servicesSalle.CreationSalle(idSalle, numSalle, numEtage);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Création Réussie");
                alert.setHeaderText("Salle créée !");
                alert.setContentText("Vous avez bien créé une Salle !");
                alert.showAndWait();

            }
        }




        }



    @javafx.fxml.FXML
    public void BtnModificationSalleClicked(Event event) throws SQLException {

        String numSalle = txtNumModifSalle.getText();

        if (!numSalle.matches("^Salle\\s\\d{3}$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire le bon format de numéro de Salle");
            alert.showAndWait();
        }
        else {

            String chiffres = numSalle.replaceAll("\\D", "");
            char premierChiffre = chiffres.charAt(0);
            String Etage = cboModifEtage.getSelectionModel().getSelectedItem().toString();
            char premierChiffreComboBox = Etage.charAt(0);

            if (tvModifSalle.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur !");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Choisissez une Salle");
                alert.showAndWait();
            } else if (cboModifEtage.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur !");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Choisissez l'Etage à Modifier");
                alert.showAndWait();
            } else if (premierChiffre != premierChiffreComboBox) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Le numéro de la salle doit être lié à l'étage.");
                alert.showAndWait();

            } else if (numSalle.isEmpty() == true) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Vous devez inscrire le Code d'une Salle");
                alert.showAndWait();
            } else {

                int idMatiere = ((Salle) tvModifSalle.getSelectionModel().getSelectedItem()).getIdSalle();

                int numEtage = Integer.valueOf(cboModifEtage.getSelectionModel().getSelectedItem().toString());

                // Recherche de la dernière occurrence de l'espace
                int dernierEspaceIndex = numSalle.lastIndexOf(" ");
                // Extrait la sous-chaîne à partir de l'indice après le dernier espace
                String numeroSalleTexte = numSalle.substring(dernierEspaceIndex + 1);
                // Convertit la sous-chaîne en entier
                int nvIdMatiere = Integer.parseInt(numeroSalleTexte);

                servicesSalle.ModificationSalle(idMatiere, nvIdMatiere, numSalle, numEtage);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Salle Modifiée !");
                alert.setContentText("Vous avez bien modifiée une Salle !");
                alert.showAndWait();

            }
        }


    }

    ///////////////////////////////////////////////////////////////////////////////////////////
                                            // MATIERE //
    ///////////////////////////////////////////////////////////////////////////////////////////
    @javafx.fxml.FXML
    public void BtnCreationMatiereClicked(Event event) throws SQLException {
        String nomMatiere = txtCreerNomMatiere.getText();
        String sousMatiere = txtCreerSousMatiere.getText();

        int code = 0;

        if (nomMatiere.isEmpty() == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire une Matière");
            alert.showAndWait();

        }

        else if (sousMatiere.isEmpty() == true) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire une Sous-Matière");
            alert.showAndWait();
        }



        else if (sousMatiere.matches("^[a-zA-Z]+#[a-zA-Z]+#[a-zA-Z]+$")) {
            if (nomMatiere.matches("^[a-zA-Z\\\\]*$")) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Matiere créée !");
                alert.setContentText("Vous avez bien créé une Matiere !");
                alert.showAndWait();

                servicesMatiere.AjoutMatiere(nomMatiere, code, sousMatiere);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Vous devez inscrire le bon format d'une Matière");
                alert.showAndWait();

            }
        }
        else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire le bon format des Sous-Matières");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void BtnModifMatiereClicked(Event event) throws SQLException {

        String nomMatiere = txtModifNomMatiere.getText();
        String sousMatiere = txtModifSousMatiere.getText();

        if (tvModifMatiere.getSelectionModel().getSelectedItem() == null)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une matière");
            alert.setContentText("Choisissez une matière");
            alert.showAndWait();
        }
        else if (nomMatiere.isEmpty() == true) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire une Matière");
            alert.showAndWait();
        }
        else if (sousMatiere.isEmpty() == true) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire une ou plusieurs sous Matières");
            alert.showAndWait();
        }

        else if (sousMatiere.matches("^[a-zA-Z]+#[a-zA-Z]+#[a-zA-Z]+$")) {
            if (nomMatiere.matches("^[a-zA-Z\\\\]*$")) {

                int idMatiere = ((VraieMatiere) tvModifMatiere.getSelectionModel().getSelectedItem()).getIdMatiere();


                servicesMatiere.modifierMatiere(idMatiere, nomMatiere, sousMatiere);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Matiere Modifiée");
                alert.setContentText("Vous avez bien Modifiée la Matiere !");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur de Saisie");
                alert.setContentText("Vous devez inscrire le bon format d'une Matière");
                alert.showAndWait();

            }
        }
        else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de Saisie");
            alert.setContentText("Vous devez inscrire le bon format des Sous-Matières");
            alert.showAndWait();
        }
    }



    @javafx.fxml.FXML
    public void BtnAffichageDemandeModifierClicked(Event event) {
    }



    @javafx.fxml.FXML
    public void BtnMatieresModifierCompetencesClicked(ActionEvent actionEvent) {
    }



    @javafx.fxml.FXML
    public void btnCreationSalleEtageClicked(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void btnAffectationSalleClicked(Event event) throws SQLException {

        if (tvSoutiens.getSelectionModel().getSelectedItem() == null)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir un soutien");
            alert.setContentText("Choisissez un soutien");
            alert.showAndWait();
        }
        else if (cmbBoxSalle.getSelectionModel().getSelectedItem() == null)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une Salle à affecter à un Soutien");
            alert.setContentText("Choisissez une Salle");
            alert.showAndWait();
        }
        else {
            int num_salle = Integer.parseInt(cmbBoxSalle.getSelectionModel().getSelectedItem().toString());
            Soutien SoutienSelected = (Soutien) tvSoutiens.getSelectionModel().getSelectedItem();
            int idSoutien = SoutienSelected.getId();
            ServicesSoutiens servicesSoutiens = new ServicesSoutiens();
            servicesSoutiens.AffectationSoutien(idSoutien,num_salle);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bravo !");
            alert.setHeaderText("Affectation Réussie");
            alert.setContentText("Soutien Validé");
            alert.showAndWait();

            tvSoutiens.refresh();



        }

    }
}
