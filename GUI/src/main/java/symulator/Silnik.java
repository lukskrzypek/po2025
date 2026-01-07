package symulator;

public class Silnik extends Komponent{
    private int maxObroty;
    private int obroty;
    private int minObroty;
    private boolean wlaczony;

    public Silnik(String nazwa, float waga, float cena, int maxObroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
        this.wlaczony = false;
        this.minObroty = 1000;
    }

    public void uruchom(){
        if (!wlaczony){
            this.obroty=minObroty;
            wlaczony=true;
        }
    }
    public void zatrzymaj(){
        if (wlaczony){
            this.obroty = 0;
            wlaczony=false;
        }
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

    public int getObroty() {
        return obroty;
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    public int getMinObroty() {
        return minObroty;
    }
}
