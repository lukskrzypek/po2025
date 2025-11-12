import symulator.Samochod;
import symulator.SkrzyniaBiegow;
import symulator.Silnik;
import symulator.Sprzeglo;
import symulator.Pozycja;

static void main() {
    Pozycja pozycja_test= new Pozycja(0,0);
    Sprzeglo sprzeglo_test = new Sprzeglo("sprzeglo_test", 10, 300 );
    SkrzyniaBiegow skrzynia_test = new SkrzyniaBiegow("skrzynia_test", 20, 500, 5, sprzeglo_test);
    Silnik silnik_test = new Silnik("silnik_test", 100, 1000, 5000);
    Samochod samochod_test = new Samochod("KR 12345", "test", 150, pozycja_test, silnik_test, skrzynia_test);

    samochod_test.wlacz();
    samochod_test.getSkrzynia().getSprzeglo().wcisnij();
    samochod_test.getSkrzynia().zwiekszBieg();
    samochod_test.getSkrzynia().zwiekszBieg();
    samochod_test.getSkrzynia().zwiekszBieg();
    samochod_test.getSkrzynia().zwiekszBieg();

    Pozycja cel= new Pozycja(20,15);
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());
    pozycja_test.przemieszczenie(cel, samochod_test.getAktPredkosc());

}