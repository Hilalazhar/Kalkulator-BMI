package com.mycompany.kalkulatorbmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KalkulatorBMI extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Memuat file desain UI
        Parent root = FXMLLoader.load(getClass().getResource("BmiView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Kalkulator BMI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}