package org.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class CarGui {

    public Button wlaczButton;
    public ComboBox comboBox_samochody;
    public Button wylaczButton;
    public TextField textSamochodModel;
    public TextField textSamochodNrRejestracyjny;
    public TextField textSamochodWaga;
    public TextField textSamochodPredkosc;
    public TextField textSkrzyniaNazwa;
    public TextField textSkrzyniaCena;
    public TextField textSkrzyniaWaga;
    public TextField textSkrzyniaBieg;

    public void onWlacz(ActionEvent actionEvent) {

    }

    public void onWylacz(ActionEvent actionEvent) {

    }

    /*@FXML
    public void initialize() {

        Pozycja pozycja_test= new Pozycja(0,0);
        Sprzeglo sprzeglo_test = new Sprzeglo("sprzeglo_test", 10, 300 );
        SkrzyniaBiegow skrzynia_test = new SkrzyniaBiegow("skrzynia_test", 20, 500, 5, sprzeglo_test);
        Silnik silnik_test = new Silnik("silnik_test", 100, 1000, 5000);
        Samochod samochod_test = new Samochod("KR 12345", "test", 150, pozycja_test, silnik_test, skrzynia_test);

    }

     */
}
