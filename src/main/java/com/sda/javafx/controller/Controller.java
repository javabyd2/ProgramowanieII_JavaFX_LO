package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.text.TabableView;


public class Controller {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> firstnameColumn;

    @FXML
    private TableColumn<Person, String> lastnameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    //referencja klasy main
    private Main main;


    public Controller() {
    }


    @FXML
    private void initialize(){
        firstnameColumn.setCellValueFactory(
              data -> data.getValue().firstnameProperty()
        );
        lastnameColumn.setCellValueFactory(
                data -> data.getValue().lastnameProperty()
        );

        personTableView.getSelectionModel()
                .selectedItemProperty()
                .addListener( (observable, x, y)
                        -> showPerson(y)
                );

    }

    public void showPerson(Person person){
        firstNameLabel.setText(person.getFirstname());
        postalCodeLabel.setText(person.getPostalcode());
        streetLabel.setText(person.getStreet());

        System.out.println(person.getFirstname());
        System.out.println("KLIKAM!!");
    }


    public void setMain(Main main){
        this.main = main;
        personTableView.setItems(main.getPerson());
    }

}
