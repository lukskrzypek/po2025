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
        this.aktualnePrzelozenie = 10;
    }

    public void zwiekszBieg(){
        if(sprzeglo.getStanSprzegla()){
            if (aktualnyBieg<iloscBiegow){
                aktualnyBieg++;
            }
        }
    }
    public void zmniejszBieg(){
        if (sprzeglo.getStanSprzegla()){
            if (aktualnyBieg>=1){
                aktualnyBieg--;
            }
        }
    }
    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public float getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }
}
