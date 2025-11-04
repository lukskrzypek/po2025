package symulator;

public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = 0;
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }

    public void zwiekszBieg(){
        if (aktualnyBieg<iloscBiegow){
            aktualnyBieg++;
        }
    }
    public void zmniejszBieg(){
        if (aktualnyBieg>=2){
            aktualnyBieg--;
        }
    }
    public int getAktualnyBieg() {
        return aktualnyBieg;
    }
    public boolean getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

}
