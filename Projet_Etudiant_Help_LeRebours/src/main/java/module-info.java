module sio.projet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sio.projet.Tools to javafx.base;
    opens sio.projet to javafx.fxml;
    exports sio.projet;
    opens sio.projet.Entities to javafx.base;

}