package symulator;

import java.util.ArrayList;
import java.util.List;

public class Samochod extends Thread{
    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private float predkoscMax;
    private Pozycja aktualnaPozycja;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Pozycja cel;
    private float waga;

    public Samochod(String nrRejest, String model, float predkoscMax, Pozycja aktualnaPozycja, Silnik silnik, SkrzyniaBiegow skrzynia, float waga) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.aktualnaPozycja = aktualnaPozycja;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.stanWlaczenia = false;
        this.waga = waga;
        this.start();
    }

    public void jedzDo(Pozycja nowyCel) {
        this.cel = nowyCel;
    }

    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (cel != null) {
                this.aktualnaPozycja.przemieszczenie(cel, (float) getAktPredkosc());
                // Sprawdzenie czy nasza pozycja to pozycja docelowa
                if (this.aktualnaPozycja.getX() == cel.getX() && this.aktualnaPozycja.getY() == cel.getY()) {
                    cel = null; // Zatrzymanie
                }
                notifyListeners();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }


    public void wlacz(){
        if (skrzynia.getSprzeglo().getStanSprzegla() && skrzynia.getAktualnyBieg()==0){
            this.silnik.uruchom();
        }
    }
    public void wylacz(){
        if (skrzynia.getAktualnyBieg()==0){
            this.silnik.zatrzymaj();
        }
    }
    public float getWaga(){
        return waga;
    }
    public float getAktPredkosc(){
        //Predkosc obliczana z przelozenia i obrotow
        float predkosc = predkoscMax*skrzynia.getAktualnePrzelozenie()*silnik.getObroty()/silnik.getMaxObroty();
        return predkosc;
    }

    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }
    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }
    public Silnik getSilnik() {
        return silnik;
    }
    public String getNrRejest() {
        return nrRejest;
    }
    public String getModel() {
        return model;
    }
    public float getPredkoscMax() {
        return predkoscMax;
    }

    //wyswietlanie poprawnej nazwy
    @Override
    public String toString() {
        return this.model;
    }
}
