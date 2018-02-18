package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddPersonController {

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


    private Main main;

    @FXML
    private void addPerson(){
        main.getPerson().add(new Person(firstname.getText(),
                lastname.getText()));

        System.out.println(firstname.getText());
    }

    public void setMain(Main main){
        this.main = main;
    }


}
