package com.sda.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddPerson {

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField postalcode;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField birthday;

    @FXML
    private void addPerson(){
        System.out.println(firstname.getText());
    }

}
