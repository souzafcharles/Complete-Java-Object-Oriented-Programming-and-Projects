package com.souza.charles.graphicalapp.controller;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 19, 2025
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("01");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        System.out.println("02");
    }

    @FXML
    public void onMenuItemAboutAction() {
        System.out.println("03");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}