package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.TabableView;
import java.io.IOException;


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

    @FXML
    private void deletePerson(){
        int index = personTableView.getSelectionModel().getSelectedIndex();
        if(index>=0) {
            System.out.println(personTableView.getItems().get(index).getFirstname()
            + " " + personTableView.getItems().get(index).getFirstname()
            );
            personTableView.getItems().remove(index);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Blad");
            alert.setHeaderText("To jest error");
            alert.setContentText("Nie mozna usunac");
            alert.showAndWait();
        }
    }

    public void addPerson(ActionEvent actionEvent) throws IOException {
        AnchorPane addPersonLayout = FXMLLoader.load(
                getClass().getClassLoader().getResource("AddPerson.fxml")
        );
        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayout);

        stage.setScene(scene);

        stage.show();
    }

    public void setMain(Main main){
        this.main = main;
        personTableView.setItems(main.getPerson());
    }

}
