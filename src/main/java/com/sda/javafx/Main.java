package com.sda.javafx;

import com.sda.javafx.controller.MainController;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personObservableList =
            FXCollections.observableArrayList();

//    static {
//
//    }

    public Main(){

        Person p1 = new Person("Marcin", "Kowalski");
        p1.setCity("Torun");
        p1.setStreet("Długa");
        p1.setPostalcode("21-110");

        personObservableList.add(p1);
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));
        personObservableList.add(new Person("Jan", "Kowalski"));

    }

    public ObservableList getPerson(){
        return personObservableList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonLayout();
    }

    public void initRootLayout() throws IOException{
        rootLayout = FXMLLoader.load(getClass().getClassLoader()
                .getResource("RootLayout.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showPersonLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                (getClass().getClassLoader()
                .getResource("PersonOverview.fxml")));

        AnchorPane person = loader.load();
        rootLayout.setCenter(person);


        MainController controller = loader.getController();
        controller.setMain(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
