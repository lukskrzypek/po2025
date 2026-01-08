package org.example.gui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import symulator.*;

import java.io.IOException;


public class CarGui implements Listener {

    @FXML private Pane paneMapa;
    @FXML private VBox vboxCar;
    @FXML private ImageView imageCarView;
    @FXML private ComboBox<Samochod> comboBoxSamochody;

    @FXML private TextField textSamochodModel;
    @FXML private TextField textSamochodNrRejestracyjny;
    @FXML private TextField textSamochodWaga;
    @FXML private TextField textSamochodPredkosc;

    @FXML private TextField textSkrzyniaNazwa;
    @FXML private TextField textSkrzyniaCena;
    @FXML private TextField textSkrzyniaWaga;
    @FXML private TextField textSkrzyniaBieg;


    @FXML private TextField textSprzegloNazwa;
    @FXML private TextField textSprzegloCena;
    @FXML private TextField textSprzegloWaga;
    @FXML private TextField textSprzegloStan;

    @FXML private TextField textSilnikNazwa;
    @FXML private TextField textSilnikCena;
    @FXML private TextField textSilnikWaga;
    @FXML private TextField textSilnikObroty;

    Samochod samochod;

    private ObservableList<Samochod> samochody = FXCollections.observableArrayList();

    @FXML public void initialize() {
        Image carImage = new Image(getClass().getResource("/images/car.png").toExternalForm());
        imageCarView.setImage(carImage);

        imageCarView.setFitWidth(100);
        imageCarView.setFitHeight(100);

        imageCarView.setTranslateX(0);
        imageCarView.setTranslateY(0);



        comboBoxSamochody.setItems(samochody);
        comboBoxSamochody.setOnAction(event -> {
            samochod = comboBoxSamochody.getSelectionModel().getSelectedItem();
            refresh();
                    });
        //poruszanie sie samochodu
        paneMapa.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            samochod.jedzDo(new Pozycja(x, y));
        });
    }

    public void onWlacz(ActionEvent actionEvent) {
        samochod.wlacz();
        refresh();
    }

    public void onWylacz(ActionEvent actionEvent) {
        samochod.wylacz();
        refresh();
    }

    void refresh(){
        textSamochodModel.setText(String.valueOf(samochod.getModel()));
        textSamochodNrRejestracyjny.setText(String.valueOf(samochod.getNrRejest()));
        textSamochodWaga.setText(String.valueOf(samochod.getWaga()));
        textSamochodPredkosc.setText(String.valueOf(samochod.getAktPredkosc()));

        textSkrzyniaNazwa.setText(String.valueOf(samochod.getSkrzynia().getNazwa()));
        textSkrzyniaCena.setText(String.valueOf(samochod.getSkrzynia().getCena()));
        textSkrzyniaWaga.setText(String.valueOf(samochod.getSkrzynia().getWaga()));
        textSkrzyniaBieg.setText(String.valueOf(samochod.getSkrzynia().getAktualnyBieg()));

        textSprzegloNazwa.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getNazwa()));
        textSprzegloCena.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getCena()));
        textSprzegloWaga.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getWaga()));
        textSprzegloStan.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getStanSprzegla()));

        textSilnikNazwa.setText(String.valueOf(samochod.getSilnik().getNazwa()));
        textSilnikCena.setText(String.valueOf(samochod.getSilnik().getCena()));
        textSilnikWaga.setText(String.valueOf(samochod.getSilnik().getWaga()));
        textSilnikObroty.setText(String.valueOf(samochod.getSilnik().getObroty()));

        Platform.runLater(() -> {
            vboxCar.setTranslateX(samochod.getAktualnaPozycja().getX());
            vboxCar.setTranslateY(samochod.getAktualnaPozycja().getY());
        });

    }

    public void openAddCarWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));

        Parent root = loader.load();
        DodajSamochodController secondaryController = loader.getController();
        secondaryController.setMainController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setWidth(350);
        stage.setHeight(500);

        stage.setTitle("Dodaj nowy samochód");
        stage.show();
    }

    public void onUsunSamochod(ActionEvent actionEvent) {
        if (samochod != null) {
            samochod.removeListener(this);
        }
        samochody.remove(samochod);
        comboBoxSamochody.getSelectionModel().selectFirst();
        refresh();
    }

    public void dodajSamochod(Samochod nowySamochod) {
        nowySamochod.addListener(this);
        samochody.add(nowySamochod);
        comboBoxSamochody.getSelectionModel().select(nowySamochod);
        refresh();
    }


    public void onZwiekszBieg(ActionEvent actionEvent) {
        Silnik silnik = samochod.getSilnik();
        SkrzyniaBiegow skrzynia = samochod.getSkrzynia();
        if (skrzynia.getSprzeglo().getStanSprzegla()) {
            if (skrzynia.getAktualnyBieg() == 0) {
                skrzynia.zwiekszBieg();
            } else if (skrzynia.getAktualnyBieg() < skrzynia.getIloscBiegow() && silnik.getObroty()>silnik.getMaxObroty()*0.3) {
                float nowePrzelozenie = (float) (skrzynia.getAktualnyBieg() + 1) / skrzynia.getIloscBiegow();
                int doceloweObroty = (int) (silnik.getObroty() * skrzynia.getAktualnePrzelozenie() / nowePrzelozenie);
                if (doceloweObroty > silnik.getMinObroty()) {
                    skrzynia.zwiekszBieg();
                    silnik.zmniejszObroty(silnik.getObroty() - doceloweObroty);
                }
            }
        }
        refresh();
    }


    public void onZmniejszBieg(ActionEvent actionEvent) {
        Silnik silnik = samochod.getSilnik();
        SkrzyniaBiegow skrzynia = samochod.getSkrzynia();
        if (skrzynia.getSprzeglo().getStanSprzegla()){
            if(skrzynia.getAktualnyBieg()>1){
                float nowePrzelozenie = (float) (skrzynia.getAktualnyBieg()-1)/skrzynia.getIloscBiegow();
                int doceloweObroty= (int) (silnik.getObroty()*skrzynia.getAktualnePrzelozenie()/nowePrzelozenie);
                if(doceloweObroty<=silnik.getMaxObroty()) {
                    skrzynia.zmniejszBieg();
                    silnik.zwiekszObroty(doceloweObroty-silnik.getObroty());
                }
            } else if (skrzynia.getAktualnyBieg()==1) {
                if (silnik.getObroty() >= 0 && silnik.getObroty() <= silnik.getMinObroty()+500){
                    skrzynia.zmniejszBieg();
                    silnik.zmniejszObroty(silnik.getObroty()-silnik.getMinObroty());
                }
            }
        }
        refresh();
    }

    public void onDodajGazu(ActionEvent actionEvent) {
        if (!samochod.getSkrzynia().getSprzeglo().getStanSprzegla() && samochod.getSkrzynia().getAktualnyBieg() != 0) {
            if(samochod.getSilnik().getMaxObroty()-samochod.getSilnik().getObroty()<500) {
                samochod.getSilnik().zwiekszObroty(samochod.getSilnik().getMaxObroty()-samochod.getSilnik().getObroty());
            }else{
                samochod.getSilnik().zwiekszObroty(500);
            }

        }
        refresh();
    }

    public void onUjmijGazu(ActionEvent actionEvent) {
        if (!samochod.getSkrzynia().getSprzeglo().getStanSprzegla() && samochod.getSkrzynia().getAktualnyBieg() != 0){
            if (samochod.getSilnik().getObroty()-samochod.getSilnik().getMinObroty()<500){
                samochod.getSilnik().zmniejszObroty(samochod.getSilnik().getObroty()-samochod.getSilnik().getMinObroty());
            }else {
                samochod.getSilnik().zmniejszObroty(500);
            }

        }
        refresh();
    }

    public void onSprzegloNacisnij(ActionEvent actionEvent) {
        samochod.getSkrzynia().getSprzeglo().wcisnij();
        refresh();
    }

    public void onSprzegloZwolnij(ActionEvent actionEvent) {
        samochod.getSkrzynia().getSprzeglo().zwolnij();
        refresh();
    }

    @Override
    public void update() {
        refresh();
    }
}
