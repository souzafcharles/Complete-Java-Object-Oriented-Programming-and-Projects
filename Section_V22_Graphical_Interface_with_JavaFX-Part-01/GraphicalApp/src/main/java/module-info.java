module com.souza.charles.graphicalapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.souza.charles.graphicalapp.view to javafx.fxml;

    exports com.souza.charles.graphicalapp.view;
}