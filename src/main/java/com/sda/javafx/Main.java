package com.sda.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

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
        AnchorPane person = FXMLLoader.load(getClass().getClassLoader()
                .getResource("PersonOverview.fxml"));
        rootLayout.setCenter(person);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
