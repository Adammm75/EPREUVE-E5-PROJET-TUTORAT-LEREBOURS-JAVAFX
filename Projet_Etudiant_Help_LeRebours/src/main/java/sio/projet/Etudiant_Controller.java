package sio.projet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sio.projet.Entities.*;
import sio.projet.Tools.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Etudiant_Controller implements Initializable {

    public AnchorPane ApCreerDemandes;
    @FXML
    private DatePicker iddatefindemande;
    @FXML
    private AnchorPane apCompetences;
    @FXML
    private AnchorPane apDemande;
    @FXML
    private ComboBox idcomboxmatieres;
    @FXML
    private ComboBox idcomboboxcompetences;
    @FXML
    private TableColumn idsousmatiere;
    @FXML
    private TableColumn idsousmatierecompetences;
    @FXML
    private TableColumn date_updated;
    @FXML
    private TableColumn date_fin_demande;
    @FXML
    private TableColumn sous_matiere;
    @FXML
    private TableColumn sous_matieres;
    @FXML
    private Button BtnDemande;
    @FXML
    private Button BtnCompetence;
    @FXML
    private Button BtnVisualiserAutresDemande;
    @FXML
    private AnchorPane ApVisualiserDemandesAutres;
    @FXML
    private Button BtnStatistiques;
    @FXML
    private AnchorPane ApStastistiques;
    @FXML
    private Button BtnCréationDemandes;
    @FXML
    private AnchorPane ApModifierDemandes;
    @FXML
    private AnchorPane ApVisualiserDemandes;
    @FXML
    private Button BtnVisualiserDemandes;
    @FXML
    private Button BtnModifierDemandes;
    @FXML
    private Button BtnCréerCompétences;
    @FXML
    private AnchorPane ApCreerCompétences;
    @FXML
    private Button BtnCréationCompétences;
    @FXML
    private Button BtnModifierCompetence;
    @FXML
    private AnchorPane ApModifierCompetences;
    @FXML
    private AnchorPane ApVisualiserCompetences;
    @FXML
    private Button BtnVisualiserCompétences;
    @FXML
    private TableView TvSousmatieresDemandes;
    @FXML
    private TableView TvSousmatiereCompetences;
    @FXML
    private TableView TvVisualiserCompetences;
    @FXML
    private TableView ApVisualisationDemandes;
    @FXML
    private TableColumn date_updated1;
    @FXML
    private TableColumn date_fin_demande1;
    @FXML
    private TableColumn sous_matiere1;
    @FXML
    private DatePicker iddatemodifierdemandes;
    @FXML
    private ComboBox idcmbmatieresdemandes;
    @FXML
    private TableColumn tclibelleModifierDemandes;
    @FXML
    private TableView tvModifierDemandes;
    @FXML
    private TableView TvDemandesModifier;
    @FXML
    private Button BtnModificationDemandes;
    @FXML
    private TableView TvCompetencesModifier;
    @FXML
    private TableColumn id1;
    @FXML
    private TableColumn sous_matiere11;
    @FXML
    private ComboBox idcmbmatierescompetences;
    @FXML
    private Button BtnModificationCompetences;
    @FXML
    private TableView tvModifierCompetence;
    @FXML
    private TableColumn tclibelleModifierCompetences;
    @FXML
    private TableColumn iddateupdated;
    @FXML
    private TableColumn iddate_fin_demande;
    @FXML
    private TableColumn idsous_matiere;
    @FXML
    private TableColumn ID;
    @FXML
    private TableColumn ID_user;
    @FXML
    private TableColumn idprenom;
    @FXML
    private TableColumn id_nom;
    @FXML
    private TableColumn idniveau;
    @FXML
    private PieChart graph2;
    @FXML
    private AnchorPane apGraph1;
    @FXML
    private Button Btngraph1;
    @FXML
    private Button Btngraph2;
    @FXML
    private PieChart graph1;
    @FXML
    private AnchorPane apGraph2;

    ServicesMatiere ServicesMatiere;
    ServicesDemandes ServicesDemandes;
    ServicesCompetence ServicesCompetence;
    UtilisateurConnecte UtilisateurConnected;
    ConnexionBDD maCnx;
    ServicesUser ServicesUser;
    ServicesNiveau ServicesNiveau;
    @FXML
    private Button BtnCreerDemandes;

    @FXML
    private Button btnConfirmationDemande;

    @FXML
    private TableColumn tcIdDemande;

    @FXML
    private TableColumn tcIdMatiere;

    @FXML
    private TextArea idDescriptionDemandes;

    @FXML
    private TableView tvDemandeAutres;

    //private AnchorPane ApCreerDemandes;


    @Deprecated
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        TvSousmatieresDemandes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TvSousmatiereCompetences.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tvModifierDemandes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tvModifierCompetence.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ApStastistiques.toFront();

        try {
            maCnx = new ConnexionBDD();

            ServicesMatiere = new ServicesMatiere();

            ApStastistiques.toFront();
            apGraph1.toFront();

            idcomboxmatieres.setItems(ServicesMatiere.AffichageMatières());
            idcomboboxcompetences.setItems(ServicesMatiere.AffichageMatières());
            idcmbmatieresdemandes.setItems(ServicesMatiere.AffichageMatières());
            idcmbmatierescompetences.setItems(ServicesMatiere.AffichageMatières());

            idcmbmatieresdemandes.getSelectionModel().selectFirst();
            idcomboxmatieres.getSelectionModel().selectFirst();
            idcomboboxcompetences.getSelectionModel().selectFirst();
            idcmbmatierescompetences.getSelectionModel().selectFirst();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } catch (SQLException e) {

        }
    }


    @FXML
    public void BtnDemandeClicked(Event event) {
        apDemande.toFront();
    }


    @FXML
    public void BtnVisualiserAutresDemandeClicked(Event event) throws SQLException {
        ApVisualiserDemandesAutres.toFront();
        ServicesDemandes ServicesDemandes = new ServicesDemandes();
        ServicesNiveau servicesNiveau = new ServicesNiveau();
        int idUser= UtilisateurConnected.getConnecteeUserId();
        String niveau=servicesNiveau.RecuperationNiveauUser(idUser);
        tvDemandeAutres.setItems(ServicesDemandes.AffichageAutreDemandes(idUser,niveau));


        iddateupdated.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, LocalDate>("date_updated"));
        iddate_fin_demande.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, String>("date_fin_demande"));
        idsous_matiere.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, String>("sous_matiere"));
        idprenom.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, String>("prenom"));
        id_nom.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, String>("nom"));
        idniveau.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, String>("niveau"));
        tcIdDemande.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, Integer>("id"));
        tcIdMatiere.setCellValueFactory(new PropertyValueFactory<AffichageAutresDemandes, Integer>("id_matiere"));



    }


    @FXML
    public void BtnStatistiquesClicked(Event event) {

        ApStastistiques.toFront();
        GraphiqueController graphiqueController = new GraphiqueController();
        graph1.getData().clear();
        graph2.getData().clear();
        if(event.getSource() == Btngraph1) {

            apGraph1.toFront();
            ObservableList<PieChart.Data> datasGraph2 = FXCollections.observableArrayList();
            HashMap<String, Integer> datasGraphique2 = graphiqueController.GetDatasGraphique1();

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
        if (event.getSource() == Btngraph2){
            apGraph2.toFront();
            ObservableList<PieChart.Data> datasGraph2 = FXCollections.observableArrayList();
            HashMap<String, Integer> datasGraphique2 = graphiqueController.GetDatasGraphique2();

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


    //-----------------------------------------------------------------//
    //------------------------PARTIE DEMANDE---------------------------//
    //-----------------------------------------------------------------//


    @FXML
    public void BtnCreerDemandesClicked(Event event) {
        ApCreerDemandes.toFront();
    }


    @FXML
    public void BtnModifierDemandesClicked(Event event) throws SQLException {

        ApModifierDemandes.toFront();
        ServicesDemandes = new ServicesDemandes();
        ServicesMatiere = new ServicesMatiere();
        int idUser= UtilisateurConnected.getConnecteeUserId();
        TvDemandesModifier.setItems(ServicesDemandes.AffichageDemandes(idUser));



        date_updated1.setCellValueFactory(new PropertyValueFactory<AffichageDemande, LocalDate>("date_updated"));
        date_fin_demande1.setCellValueFactory(new PropertyValueFactory<AffichageDemande, LocalDate>("date_fin_demande"));
        sous_matiere1.setCellValueFactory(new PropertyValueFactory<AffichageDemande, String>("sous_matiere"));
        //id11.setCellValueFactory(new PropertyValueFactory<AffichageDemande, Integer>("id_user"));
    }
    @FXML
    public void BtnVisualiserDemandesClicked(Event event) throws SQLException {
        ApVisualiserDemandes.toFront();

        ServicesDemandes = new ServicesDemandes();
        int idUser= UtilisateurConnected.getConnecteeUserId();
        ApVisualisationDemandes.setItems(ServicesDemandes.AffichageDemandes(idUser));

        date_updated.setCellValueFactory(new PropertyValueFactory<AffichageDemande, LocalDate>("date_updated"));
        date_fin_demande.setCellValueFactory(new PropertyValueFactory<AffichageDemande, LocalDate>("date_fin_demande"));
        sous_matiere.setCellValueFactory(new PropertyValueFactory<AffichageDemande, String>("sous_matiere"));
        //idId.setCellValueFactory(new PropertyValueFactory<AffichageDemande, Integer>("id_user"));
    }


    @FXML
    public void BtnMatiereDemandesClicked(Event event) throws SQLException {
        ServicesMatiere = new ServicesMatiere();
        TvSousmatieresDemandes.setItems(ServicesMatiere.AffichageSousMatières(idcomboxmatieres.getSelectionModel().getSelectedItem().toString()));

        idsousmatiere.setCellValueFactory((new PropertyValueFactory<SousMatiere, String>("libelle")));
    }


    @FXML
    public void BtnCreationDemandesClicked(Event event) throws SQLException {
        LocalDate dateFinDemande = iddatefindemande.getValue();
        LocalDate dateupdated = LocalDate.now();

        if (iddatefindemande.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une Date");
            alert.setContentText("Choisissez une Date");
            alert.showAndWait();
        }

        if (TvSousmatieresDemandes.getSelectionModel().getSelectedItem() == null || idcomboxmatieres.getSelectionModel().getSelectedItem() == null)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une ou plusieurs sous-matières et matière");
            alert.setContentText("Choisissez une sous-matière et une matière");
            alert.showAndWait();
        }

         else if (dateFinDemande.isBefore(dateupdated)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Erreur de la date de fin de demande");
            alert.setContentText("Date de Fin de Demande ne doit pas être inférieure à la date d'aujourd'hui !");
            alert.showAndWait();
        }

        else if (dateFinDemande.isAfter(dateupdated)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Demande créé");
            alert.setContentText("Vous avez bien créé une Demande !");
            alert.showAndWait();

            ServicesDemandes servicesDemandes = new ServicesDemandes();
            ObservableList<SousMatiere> selectedSousMatieres = TvSousmatieresDemandes.getSelectionModel().getSelectedItems();
            StringBuilder sousMatieresConcatenated = new StringBuilder();

            for (SousMatiere sousmatiere : selectedSousMatieres) {
                sousMatieresConcatenated.append("#");
                sousMatieresConcatenated.append(sousmatiere.getLibelle());
            }

            String matiere = ((AffichageMatiere) idcomboxmatieres.getSelectionModel().getSelectedItem()).getDesignation();
            ServicesMatiere servicesMatiere = new ServicesMatiere();
            int id_matiere = servicesMatiere.RécuperationIdmatiere(matiere);

            int status = 1;
            int idUser = UtilisateurConnected.getConnecteeUserId();

            if (dateFinDemande != null && sousMatieresConcatenated.length() > 0) {
                servicesDemandes.CréationDemandes(dateFinDemande, sousMatieresConcatenated.toString(), idUser, dateupdated, id_matiere, status);
            } else {

            }
        }
    }


    //-----------------------------------------------------------------//
    //------------------------PARTIE COMPETENCE------------------------//
    //-----------------------------------------------------------------//


    @FXML
    public void BtnCompetenceClicked(Event event) {
        apCompetences.toFront();
    }


    @FXML
    public void BtnCreerCompetencesClicked(Event event) {
        ApCreerCompétences.toFront();
    }


    @FXML
    public void BtnModifierCompetenceClicked(Event event) throws SQLException {

        ApModifierCompetences.toFront();
        ServicesMatiere = new ServicesMatiere();
        ServicesCompetence = new ServicesCompetence();

        idcmbmatierescompetences.setItems(ServicesMatiere.AffichageMatières());

        int idUser= UtilisateurConnected.getConnecteeUserId();
        TvCompetencesModifier.setItems(ServicesCompetence.VisualiserCompétences(idUser));

        sous_matiere11.setCellValueFactory(new PropertyValueFactory<AffichageCompetence, String>("sous_matieres"));
        id1.setCellValueFactory(new PropertyValueFactory<AffichageCompetence, Integer>("id"));
        ID_user.setCellValueFactory(new PropertyValueFactory<AffichageCompetence, Integer>("id_user"));
    }


    @FXML
    public void BtnVisualiserCompetencesClicked(Event event) throws SQLException {

        ApVisualiserCompetences.toFront();
        ServicesCompetence = new ServicesCompetence();

        int idUser= UtilisateurConnected.getConnecteeUserId();
        TvVisualiserCompetences.setItems(ServicesCompetence.VisualiserCompétences(idUser));

        sous_matieres.setCellValueFactory(new PropertyValueFactory<AffichageDemande,String>("sous_matieres"));

        ID.setCellValueFactory(new PropertyValueFactory<AffichageDemande,Integer>("id"));
        //Id_user.setCellValueFactory(new PropertyValueFactory<AffichageDemande,Integer>("id_user"));
    }


    @FXML
    public void BtnCreationCompetencesClicked(Event event) throws SQLException {

        if (TvSousmatiereCompetences.getSelectionModel().getSelectedItem() == null || idcmbmatieresdemandes.getSelectionModel().getSelectedItem() == null)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une ou plusieurs sous-matières et matière");
            alert.setContentText("Choisissez une sous-matière et une matière");
            alert.showAndWait();
        }

        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Compétence créée !");
            alert.setContentText("Vous avez bien créé une Compétence !");
            alert.showAndWait();

            ServicesCompetence servicescompetence = new ServicesCompetence();

            ObservableList<SousMatiere> selectedSousMatieres = TvSousmatiereCompetences.getSelectionModel().getSelectedItems();

            StringBuilder sousMatieresConcatenated = new StringBuilder();



            for (SousMatiere sousmatiere : selectedSousMatieres) {
                sousMatieresConcatenated.append("#");
                sousMatieresConcatenated.append(sousmatiere.getLibelle());
            }



            ServicesMatiere servicesMatiere = new ServicesMatiere();
            String matiere = ((AffichageMatiere) idcomboboxcompetences.getSelectionModel().getSelectedItem()).getDesignation();
            int id_matiere = servicesMatiere.RécuperationIdmatiere(matiere);
            int statut = 3;
            int id = UtilisateurConnected.getConnecteeUserId();

            servicescompetence.CréationCompétences(id_matiere, id, sousMatieresConcatenated.toString(), statut);
        }
    }


    @FXML
    public void BtnMatieresDemandesClicked(Event event) throws SQLException {

        ServicesMatiere = new ServicesMatiere();

        TvSousmatieresDemandes.setItems(ServicesMatiere.AffichageSousMatières(idcomboxmatieres.getSelectionModel().getSelectedItem().toString()));

        idsousmatiere.setCellValueFactory((new PropertyValueFactory<SousMatiere, String>("libelle")));

        tclibelleModifierDemandes.setCellValueFactory((new PropertyValueFactory<SousMatiere, String>("libelle")));
        tvModifierDemandes.setItems(ServicesMatiere.AffichageSousMatières(idcmbmatieresdemandes.getSelectionModel().getSelectedItem().toString()));
    }

    @FXML
    public void BtnAffichageDemandeModifierClicked(Event event) throws SQLException {
        ServicesDemandes = new ServicesDemandes();

        int idDemande = ((AffichageDemande) TvDemandesModifier.getSelectionModel().getSelectedItem()).getId();

        iddatemodifierdemandes.setValue(ServicesDemandes.AffichageDemandesModifier(idDemande));
    }


    @FXML
    public void BtnModificationDemandesClicked(Event event) throws SQLException {

        ServicesMatiere = new ServicesMatiere();
        ServicesDemandes = new ServicesDemandes();
        LocalDate dateFinDemande = iddatemodifierdemandes.getValue();
        LocalDate dateupdated = LocalDate.now();
        if (tvModifierDemandes.getSelectionModel().getSelectedItem() == null || idcmbmatieresdemandes.getSelectionModel().getSelectedItem() == null)  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une ou plusieurs sous-matières et matière");
            alert.setContentText("Choisissez une sous-matière et une matière");
            alert.showAndWait();
        }

        else if (TvDemandesModifier.getSelectionModel().getSelectedItem() == null )  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une sous-matiere");
            alert.setContentText("Choisissez une sous-matiere");
            alert.showAndWait();
        }
        else if (dateFinDemande.isBefore(dateupdated)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Erreur de la date de fin de demande");
            alert.setContentText("Date de Fin de Demande ne doit pas être inférieure à la date d'aujourd'hui !");
            alert.showAndWait();
        }

        else {
            int idDemande = ((AffichageDemande) TvDemandesModifier.getSelectionModel().getSelectedItem()).getId();
            String matiere = ((AffichageMatiere) idcomboxmatieres.getSelectionModel().getSelectedItem()).getDesignation();
            int id_matiere = ServicesMatiere.RécuperationIdmatiere(matiere);
            int status = 1;
            ObservableList<SousMatiere> selectedSousMatieres = tvModifierDemandes.getSelectionModel().getSelectedItems();
            StringBuilder sousMatieresConcatenated = new StringBuilder();

            for (SousMatiere sousmatiere : selectedSousMatieres) {
                sousMatieresConcatenated.append("#");
                sousMatieresConcatenated.append(sousmatiere.getLibelle());
            }

            ServicesDemandes.ModificationDemandes(dateFinDemande, sousMatieresConcatenated.toString(), dateupdated, idDemande, id_matiere, status, idDemande);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Demande Modifiée");
            alert.setContentText("Vous avez bien Modifiée la demande !");
            alert.showAndWait();
        }
    }


    @FXML
    public void BtnModificationCompetencesClicked(Event event) throws SQLException {
        ServicesCompetence = new ServicesCompetence();
        ServicesMatiere = new ServicesMatiere();
        idcmbmatierescompetences.getSelectionModel().selectFirst();

        if (TvCompetencesModifier.getSelectionModel().getSelectedItem() == null)  {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une compétence");
            alert.setContentText("Choisissez une compétence");
            alert.showAndWait();
        } else if (tvModifierCompetence.getSelectionModel().getSelectedItem() == null || idcmbmatierescompetences.getSelectionModel().getSelectedItem() == null  )  {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur !");
            alert.setHeaderText("Il faut choisir une ou plusieurs sous-matières et matière");
            alert.setContentText("Choisissez une sous-matière et une matière");
            alert.showAndWait();
        }

        else {
            int id = ((AffichageCompetence) TvCompetencesModifier.getSelectionModel().getSelectedItem()).getId();

            String matiere = ((AffichageMatiere) idcomboxmatieres.getSelectionModel().getSelectedItem()).getDesignation();
            int id_matiere = ServicesMatiere.RécuperationIdmatiere(matiere);
            int status = 1;

            int user = UtilisateurConnected.getConnecteeUserId();

            ObservableList<SousMatiere> selectedSousMatieres = tvModifierCompetence.getSelectionModel().getSelectedItems();

            StringBuilder sousMatieresConcatenated = new StringBuilder();

            for (SousMatiere sousmatiere : selectedSousMatieres) {

                    sousMatieresConcatenated.append("#");
                    sousMatieresConcatenated.append(sousmatiere.getLibelle());


            }

            ServicesCompetence.ModificationCompetences(id, sousMatieresConcatenated.toString(), status, user, id_matiere);
            TvCompetencesModifier.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informations");
            alert.setHeaderText("Compétence Modifié");
            alert.setContentText("Vous avez bien Modifié la compétence !");
            alert.showAndWait();
        }
    }


    @Deprecated
    public void BtnMatieresModifierCompetencesClicked(ActionEvent actionEvent) throws SQLException {

        ServicesMatiere = new ServicesMatiere();
        Object selectedItem = idcmbmatierescompetences.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            tvModifierCompetence.setItems(ServicesMatiere.AffichageSousMatières(selectedItem.toString()));
            tclibelleModifierCompetences.setCellValueFactory(new PropertyValueFactory<SousMatiere, String>("libelle"));
        } else {
            // à faire
        }
    }


    @FXML
    public void BtnMatiereCompetencesClicked(ActionEvent actionEvent) throws SQLException {

        ServicesMatiere = new ServicesMatiere();
        TvSousmatiereCompetences.setItems(ServicesMatiere.AffichageSousMatières(idcomboboxcompetences.getSelectionModel().getSelectedItem().toString()));

        idsousmatierecompetences.setCellValueFactory((new PropertyValueFactory<SousMatiere, String>("libelle")));
    }


    @FXML
    public void btnConfirmationDemandeClicked(Event event) throws SQLException {


        int user = UtilisateurConnected.getConnecteeUserId();
        ServicesCompetence = new ServicesCompetence();
        ServicesSoutiens servicesSoutiens = new ServicesSoutiens();
        AffichageAutresDemandes demandeSelectionnee = (AffichageAutresDemandes) tvDemandeAutres.getSelectionModel().getSelectedItem();

        if (tvDemandeAutres.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Vous n'avez pas sélectionner de Demande");
            alert.showAndWait();

        } else if (idDescriptionDemandes.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Vous n'avez pas inscrit de Description !");
            alert.showAndWait();

        }


         else {
            String sousmatiere = demandeSelectionnee.getSous_matiere();
            int idDemande = demandeSelectionnee.getId();
            int idMatiereDemande = demandeSelectionnee.getId_matiere();
            int idcompetenceuser = ServicesCompetence.VerifIdMatiere(user, idMatiereDemande, sousmatiere);
            if (idcompetenceuser == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur Demande");
                alert.setContentText("Vous n'avez pas acquise cette compétence !");
                alert.showAndWait();
            } else {

                int idCompetence = idcompetenceuser;
                Integer idSalle = 0;
                LocalDate date_fin_demande = demandeSelectionnee.getDate_fin_demande();
                LocalDate date_updated = demandeSelectionnee.getDate_updated();
                String Description = idDescriptionDemandes.getText();
                int status = 0;
                servicesSoutiens.CréationSoutien(idDemande, idCompetence, idSalle, date_updated, date_fin_demande, Description, status);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bravo");
                alert.setHeaderText("Bien joué");
                alert.setContentText("Vous avez répondu à une demande, un soutien en attente est crée !");
                alert.showAndWait();
            }
        }
        }


}
