import java.util.Random;
import java.util.ArrayList;

public class Lotto {
    public static void main(String[] args) {

        Random losowa = new Random();
        ArrayList<Integer> liczby = new ArrayList<Integer>();
        while (liczby.size()<6){}
            liczby.add(losowa.nextInt(49)+1);



    }
}