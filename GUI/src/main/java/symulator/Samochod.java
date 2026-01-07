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
        return skrzynia.getWaga()+silnik.getWaga()+700;
    }
    public float getAktPredkosc(){
        float predkosc = predkoscMax*skrzynia.getAktualnePrzelozenie()*silnik.getObroty()/silnik.getMaxObroty();
        if (predkosc>predkoscMax){
            return predkoscMax;
        }else {
            return predkosc;
        }
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
}
