package com.souza.charles.graphicalapp.controller;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 15, 2025
 */

import com.souza.charles.graphicalapp.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    @FXML
    private Button btAll;

    private ObservableList<Person> observableList;

    @FXML
    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @FXML
    public void onBtAllAction() {
        for (Person person : comboBoxPerson.getItems()) {
            System.out.println(person);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Balthazar de Bigode", "balthazar@email.com"));
        list.add(new Person(2, "Ophelia Birrenta", "ophelia@email.com"));
        list.add(new Person(3, "Theodorico Vitalino", "tehodorico@email.com"));

        observableList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(observableList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };

        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }
}