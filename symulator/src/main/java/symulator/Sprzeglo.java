package symulator;

public class Sprzeglo extends Komponent{
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, float waga, float cena) {
        super(nazwa, waga, cena);
        this.stanSprzegla = false;
    }
    public void wcisnij(){
        this.stanSprzegla = true;
    }
    public void zwolnij(){
        this.stanSprzegla = false;
    }
    public boolean getStanSprzegla() {
        return stanSprzegla;
    }
}
