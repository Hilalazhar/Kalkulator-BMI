package com.mycompany.kalkulatorbmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class BmiViewController {

    @FXML
    private TextField inputBerat; 
    @FXML
    private TextField inputTinggi; 
    @FXML
    private Label labelHasil; 
    
    @FXML
    private Polygon jarumIndikator; 

    @FXML
    private void hitungBMIAction(ActionEvent event) { 
        try {
            double berat = Double.parseDouble(inputBerat.getText());
            double tinggi = Double.parseDouble(inputTinggi.getText()) / 100;
            double bmi = berat / (tinggi * tinggi);
            
            String kategori;
            if (bmi < 18.5) kategori = "Kekurangan Berat Badan";
            else if (bmi < 25) kategori = "Normal";
            else if (bmi < 30) kategori = "Kelebihan Berat Badan";
            else kategori = "Obesitas";
            
            labelHasil.setText(String.format("Skor BMI: %.1f (%s)", bmi, kategori));

            double bmiDibatasi = Math.max(16, Math.min(bmi, 40)); 
            double sudut = (bmiDibatasi - 16) * 7.5 - 90; 

            double porosX = jarumIndikator.getBoundsInLocal().getCenterX();
            double porosY = jarumIndikator.getBoundsInLocal().getMaxY();

            Rotate rotasi = new Rotate(sudut, porosX, porosY);
            jarumIndikator.getTransforms().clear();
            jarumIndikator.getTransforms().add(rotasi);
            
        } catch (NumberFormatException e) {
            labelHasil.setText("Error: Masukkan angka yang valid!");
        }
    }
    @FXML
    private void handleReset(ActionEvent event) {
      
        inputBerat.clear();
        inputTinggi.clear();
       
        labelHasil.setText("");
              
        double porosX = jarumIndikator.getBoundsInLocal().getCenterX();
        double porosY = jarumIndikator.getBoundsInLocal().getMaxY();
        
        Rotate rotasi = new Rotate(0, porosX, porosY);
        jarumIndikator.getTransforms().clear();
        jarumIndikator.getTransforms().add(rotasi);
    }
}