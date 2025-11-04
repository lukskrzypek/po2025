package symulator;

public class Samochod {
    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private float predkoscMax;
    private Pozycja aktualnaPozycja;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    public Samochod(String nrRejest, String model, float predkoscMax, Pozycja aktualnaPozycja, Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.aktualnaPozycja = aktualnaPozycja;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.stanWlaczenia = false;
    }

    public void wlacz(){
        this.silnik.uruchom();
    }
    public void wylacz(){
        this.silnik.zatrzymaj();
    }
    public void jedzDo(Pozycja cel){

    }
    public float getWaga(){

    }
    public float getAktPredkosc(){

    }

    public Pozycja getAktualnaPozycja() {
        return aktualnaPozycja;
    }
    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }
}
