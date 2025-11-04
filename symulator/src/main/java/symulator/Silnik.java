package symulator;

public class Silnik extends Komponent{
    private int maxObroty;
    private int obroty;

    public Silnik(String nazwa, float waga, float cena, int maxObroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }

    public void uruchom(){
        this.obroty=1000;
    }
    public void zatrzymaj(){
        this.obroty = 0;
    }
    public void zwiekszObroty(int zwieksz){
        if(this.obroty+zwieksz<=this.maxObroty && zwieksz>0){
            this.obroty+=zwieksz;
        }
    }
    public void zmniejszObroty(int zmniejsz){
        if(this.obroty-zmniejsz>=0 && zmniejsz>0){
            this.obroty-=zmniejsz;
        }
    }
}
