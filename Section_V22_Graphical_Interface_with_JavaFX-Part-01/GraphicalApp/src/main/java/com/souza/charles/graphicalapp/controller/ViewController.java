package com.souza.charles.graphicalapp.controller;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 14, 2025
 */

import com.souza.charles.graphicalapp.view.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button btTest;

    @FXML
    private void onBtTestAction() {
        Alerts.showAlert("System Notification", "Scheduled Maintenance",
                "We apologize for any inconvenience.",
                Alert.AlertType.INFORMATION);
    }

}
