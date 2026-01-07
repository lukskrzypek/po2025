package symulator;

public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, float waga, float cena, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = 0;
        this.iloscBiegow = 5;
        this.sprzeglo = sprzeglo;
        this.aktualnePrzelozenie = 0;
    }

    public void zwiekszBieg(){
        if(sprzeglo.getStanSprzegla()){
            if (aktualnyBieg<iloscBiegow){
                aktualnyBieg++;
                aktualnePrzelozenie = (float) aktualnyBieg/iloscBiegow;
            }
        }
    }
    public void zmniejszBieg(){
        if (sprzeglo.getStanSprzegla()){
            if (aktualnyBieg>=1){
                aktualnyBieg--;
                aktualnePrzelozenie = (float) aktualnyBieg/iloscBiegow;
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

    public int getIloscBiegow() {
        return iloscBiegow;
    }
}
