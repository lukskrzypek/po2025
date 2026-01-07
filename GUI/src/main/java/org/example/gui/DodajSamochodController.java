package org.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.*;


public class DodajSamochodController {

    @FXML private TextField modelTextField;
    @FXML private TextField registrationTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;
    @FXML private ComboBox<Silnik> engineComboBox;
    @FXML private ComboBox<SkrzyniaBiegow> gearboxComboBox;
    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    @FXML
    public void initialize() {

        ObservableList<Silnik> silniki = FXCollections.observableArrayList(
                new Silnik("V8", 220, 12000, 7000),
                new Silnik("1.9 TDI", 180, 5000, 4500),
                new Silnik("Elektryk", 120, 15000, 12000)
        );

        Sprzeglo sprzegloStandard = new Sprzeglo("Standard", 5, 500);
        Sprzeglo sprzegloSport = new Sprzeglo("Sportowe", 3, 1200);
        Sprzeglo sprzegloStandard2 = new Sprzeglo("Standard2", 7, 800);

        ObservableList<SkrzyniaBiegow> skrzynie = FXCollections.observableArrayList(
                new SkrzyniaBiegow("Manualna standard", 45, 2500, sprzegloStandard),
                new SkrzyniaBiegow("Automatyczna", 65, 6000, sprzegloStandard2),
                new SkrzyniaBiegow("Sportowa", 40, 9000, sprzegloSport)
        );

        engineComboBox.setItems(silniki);
        gearboxComboBox.setItems(skrzynie);

        engineComboBox.getSelectionModel().selectFirst();
        gearboxComboBox.getSelectionModel().selectFirst();
    }

    private CarGui mainController;
    public void setMainController(CarGui mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        double weight;
        int speed;

        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }


        Silnik wybranySilnik = engineComboBox.getValue();
        SkrzyniaBiegow wybranaSkrzynia = gearboxComboBox.getValue();
        Pozycja pozycja = new Pozycja(0,0);

        Samochod samochod = new Samochod(registration,model,speed,pozycja,wybranySilnik,wybranaSkrzynia);
        mainController.dodajSamochod(samochod);

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}