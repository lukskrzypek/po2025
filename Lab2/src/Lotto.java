import java.util.Random;
import java.util.ArrayList;

public class Lotto {
    public static void main(String[] args) {

        ArrayList<Integer> liczby_podane = new ArrayList<Integer>();
        for (int i=0; i<args.length; i++) {
            liczby_podane.add(Integer.parseInt(args[i]));
        }

        ArrayList<Integer> liczby_losowe = new ArrayList<Integer>();
        Random losowa = new Random();

        /*

        ZAD 2

        while (liczby_losowe.size()<6){
            int losowa_tymczasowa=losowa.nextInt(49)+1;
            if (liczby_losowe.contains(losowa_tymczasowa)==false){
                liczby_losowe.add(losowa_tymczasowa);
            }
        }

        System.out.println("Twoje liczby: "+liczby_podane);
        System.out.println("Wylosowane liczby: "+liczby_losowe);

        liczby_losowe.retainAll(liczby_podane);
        System.out.println("Liczba trafień: "+liczby_losowe.size());
        */

        /*
        ZAD 3
         */

        int powtorzenia = 0;
        double czas= System.currentTimeMillis();
        do {
            liczby_losowe.clear();
            while (liczby_losowe.size()<6){
                int losowa_tymczasowa=losowa.nextInt(49)+1;
                if (liczby_losowe.contains(losowa_tymczasowa)==false){
                    liczby_losowe.add(losowa_tymczasowa);
                }
            }
            liczby_losowe.retainAll(liczby_podane);
            powtorzenia+=1;
        }
        while (liczby_losowe.size()!=6);
        czas=System.currentTimeMillis()-czas;

        System.out.println("Powtórzenia: "+powtorzenia);
        System.out.println("Czas: "+czas/1000);

    }
}