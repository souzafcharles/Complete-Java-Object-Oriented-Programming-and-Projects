module com.souza.charles.graphicalapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.souza.charles.graphicalapp.controller to javafx.fxml;
    opens com.souza.charles.graphicalapp.view to javafx.fxml;
    opens com.souza.charles.graphicalapp.model.entities to javafx.base;

    exports com.souza.charles.graphicalapp.view;
}
