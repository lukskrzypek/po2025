package org.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import symulator.*;


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

    public Button zwiekszBiegButton;
    public Button zmniejszBiegButton;

    public TextField textSprzegloNazwa;
    public TextField textSprzegloCena;
    public TextField textSprzegloWaga;
    public TextField textSprzegloStan;

    public TextField textSilnikNazwa;
    public TextField textSilnikCena;
    public TextField textSilnikWaga;
    public TextField textSilnikObroty;

    public void onWlacz(ActionEvent actionEvent) {
        System.out.println("Wlacz");
    }

    public void onWylacz(ActionEvent actionEvent) {

    }

    public void dodajNowy(ActionEvent actionEvent) {
        String sprzegloNazwa = textSprzegloNazwa.getText();
        String sprzegloWagaString = textSprzegloWaga.getText();
        float sprzegloWaga = Float.parseFloat(sprzegloWagaString);
        String sprzegloCenaString = textSprzegloCena.getText();
        float sprzegloCena = Float.parseFloat(sprzegloCenaString);

        String skrzyniaNazwa = textSkrzyniaNazwa.getText();
        String skrzyniaWagaString = textSkrzyniaWaga.getText();
        float skrzyniaWaga =  Float.parseFloat(skrzyniaWagaString);
        String skrzyniaCenaString = textSkrzyniaCena.getText();
        float skrzyniaCena = Float.parseFloat(skrzyniaCenaString);

        String silnikNazwa = textSilnikNazwa.getText();
        String silnikWagaString = textSilnikWaga.getText();
        float silnikWaga = Float.parseFloat(silnikWagaString);
        String silnikCenaString = textSilnikCena.getText();
        float silnikCena = Float.parseFloat(silnikCenaString);
        String silnikObrotyString = textSilnikObroty.getText();
        int silnikObroty = Integer.parseInt(silnikObrotyString);

        String samochodNrRejest = textSamochodNrRejestracyjny.getText();
        String samochodModel = textSamochodModel.getText();
        String samochodPredkoscString = textSamochodPredkosc.getText();
        float samochodPredkosc = Float.parseFloat(samochodPredkoscString);
        Pozycja samochodPozycja = new Pozycja(0,0);



        Sprzeglo noweSprzeglo = new Sprzeglo(sprzegloNazwa, sprzegloWaga, sprzegloCena );
        SkrzyniaBiegow nowaSkrzynia = new SkrzyniaBiegow(skrzyniaNazwa, skrzyniaWaga, skrzyniaCena, noweSprzeglo);
        Silnik nowySilnik = new Silnik(silnikNazwa, silnikWaga, silnikCena, silnikObroty);
        Samochod nowySamochod = new Samochod(samochodNrRejest, samochodModel, samochodPredkosc, samochodPozycja, nowySilnik, nowaSkrzynia);



    }



}
