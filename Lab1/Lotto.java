import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        Random losowa = new Random();
        int[] liczby = new int[6];
        liczby[0]=losowa.nextInt(49)+1;
        System.out.println(liczby.length);
    }
}